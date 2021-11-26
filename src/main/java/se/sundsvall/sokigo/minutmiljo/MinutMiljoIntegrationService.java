package se.sundsvall.sokigo.minutmiljo;

import io.quarkiverse.cxf.annotation.CXFClient;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import se.sundsvall.util.NtlmAuthenticator;
import v1.datacontracts.minutmiljo.api.ecos.*;
import v1.service.minutmiljo.api.ecos.IMinutMiljoService;
import v2.datacontracts.minutmiljo.api.ecos.RegisterDocumentCaseSvcDtoV2;
import v2.service.minutmiljo.api.ecos.IMinutMiljoServiceV2;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.net.Authenticator;

@ApplicationScoped
public class MinutMiljoIntegrationService {

    @Inject
    @CXFClient("MINUTMILJO")
    IMinutMiljoService minutMiljoService;

    @Inject
    @CXFClient("MINUTMILJO-V2")
    IMinutMiljoServiceV2 minutMiljoserviceV2;

    @ConfigProperty(name = "minutmiljo.username")
    String username;

    @ConfigProperty(name = "minutmiljo.password")
    String password;

    @PostConstruct
    void configureClient() {
        // Disable chunking to make NTLM-authentication possible
        Client client = ClientProxy.getClient(minutMiljoService);
        HTTPConduit http = (HTTPConduit) client.getConduit();
        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(36000);
        httpClientPolicy.setAllowChunking(false);
        http.setClient(httpClientPolicy);

        Client clientV2 = ClientProxy.getClient(minutMiljoserviceV2);
        HTTPConduit httpV2 = (HTTPConduit) clientV2.getConduit();
        HTTPClientPolicy httpClientPolicyV2 = new HTTPClientPolicy();
        httpClientPolicyV2.setConnectionTimeout(36000);
        httpClientPolicyV2.setAllowChunking(false);
        httpV2.setClient(httpClientPolicyV2);

        // Set up authentication
        authenticate();
    }

    public ArrayOfPartySvcDto searchParty(SearchPartySvcDto searchPartyMsg) {
        return minutMiljoService.searchParty(searchPartyMsg);
    }

    public String createOrganizationParty(OrganizationSvcDto organizationSvcDto) {
        return minutMiljoService.createOrganizationParty(organizationSvcDto);
    }

    public String createPersonParty(PersonSvcDto personSvcDto) {
        return minutMiljoService.createPersonParty(personSvcDto);
    }

    public String createFoodFacility(CreateFoodFacilitySvcDto createFoodFacilitySvcDto) {
        return minutMiljoService.createFoodFacility(createFoodFacilitySvcDto);
    }

    public RegisterDocumentCaseResultSvcDto registerDocumentV2(
            RegisterDocumentCaseSvcDtoV2 registerDocumentCaseSvcDtoV2) {
        return minutMiljoserviceV2.registerDocument(registerDocumentCaseSvcDtoV2);
    }

    public void addPartyToFacility(AddPartyToFacilitySvcDto addPartyToFacilitySvcDto) {
        minutMiljoService.addPartyToFacility(addPartyToFacilitySvcDto);
    }

    public void addPartyToCase(AddPartyToCaseSvcDto addPartyToCaseSvcDto) {
        minutMiljoService.addPartyToCase(addPartyToCaseSvcDto);
    }

    public CaseSvcDto getCase(String caseId) {
        return minutMiljoService.getCase(caseId);
    }

    public void createOccurrenceOnCase(CreateOccurrenceOnCaseSvcDto createOccurrenceOnCaseSvcDto) {
        minutMiljoService.createOccurrenceOnCase(createOccurrenceOnCaseSvcDto);
    }

    public ArrayOfSearchCaseResultSvcDto searchCase(SearchCaseSvcDto searchCaseSvcDto) {
        return minutMiljoService.searchCase(searchCaseSvcDto);
    }

    /**
     * NTLM Authentication - server and Ecos
     */
    private void authenticate() {
        NtlmAuthenticator authenticator = new NtlmAuthenticator(username, password);
        Authenticator.setDefault(authenticator);
    }
}
