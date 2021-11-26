package se.sundsvall;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfguid;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import se.sundsvall.exceptions.ApplicationException;
import se.sundsvall.sokigo.arendeexport.ArendeExportIntegrationService;
import se.sundsvall.sokigo.arendeexport.ByggrMapper;
import se.sundsvall.sokigo.fb.FbPropertyInfo;
import se.sundsvall.sokigo.minutmiljo.EcosMapper;
import se.sundsvall.util.CaseUtil;
import se.sundsvall.util.Constants;
import se.sundsvall.vo.*;
import se.tekis.servicecontract.SaveNewArendeMessage;
import se.tekis.servicecontract.SaveNewArendeResponse2;
import v1.datacontracts.minutmiljo.api.ecos.PartySvcDto;
import v1.datacontracts.minutmiljo.api.ecos.RegisterDocumentCaseResultSvcDto;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Tag(ref = "Cases")
@Path("/")
public class CaseResource {
    @Inject
    Logger log;

    @Inject
    CaseDao caseDao;

    @Inject
    ArendeExportIntegrationService arendeExportIntegrationService;

    @Inject
    ByggrMapper byggrMapper;

    @Inject
    EcosMapper ecosMapper;

    @Inject
    CaseUtil caseUtil;

    StringBuilder byggrAdminMessageSb;

    @POST
    @Path("cases")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(value = {
            @APIResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = Information.class))),
            @APIResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Information.class))),
            @APIResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = CaseResourceResponse.class)))})
    public Response postCases(@NotNull(message = "Request body must not be null") @Valid Case caseInput) throws JsonProcessingException, ApplicationException {

        // Validates that it doesn't exist any case with the same oep-ID.
        caseDao.validateUniqueCase(caseInput.getExternalCaseId());

        if (caseInput instanceof PlanningPermissionCase) {
            log.debug("instance of PlanningPermissionCase");

            // This StringBuilder is used to create a note on the case with information about potential manual actions that is needed.
            byggrAdminMessageSb = new StringBuilder();

            PlanningPermissionCase pCase = (PlanningPermissionCase) caseInput;

            // TODO - this is a temporary validation as long as API-version 1.1 i supported
            // Start of temporary
            Response res = temporaryValidationFacility(pCase.getFacility(), pCase.getFacilities());
            if (res != null) {
                return res;
            } else if (pCase.getFacility() != null && pCase.getFacilities() == null) {
                pCase.setFacilities(List.of(pCase.getFacility()));
            }
            // End of temporary

            byggrMapper.validate(pCase);

            SaveNewArendeMessage saveNewArendeMessage = new SaveNewArendeMessage();
            saveNewArendeMessage.setAnkomststamplaHandlingar(true);
            saveNewArendeMessage.setArende(byggrMapper.getByggrCase(pCase));
            saveNewArendeMessage.setHandlingar(byggrMapper.getByggrHandlingar(pCase));
            saveNewArendeMessage.setHandelse(byggrMapper.getByggrHandelse());
            saveNewArendeMessage.setHandlaggarSign(Constants.BYGGR_HANDLAGGAR_SIGN);

            SaveNewArendeResponse2 response = arendeExportIntegrationService.saveNewArende(saveNewArendeMessage);

            // If it's something that we should inform the administrator about, we create a new occurrence in the case.
            if (byggrMapper.containsControlOfficial(pCase.getStakeholders())) {
                writeEventNote(Constants.BYGGR_HANDELSE_ANTECKNING_KONTROLLANSVARIG);
            }
            if (byggrMapper.containsPersonDuplicates(pCase.getStakeholders())) {
                writeEventNote(Constants.BYGGR_HANDELSE_ANTECKNING_INTRESSENT_KUNDE_INTE_REGISTRERAS);
            }
            if (!byggrAdminMessageSb.toString().isEmpty()) {
                arendeExportIntegrationService.saveNewHandelse(byggrMapper.saveNewManuellHanteringHandelse(response.getDnr(), byggrAdminMessageSb.toString()));
            }

            caseDao.postCaseMapping(
                    new CaseMapping(pCase.getExternalCaseId(), response.getDnr(), SystemType.BYGGR));

            return Response.ok(new CaseResourceResponse(response.getDnr())).build();

        } else if (caseInput instanceof EnvironmentalCase) {

            log.debug("instance of EnvironmentalCase");

            EnvironmentalCase eCase = (EnvironmentalCase) caseInput;

            // TODO - this is a temporary validation as long as API-version 1.1 i supported
            // Start of temporary
            Response res = temporaryValidationFacility(eCase.getFacility(), eCase.getFacilities());
            if (res != null) {
                return res;
            } else if (eCase.getFacility() != null && eCase.getFacilities() == null) {
                eCase.setFacilities(List.of(eCase.getFacility()));
            }
            // End of temporary


            ecosMapper.validate(eCase);

            FbPropertyInfo propertyInfo = null;
            if (eCase.getFacilities().get(0).getAddress() != null && eCase.getFacilities().get(0).getAddress().getPropertyDesignation() != null) {
                // Collects this early to avoid creating something before we discover potential errors
                propertyInfo = caseUtil.getPropertyInfo(eCase.getFacilities().get(0).getAddress().getPropertyDesignation());
            }

            // Do requests to SearchParty for every stakeholder and collect these stakeholders to be able to add them
            // to the facility later.
            List<PartySvcDto> partyList = new ArrayList<>();

            // The stakeholder is stored with associated roles so that we can set roles later.
            HashMap<String, ArrayOfguid> partyRoles = new HashMap<>();

            // If the stakeholder is missing in Ecos, we keep it in this list and create them later (CreateParty)
            List<Stakeholder> missingStakeholders = new ArrayList<>();

            RegisterDocumentCaseResultSvcDto registerDocumentResult;

            // -----> SearchParty
            ecosMapper.searchParty(eCase, partyRoles, partyList, missingStakeholders);

            // -----> CreateParty
            ecosMapper.createParty(partyRoles, partyList, missingStakeholders);

            // -----> RegisterDocument
            registerDocumentResult = ecosMapper.registerDocument(eCase);

            // -----> AddPartyToCase
            ecosMapper.addPartyToCase(partyRoles, partyList, registerDocumentResult.getCaseId());

            if (propertyInfo != null) {
                // -----> CreateFoodFacility
                String foodFacilityGuid = ecosMapper.createFoodFacility(eCase, propertyInfo, registerDocumentResult);

                // -----> AddPartyToFacility
                ecosMapper.addPartyToFacility(partyRoles, partyList, foodFacilityGuid);
            } else {
                // -----> CreateOccurrenceOnCase
                ecosMapper.createOccurrenceOnCase(registerDocumentResult.getCaseId());
            }

            // Persist the connection between OeP-case and Ecos-case
            caseDao.postCaseMapping(new CaseMapping(eCase.getExternalCaseId(),
                    registerDocumentResult.getCaseId(), SystemType.ECOS));

            return Response.ok(new CaseResourceResponse(registerDocumentResult.getCaseNumber())).build();
        }
        return Response.status(Status.INTERNAL_SERVER_ERROR).build();
    }

    private void writeEventNote(String note) {
        if (!byggrAdminMessageSb.toString().contains(note)) {
            byggrAdminMessageSb.append(byggrAdminMessageSb.toString().isEmpty() ? "" : "\n").append(note);
        }
    }

    // TODO - this is a temporary validation as long as API-version 1.1 i supported
    private Response temporaryValidationFacility(Facility facility, List<?> facilities) {
        if (facility == null
                && (facilities == null || facilities.isEmpty())) {
            return Response.status(Status.BAD_REQUEST).entity(new Information(Constants.RFC_LINK_BAD_REQUEST, Status.BAD_REQUEST.getReasonPhrase(),
                    Status.BAD_REQUEST.getStatusCode(), "Both facility and facilities can't be null or empty.", null)).build();
        }
        if (facility != null && facilities != null) {
            return Response.status(Status.BAD_REQUEST).entity(new Information(Constants.RFC_LINK_BAD_REQUEST, Status.BAD_REQUEST.getReasonPhrase(),
                    Status.BAD_REQUEST.getStatusCode(), "facility and facilities can't be used at the same time.", null)).build();
        }

        return null;
    }
}
