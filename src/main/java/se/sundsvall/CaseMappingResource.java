package se.sundsvall;

import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import se.sundsvall.util.Constants;
import se.sundsvall.vo.CaseMapping;
import se.sundsvall.vo.Information;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Tag(ref = "CaseMapping")
@Path("/cases/case-mappings")
public class CaseMappingResource {

    @Inject
    CaseDao caseDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(
            value = {@APIResponse(
                    responseCode = "200", description = "OK",
                    content = @Content(schema = @Schema(implementation = CaseMapping.class)))}
    )
    public Response getCaseMapping(@QueryParam("external-case-id") String externalCaseId) {

        List<CaseMapping> caseMappingList = caseDao.getCaseMapping(externalCaseId, null);

        if (caseMappingList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new Information(Constants.RFC_LINK_NOT_FOUND, Response.Status.NOT_FOUND.getReasonPhrase(),
                            Response.Status.NOT_FOUND.getStatusCode(), Constants.ERR_MSG_CASEMAPPINGS_NOT_FOUND, null))
                    .build();
        }

        return Response.ok(caseMappingList).build();
    }

}
