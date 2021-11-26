package se.sundsvall;

import org.eclipse.microprofile.openapi.annotations.Operation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class WelcomeResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Operation(hidden = true, summary = "Welcome")
    public Response welcome() {

        return Response
                .ok("\n" + "                                                                                 \r\n"
                        + "   _/          _/  _/_/_/_/  _/          _/_/_/    _/_/    _/      _/  _/_/_/_/   \r\n"
                        + "  _/          _/  _/        _/        _/        _/    _/  _/_/  _/_/  _/          \r\n"
                        + " _/    _/    _/  _/_/_/    _/        _/        _/    _/  _/  _/  _/  _/_/_/       \r\n"
                        + "  _/  _/  _/    _/        _/        _/        _/    _/  _/      _/  _/            \r\n"
                        + "   _/  _/      _/_/_/_/  _/_/_/_/    _/_/_/    _/_/    _/      _/  _/_/_/_/       \r\n"
                        + "                                                                                  \r\n"
                        + " Go to /q/openapi to get the OpenAPI-specification of this API.")
                .build();
    }
}
