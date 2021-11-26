package se.sundsvall;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;
import se.sundsvall.exceptions.ApplicationException;
import se.sundsvall.sokigo.arendeexport.ArendeExportIntegrationService;
import se.sundsvall.sokigo.arendeexport.ByggrMapper;
import se.sundsvall.sokigo.minutmiljo.EcosMapper;
import se.sundsvall.sokigo.minutmiljo.MinutMiljoIntegrationService;
import se.sundsvall.util.CaseUtil;
import se.sundsvall.util.Constants;
import se.sundsvall.vo.CaseMapping;
import se.sundsvall.vo.CaseStatus;
import se.sundsvall.vo.Information;
import se.sundsvall.vo.SystemType;

import javax.inject.Inject;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Tag(ref = "Status")
@Path("/")
public class CaseStatusResource {

    @Inject
    ArendeExportIntegrationService arendeExportIntegrationService;

    @Inject
    MinutMiljoIntegrationService minutMiljoIntegrationService;

    @Inject
    ByggrMapper byggrMapper;

    @Inject
    EcosMapper ecosMapper;

    @Inject
    CaseUtil caseUtil;

    @Inject
    CaseDao caseDao;

    @Inject
    Logger log;

    @GET
    @Path("organization/{organizationNumber}/cases/status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatusByOrgNr(@Pattern(regexp = Constants.ORGNR_PATTERN_REGEX, message = Constants.ORGNR_PATTERN_MESSAGE)
                                     @Schema(description = "Organisationsnummer bestående av 10 eller 12 siffror.", example = "19901010-1234")
                                     @PathParam("organizationNumber") String organizationNumber) {

        List<CaseStatus> caseStatusList = new ArrayList<>();

        caseStatusList.addAll(byggrMapper.getByggrStatusByOrgNr(organizationNumber));
        caseStatusList.addAll(ecosMapper.getEcosStatusByOrgNr(organizationNumber));

        if (caseStatusList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new Information(Constants.RFC_LINK_NOT_FOUND, Response.Status.NOT_FOUND.getReasonPhrase(),
                            Response.Status.NOT_FOUND.getStatusCode(), Constants.ERR_MSG_STATUS_NOT_FOUND, null))
                    .build();
        }

        return Response.ok(caseStatusList).build();
    }


    @GET
    @Path("cases/{externalCaseId}/status")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStatusByExternalCaseId(@PathParam("externalCaseId") String externalCaseId) throws ApplicationException {
        List<CaseMapping> caseMappingList = caseDao.getCaseMapping(externalCaseId, null);

        if (caseMappingList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new Information(Constants.RFC_LINK_NOT_FOUND, Response.Status.NOT_FOUND.getReasonPhrase(),
                            Response.Status.NOT_FOUND.getStatusCode(), Constants.ERR_MSG_CASES_NOT_FOUND, null))
                    .build();
        } else if (caseMappingList.size() > 1) {
            throw new ApplicationException("More than one case was found with the same externalCaseId: \"" + externalCaseId + "\". This should not be possible.");
        }

        CaseMapping caseMapping = caseMappingList.get(0);

        String status;
        SystemType system;

        if (SystemType.BYGGR.equals(caseMapping.getSystem())) {
            status = byggrMapper.getByggrStatus(arendeExportIntegrationService.getArende(caseMapping.getCaseId()));
            system = SystemType.BYGGR;
        } else if (SystemType.ECOS.equals(caseMapping.getSystem())) {
            status = ecosMapper.getStatus(caseMapping.getCaseId());
            system = SystemType.ECOS;
        } else {
            throw new ApplicationException("This SystemType was not expected: \"" + caseMapping.getSystem() + "\". Found with externalCaseId: \"" + externalCaseId + "\".");
        }

        if (status == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new Information(Constants.RFC_LINK_NOT_FOUND, Response.Status.NOT_FOUND.getReasonPhrase(),
                            Response.Status.NOT_FOUND.getStatusCode(), Constants.ERR_MSG_STATUS_NOT_FOUND, null))
                    .build();
        } else {
            CaseStatus caseStatus = new CaseStatus();
            caseStatus.setStatus(status);
            caseStatus.setCaseId(caseMapping.getCaseId());
            caseStatus.setExternalCaseId(caseMapping.getExternalCaseId());
            caseStatus.setSystem(system);

            return Response.ok(caseStatus).build();
        }
    }

}
