package se.sundsvall.sundsvall.citizenmapping;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/1.0")
@RegisterProvider(CitizenMappingOAuth2Filter.class)
@RegisterRestClient(configKey = "CITIZEN-MAPPING")
@ApplicationScoped
public interface CitizenMappingService {

    @GET
    @Path("/citizenmapping/{personId}/personalnumber")
    @Produces(MediaType.TEXT_PLAIN)
    String getPersonalNumber(@PathParam String personId);
}
