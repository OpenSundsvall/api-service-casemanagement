package se.sundsvall.lantmateriet.registerbeteckning;

import io.quarkus.oidc.client.NamedOidcClient;
import io.quarkus.oidc.client.Tokens;

import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.HttpHeaders;

@RequestScoped
@Priority(Priorities.AUTHENTICATION)
public class RegisterbeteckningOAuth2Filter implements ClientRequestFilter {

    @Inject
    @NamedOidcClient("REGISTERBETECKNING")
    Tokens tokens;

    @Override
    public void filter(final ClientRequestContext requestContext) {
        requestContext.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + tokens.getAccessToken());
    }
}