package se.sundsvall.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import se.sundsvall.sundsvall.citizenmapping.CitizenMappingErrorResponse;
import se.sundsvall.sundsvall.citizenmapping.CitizenMappingService;
import se.sundsvall.sokigo.fb.FbPropertyInfo;
import se.sundsvall.sokigo.fb.FbService;
import se.sundsvall.sokigo.fb.ResponseDto;
import se.sundsvall.lantmateriet.registerbeteckning.RegisterbeteckningService;
import se.sundsvall.lantmateriet.registerbeteckning.Registerbeteckningsreferens;
import se.sundsvall.vo.Information;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.List;

@ApplicationScoped
public class CaseUtil {

    @ConfigProperty(name = "fb.username")
    String fbUsername;
    @ConfigProperty(name = "fb.password")
    String fbPassword;

    @Inject
    Logger log;

    private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @Inject
    @RestClient
    RegisterbeteckningService registerbeteckningService;

    @Inject
    @RestClient
    FbService fbService;

    @Inject
    @RestClient
    CitizenMappingService citizenMappingService;


    public FbPropertyInfo getPropertyInfo(String propertyDesignation) {
        propertyDesignation = propertyDesignation.trim().toUpperCase();

        FbPropertyInfo propertyInfo = new FbPropertyInfo();

        List<Registerbeteckningsreferens> registerbeteckningsreferenser = registerbeteckningService
                .getReferenser(propertyDesignation, Constants.LANTMATERIET_REFERENS_STATUS_GALLANDE, 1);

        // Set FNR if the propertyDesignation in the response matches the request
        if (registerbeteckningsreferenser != null && !registerbeteckningsreferenser.isEmpty()
                && registerbeteckningsreferenser.get(0).getBeteckning().equalsIgnoreCase(propertyDesignation)) {

            ResponseDto fnrResponse = fbService.getPropertyInfo(
                    List.of(registerbeteckningsreferenser.get(0).getRegisterenhet()), Constants.FB_DATABASE,
                    fbUsername, fbPassword);

            if (fnrResponse != null && fnrResponse.getData() != null && !fnrResponse.getData().isEmpty()
                    && fnrResponse.getData().get(0).getFnr() != null) {

                propertyInfo.setFnr(fnrResponse.getData().get(0).getFnr());

                ResponseDto addressResponse = fbService.getAddressInfo(
                        List.of(registerbeteckningsreferenser.get(0).getRegisterenhet()), Constants.FB_DATABASE,
                        fbUsername, fbPassword);

                if (addressResponse != null && addressResponse.getData() != null && !addressResponse.getData().isEmpty()
                        && addressResponse.getData().get(0).getGrupp() != null
                        && !addressResponse.getData().get(0).getGrupp().isEmpty()
                        && addressResponse.getData().get(0).getGrupp().get(0).getAdressplatsId() != null) {
                    propertyInfo.setAddressId(addressResponse.getData().get(0).getGrupp().get(0).getAdressplatsId());
                }

                if (propertyInfo.getFnr() != null) {
                    return propertyInfo;
                }

            }
        }

        // If we reach this code, we did not find the right property
        throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                .entity(new Information(Constants.RFC_LINK_BAD_REQUEST, Response.Status.BAD_REQUEST.getReasonPhrase(),
                        Response.Status.BAD_REQUEST.getStatusCode(),
                        Constants.ERR_MSG_PROPERTY_DESIGNATION_NOT_FOUND(propertyDesignation),
                        "facility.address.propertyDesignation"))
                .build());

    }

    public byte[] base64ToByteArray(String base64) {

        byte[] decoded;

        if (base64.startsWith("data:")) {
            base64 = base64.substring(base64.indexOf(",") + 1);
        }

        decoded = Base64.getDecoder().decode(base64.getBytes());

        return decoded;
    }

    /**
     * Returns null if personId is null
     */
    public String getPersonalNumber(String personId) throws JsonProcessingException {
        String personalNumber = null;

        if (personId != null) {
            try {
                personalNumber = citizenMappingService.getPersonalNumber(personId);
            } catch (WebApplicationException e) {

                if (e.getResponse().getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
                    throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                            .entity(new Information(Constants.RFC_LINK_BAD_REQUEST,
                                    Response.Status.BAD_REQUEST.getReasonPhrase(), Response.Status.BAD_REQUEST.getStatusCode(),
                                    Constants.ERR_MSG_PERSONAL_NUMBER_NOT_FOUND_WITH_PERSON_ID(personId), null))
                            .build());

                } else {
                    CitizenMappingErrorResponse response = e.getResponse()
                            .readEntity(CitizenMappingErrorResponse.class);
                    log.error("Something went wrong in the request to citizenMappingService.getPersonalNumber("
                            + personId + "). Response from CitizenMapping:\nHTTP " + e.getResponse().getStatus() + " "
                            + mapper.writeValueAsString(e.getResponse().getStatusInfo()) + "\n"
                            + mapper.writeValueAsString(e.getResponse().getMetadata()) + "\n"
                            + mapper.writeValueAsString(response));

                    throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(new Information(Constants.RFC_LINK_INTERNAL_SERVER_ERROR,
                                    Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                                    Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                                    Constants.ERR_MSG_EXTERNAL_SERVICE, null))
                            .build());

                }
            }
        }
        return personalNumber;
    }

    public String getCompletedOrganizationNumber(String organizationNumber) {
        // The length is 1 more than the number of numbers because the text contains a hyphen
        if (organizationNumber.length() == 13) {
            return organizationNumber;
        } else if (organizationNumber.length() == 11) {
            return "16" + organizationNumber;
        } else {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity(new Information(Constants.RFC_LINK_BAD_REQUEST, Response.Status.BAD_REQUEST.getReasonPhrase(),
                            Response.Status.BAD_REQUEST.getStatusCode(),
                            "organizationNumber must consist of 10 or 12 digits",
                            "organizationNumber"))
                    .build());
        }
    }

}
