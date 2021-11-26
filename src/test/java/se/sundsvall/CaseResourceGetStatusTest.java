package se.sundsvall;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.filter.log.LogDetail;
import org.junit.jupiter.api.Test;
import se.sundsvall.sokigo.arendeexport.ArendeExportIntegrationService;
import se.sundsvall.sokigo.minutmiljo.MinutMiljoIntegrationService;
import se.sundsvall.util.Constants;
import se.sundsvall.vo.CaseMapping;
import se.sundsvall.vo.SystemType;
import se.tekis.arende.ArrayOfHandelse;
import se.tekis.arende.Handelse;
import se.tekis.servicecontract.Arende;
import se.tekis.servicecontract.ArrayOfArende1;
import v1.datacontracts.minutmiljo.api.ecos.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestHTTPEndpoint(CaseStatusResource.class)
@QuarkusTest
class CaseResourceGetStatusTest {

    private static final String BYGG_CASE_ID = "BYGG 2021-000200";
    private static final String ECOS_CASE_ID = "9d08772b-02cb-4b12-859d-2b3e5b9db008";

    @InjectMock
    ArendeExportIntegrationService arendeExportIntegrationService;

    @InjectMock
    MinutMiljoIntegrationService minutMiljoIntegrationService;

    @InjectMock
    CaseDao caseDaoMock;


    // getStatusByExternalCaseId

    @Test
    void testGetByggrStatusMultipleHandelse() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();
        Handelse handelse1 = new Handelse();
        handelse1.setStartDatum(LocalDateTime.of(2021, 9, 1, 0, 0, 0));
        handelse1.setHandelsetyp(Constants.BYGGR_HANDELSETYP_BESLUT);
        arrayOfHandelse.getHandelse().add(handelse1);

        Handelse handelse2 = new Handelse();
        handelse2.setStartDatum(LocalDateTime.of(2020, 8, 15, 0, 0, 0));
        handelse2.setHandelsetyp(Constants.BYGGR_HANDELSETYP_ANSOKAN);
        arrayOfHandelse.getHandelse().add(handelse2);

        Handelse handelse3 = new Handelse();
        handelse3.setStartDatum(LocalDateTime.of(2021, 8, 31, 0, 0, 0));
        handelse3.setHandelsetyp(Constants.BYGGR_HANDELSETYP_KOMPLETTERINGSFORELAGGANDE);
        arrayOfHandelse.getHandelse().add(handelse3);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        List<CaseMapping> caseMappingList = new ArrayList<>();
        CaseMapping caseMapping = new CaseMapping();
        caseMapping.setCaseId(BYGG_CASE_ID);
        String externalCaseId = String.valueOf(new Random().nextLong());
        caseMapping.setExternalCaseId(externalCaseId);
        caseMapping.setSystem(SystemType.BYGGR);

        caseMappingList.add(caseMapping);

        when(caseDaoMock.getCaseMapping(externalCaseId, null)).thenReturn(caseMappingList);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSETYP_KOMPLETTERINGSFORELAGGANDE));
    }

    @Test
    void testGetByggrStatusAmalan() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(2020, 8, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_ANMALAN);
        arrayOfHandelse.getHandelse().add(handelse);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSETYP_ANMALAN));
    }

    @Test
    void testGetByggrStatusAnsokan() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(2020, 8, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_ANSOKAN);
        arrayOfHandelse.getHandelse().add(handelse);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSETYP_ANSOKAN));
    }

    @Test
    void testGetByggrStatusSlutbesked() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(2020, 8, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_BESLUT);
        handelse.setHandelseslag(Constants.BYGGR_HANDELSESLAG_SLUTBESKED);
        arrayOfHandelse.getHandelse().add(handelse);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSESLAG_SLUTBESKED));
    }

    @Test
    void testGetByggrStatusAvskrivning() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(2020, 8, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_BESLUT);
        handelse.setHandelseslag(Constants.BYGGR_HANDELSESLAG_AVSKRIVNING);
        arrayOfHandelse.getHandelse().add(handelse);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSESLAG_AVSKRIVNING));
    }

    @Test
    void testGetByggrStatusKompletterandeHandlingar() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(2020, 8, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_HANDLING);
        handelse.setHandelseslag(Constants.BYGGR_HANDELSESLAG_KOMPLETTERANDE_HANDLINGAR);
        arrayOfHandelse.getHandelse().add(handelse);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSESLAG_KOMPLETTERANDE_HANDLINGAR));
    }

    @Test
    void testGetByggrStatusHandlaggarByte() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(1995, 9, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_ATOMHANDELSE);
        handelse.setHandelseslag(Constants.BYGGR_HANDELSESLAG_ATOM_KVITTENS);
        handelse.setHandelseutfall(Constants.BYGGR_HANDELSEUTFALL_ATOM_KVITTENS_HL_BYTE);
        arrayOfHandelse.getHandelse().add(handelse);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSEUTFALL_ATOM_KVITTENS_HL_BYTE));
    }

    @Test
    void testGetByggrStatusRemissUtskick() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(1995, 9, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_REMISS);
        handelse.setHandelseslag(Constants.BYGGR_HANDELSESLAG_UTSKICK_AV_REMISS);
        arrayOfHandelse.getHandelse().add(handelse);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSESLAG_UTSKICK_AV_REMISS));
    }

    @Test
    void testGetByggrStatusUnderrattelseMedKravPaSvar() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(1995, 9, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_UNDERRATTELSE);
        handelse.setHandelseslag(Constants.BYGGR_HANDELSESLAG_MED_KRAV_PA_SVAR);
        arrayOfHandelse.getHandelse().add(handelse);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSETYP_UNDERRATTELSE));
    }

    @Test
    void testGetByggrStatusUnderrattelseUtanKravPaSvar() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(1995, 9, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_UNDERRATTELSE);
        handelse.setHandelseslag(Constants.BYGGR_HANDELSESLAG_UTAN_KRAV_PA_SVAR);
        arrayOfHandelse.getHandelse().add(handelse);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSETYP_UNDERRATTELSE));
    }

    @Test
    void testGetByggrStatusKompletteringsforelaggandePaminnelse() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(1995, 9, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_KOMPLETTERINGSFORELAGGANDE_PAMINNELSE);
        arrayOfHandelse.getHandelse().add(handelse);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_HANDELSETYP_KOMPLETTERINGSFORELAGGANDE_PAMINNELSE));
    }

    @Test
    void testGetByggrStatusAvslutat() {
        Arende arende = new Arende();
        arende.setStatus(Constants.BYGGR_STATUS_AVSLUTAT);

        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();
        Handelse handelse1 = new Handelse();
        handelse1.setStartDatum(LocalDateTime.of(2020, 8, 15, 0, 0, 0));
        handelse1.setHandelsetyp(Constants.BYGGR_HANDELSETYP_ANSOKAN);
        Handelse handelse2 = new Handelse();
        handelse2.setStartDatum(LocalDateTime.of(2021, 8, 31, 0, 0, 0));
        handelse2.setHandelsetyp(Constants.BYGGR_HANDELSETYP_KOMPLETTERINGSFORELAGGANDE);

        arrayOfHandelse.getHandelse().add(handelse1);
        arrayOfHandelse.getHandelse().add(handelse2);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and().body(containsString(Constants.BYGGR_STATUS_AVSLUTAT));
    }

    @Test
    void testGetByggrStatusEmptyHandelse() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.NOT_FOUND.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_STATUS_NOT_FOUND));
    }

    @Test
    void testGetByggrStatusNoRelevantHandelse() {
        Arende arende = new Arende();
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();
        Handelse handelse1 = new Handelse();
        handelse1.setStartDatum(LocalDateTime.of(2021, 9, 1, 0, 0, 0));
        handelse1.setHandelsetyp(Constants.BYGGR_HANDELSETYP_BESLUT);
        Handelse handelse2 = new Handelse();
        handelse2.setStartDatum(LocalDateTime.of(1995, 9, 15, 0, 0, 0));
        handelse2.setHandelsetyp(Constants.BYGGR_HANDELSETYP_ATOMHANDELSE);
        handelse2.setHandelseslag(Constants.BYGGR_HANDELSESLAG_ATOM_KVITTENS);

        arrayOfHandelse.getHandelse().add(handelse1);
        arrayOfHandelse.getHandelse().add(handelse2);

        arende.setHandelseLista(arrayOfHandelse);

        when(arendeExportIntegrationService.getArende(any())).thenReturn(arende);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, BYGG_CASE_ID, SystemType.BYGGR);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.NOT_FOUND.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_STATUS_NOT_FOUND));
    }

    @Test
    void testGetStatusNoCasesFound() {
        String externalCaseId = String.valueOf(new Random().nextLong());

        List<CaseMapping> caseMappingList = new ArrayList<>();

        when(caseDaoMock.getCaseMapping(externalCaseId, null)).thenReturn(caseMappingList);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.NOT_FOUND.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_CASES_NOT_FOUND));
    }

    @Test
    void testGetStatusMoreThanOneCasesFound() {
        List<CaseMapping> caseMappingList = new ArrayList<>();
        CaseMapping caseMapping1 = new CaseMapping();
        caseMapping1.setCaseId(BYGG_CASE_ID);
        String externalCaseId = String.valueOf(new Random().nextLong());
        caseMapping1.setExternalCaseId(externalCaseId);
        caseMapping1.setSystem(SystemType.BYGGR);

        caseMappingList.add(caseMapping1);

        CaseMapping caseMapping2 = new CaseMapping();
        caseMapping2.setCaseId("BYGG 2021-000201");
        caseMapping2.setExternalCaseId(externalCaseId);
        caseMapping2.setSystem(SystemType.BYGGR);

        caseMappingList.add(caseMapping2);

        when(caseDaoMock.getCaseMapping(externalCaseId, null)).thenReturn(caseMappingList);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.INTERNAL_SERVER_ERROR.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_UNHANDLED_EXCEPTION));

    }

    @Test
    void testGetEcosStatusMultipleOccurences() {
        CaseSvcDto theCase = new CaseSvcDto();
        theCase.setCaseId(ECOS_CASE_ID);

        ArrayOfOccurrenceListItemSvcDto arrayOfOccurrence = new ArrayOfOccurrenceListItemSvcDto();
        OccurrenceListItemSvcDto occurrence1 = new OccurrenceListItemSvcDto();
        occurrence1.setOccurrenceDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        occurrence1.setOccurrenceDescription("Anmälan");
        arrayOfOccurrence.getOccurrenceListItemSvcDto().add(occurrence1);

        OccurrenceListItemSvcDto occurrence2 = new OccurrenceListItemSvcDto();
        occurrence2.setOccurrenceDate(LocalDateTime.of(2020, 1, 18, 0, 0, 0));
        occurrence2.setOccurrenceDescription("Avslutat");
        arrayOfOccurrence.getOccurrenceListItemSvcDto().add(occurrence2);

        OccurrenceListItemSvcDto occurrence3 = new OccurrenceListItemSvcDto();
        occurrence3.setOccurrenceDate(LocalDateTime.of(2020, 1, 10, 0, 0, 0));
        occurrence3.setOccurrenceDescription("Expediering");
        arrayOfOccurrence.getOccurrenceListItemSvcDto().add(occurrence3);

        theCase.setOccurrences(arrayOfOccurrence);

        when(minutMiljoIntegrationService.getCase(ECOS_CASE_ID)).thenReturn(theCase);

        String externalCaseId = String.valueOf(new Random().nextLong());

        mockGetCaseMapping(externalCaseId, ECOS_CASE_ID, SystemType.ECOS);

        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("Avslutat"));

    }

    // getStatusByOrgNr

    @Test
    void testGetOrganizationStatusByggr() {

        ArrayOfArende1 arrayOfByggrArende = new ArrayOfArende1();
        Arende byggrArende = new Arende();
        byggrArende.setDnr(BYGG_CASE_ID);
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse = new Handelse();
        handelse.setStartDatum(LocalDateTime.of(2020, 8, 15, 0, 0, 0));
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_ANSOKAN);
        arrayOfHandelse.getHandelse().add(handelse);
        byggrArende.setHandelseLista(arrayOfHandelse);

        arrayOfByggrArende.getArende().add(byggrArende);
        when(arendeExportIntegrationService.getRelateradeArendenByPersOrgNrAndRole(any(), any(), any())).thenReturn(arrayOfByggrArende);

        String organizationNumber = "121212-1234";

        given().contentType(MediaType.APPLICATION_JSON).when().get("/organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString(Constants.BYGGR_HANDELSETYP_ANSOKAN));

    }

    @Test
    void testGetOrganizationStatusByggrStatusNotFound() {

        ArrayOfArende1 arrayOfByggrArende = new ArrayOfArende1();
        Arende byggrArende = new Arende();
        byggrArende.setDnr(BYGG_CASE_ID);

        arrayOfByggrArende.getArende().add(byggrArende);
        when(arendeExportIntegrationService.getRelateradeArendenByPersOrgNrAndRole(any(), any(), any())).thenReturn(arrayOfByggrArende);

        String organizationNumber = "121212-1234";

        given().contentType(MediaType.APPLICATION_JSON).when().get("/organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.NOT_FOUND.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_STATUS_NOT_FOUND));

    }

    @Test
    void testGetOrganizationStatusEcosStatus() {

        ArrayOfPartySvcDto searchPartyResult = new ArrayOfPartySvcDto();
        PartySvcDto party = new PartySvcDto();
        party.setId("9e02f50f-d3c9-4d9b-82e6-511ba6143733");
        searchPartyResult.getPartySvcDto().add(party);
        when(minutMiljoIntegrationService.searchParty(any())).thenReturn(searchPartyResult);

        ArrayOfSearchCaseResultSvcDto searchCaseResult = new ArrayOfSearchCaseResultSvcDto();
        SearchCaseResultSvcDto ecosArende = new SearchCaseResultSvcDto();
        ecosArende.setCaseId("8939df65-8b18-496b-a2d1-91cdcfea7d1a");

        searchCaseResult.getSearchCaseResultSvcDto().add(ecosArende);
        when(minutMiljoIntegrationService.searchCase(any())).thenReturn(searchCaseResult);

        CaseSvcDto theCase = new CaseSvcDto();
        theCase.setCaseId(ECOS_CASE_ID);

        ArrayOfOccurrenceListItemSvcDto arrayOfOccurrence = new ArrayOfOccurrenceListItemSvcDto();
        OccurrenceListItemSvcDto occurrence1 = new OccurrenceListItemSvcDto();
        occurrence1.setOccurrenceDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        occurrence1.setOccurrenceDescription("Anmälan");
        arrayOfOccurrence.getOccurrenceListItemSvcDto().add(occurrence1);

        theCase.setOccurrences(arrayOfOccurrence);

        when(minutMiljoIntegrationService.getCase(any())).thenReturn(theCase);

        String organizationNumber = "121212-1234";

        given().contentType(MediaType.APPLICATION_JSON).when().get("/organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("Anmälan"));

    }

    @Test
    void testGetOrganizationStatusEcosStatusNotFound1() {

        ArrayOfPartySvcDto searchPartyResult = new ArrayOfPartySvcDto();
        PartySvcDto party = new PartySvcDto();
        party.setId("9e02f50f-d3c9-4d9b-82e6-511ba6143733");
        searchPartyResult.getPartySvcDto().add(party);
        when(minutMiljoIntegrationService.searchParty(any())).thenReturn(searchPartyResult);

        String organizationNumber = "121212-1234";

        given().contentType(MediaType.APPLICATION_JSON).when().get("/organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.NOT_FOUND.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_STATUS_NOT_FOUND));

    }

    @Test
    void testGetOrganizationStatusEcosStatusNotFound2() {

        ArrayOfPartySvcDto searchPartyResult = new ArrayOfPartySvcDto();
        PartySvcDto party = new PartySvcDto();
        party.setId("9e02f50f-d3c9-4d9b-82e6-511ba6143733");
        searchPartyResult.getPartySvcDto().add(party);
        when(minutMiljoIntegrationService.searchParty(any())).thenReturn(searchPartyResult);

        ArrayOfSearchCaseResultSvcDto searchCaseResult = new ArrayOfSearchCaseResultSvcDto();
        SearchCaseResultSvcDto ecosArende = new SearchCaseResultSvcDto();
        ecosArende.setCaseId("8939df65-8b18-496b-a2d1-91cdcfea7d1a");
        searchCaseResult.getSearchCaseResultSvcDto().add(ecosArende);
        when(minutMiljoIntegrationService.searchCase(any())).thenReturn(searchCaseResult);

        String organizationNumber = "121212-1234";

        given().contentType(MediaType.APPLICATION_JSON).when().get("/organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.NOT_FOUND.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_STATUS_NOT_FOUND));

    }

    @Test
    void testGetOrganizationStatusNotFound1() {

        String organizationNumber = "121212-1234";

        given().contentType(MediaType.APPLICATION_JSON).when().get("/organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.NOT_FOUND.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_STATUS_NOT_FOUND));

    }

    @Test
    void testGetOrganizationStatusNotFound2() {

        ArrayOfPartySvcDto searchPartyResult = new ArrayOfPartySvcDto();
        when(minutMiljoIntegrationService.searchParty(any())).thenReturn(searchPartyResult);

        ArrayOfSearchCaseResultSvcDto searchCaseResult = new ArrayOfSearchCaseResultSvcDto();
        when(minutMiljoIntegrationService.searchCase(any())).thenReturn(searchCaseResult);

        ArrayOfArende1 arrayOfByggrArende = new ArrayOfArende1();
        when(arendeExportIntegrationService.getRelateradeArendenByPersOrgNrAndRole(any(), any(), any())).thenReturn(arrayOfByggrArende);

        String organizationNumber = "121212-1234";

        given().contentType(MediaType.APPLICATION_JSON).when().get("/organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.NOT_FOUND.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_STATUS_NOT_FOUND));

    }

    @Test
    void testGetOrganizationStatusNotFound3() {

        ArrayOfPartySvcDto searchPartyResult = new ArrayOfPartySvcDto();
        PartySvcDto party = new PartySvcDto();
        party.setId("9e02f50f-d3c9-4d9b-82e6-511ba6143733");
        searchPartyResult.getPartySvcDto().add(party);
        when(minutMiljoIntegrationService.searchParty(any())).thenReturn(searchPartyResult);

        ArrayOfSearchCaseResultSvcDto searchCaseResult = new ArrayOfSearchCaseResultSvcDto();
        when(minutMiljoIntegrationService.searchCase(any())).thenReturn(searchCaseResult);

        ArrayOfArende1 arrayOfByggrArende = new ArrayOfArende1();
        when(arendeExportIntegrationService.getRelateradeArendenByPersOrgNrAndRole(any(), any(), any())).thenReturn(arrayOfByggrArende);

        String organizationNumber = "121212-1234";

        given().contentType(MediaType.APPLICATION_JSON).when().get("/organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.NOT_FOUND.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_STATUS_NOT_FOUND));

    }

    @Test
    void testGetOrganizationStatus() {

        ArrayOfArende1 arrayOfByggrArende = new ArrayOfArende1();
        Arende byggrArende = new Arende();
        byggrArende.setDnr(BYGG_CASE_ID);
        ArrayOfHandelse arrayOfHandelse = new ArrayOfHandelse();

        Handelse handelse1 = new Handelse();
        handelse1.setStartDatum(LocalDateTime.of(2020, 8, 15, 0, 0, 0));
        handelse1.setHandelsetyp(Constants.BYGGR_HANDELSETYP_ANSOKAN);
        arrayOfHandelse.getHandelse().add(handelse1);

        Handelse handelse2 = new Handelse();
        handelse2.setStartDatum(LocalDateTime.of(2020, 8, 15, 0, 0, 1));
        handelse2.setHandelsetyp(Constants.BYGGR_HANDELSETYP_BESLUT);
        handelse2.setHandelseslag(Constants.BYGGR_HANDELSESLAG_SLUTBESKED);
        arrayOfHandelse.getHandelse().add(handelse2);

        byggrArende.setHandelseLista(arrayOfHandelse);

        arrayOfByggrArende.getArende().add(byggrArende);
        when(arendeExportIntegrationService.getRelateradeArendenByPersOrgNrAndRole(any(), any(), any())).thenReturn(arrayOfByggrArende);

        ArrayOfPartySvcDto searchPartyResult = new ArrayOfPartySvcDto();
        PartySvcDto party = new PartySvcDto();
        party.setId("9e02f50f-d3c9-4d9b-82e6-511ba6143733");
        searchPartyResult.getPartySvcDto().add(party);
        when(minutMiljoIntegrationService.searchParty(any())).thenReturn(searchPartyResult);

        ArrayOfSearchCaseResultSvcDto searchCaseResult = new ArrayOfSearchCaseResultSvcDto();
        SearchCaseResultSvcDto ecosArende = new SearchCaseResultSvcDto();
        ecosArende.setCaseId(ECOS_CASE_ID);

        searchCaseResult.getSearchCaseResultSvcDto().add(ecosArende);
        when(minutMiljoIntegrationService.searchCase(any())).thenReturn(searchCaseResult);

        CaseSvcDto theCase = new CaseSvcDto();
        theCase.setCaseId(ECOS_CASE_ID);

        ArrayOfOccurrenceListItemSvcDto arrayOfOccurrence = new ArrayOfOccurrenceListItemSvcDto();
        OccurrenceListItemSvcDto occurrence1 = new OccurrenceListItemSvcDto();
        occurrence1.setOccurrenceDate(LocalDateTime.of(2020, 1, 1, 0, 0, 0));
        occurrence1.setOccurrenceDescription("Anmälan");
        arrayOfOccurrence.getOccurrenceListItemSvcDto().add(occurrence1);

        OccurrenceListItemSvcDto occurrence2 = new OccurrenceListItemSvcDto();
        occurrence2.setOccurrenceDate(LocalDateTime.of(2020, 1, 1, 0, 0, 1));
        occurrence2.setOccurrenceDescription("Komplettering");
        arrayOfOccurrence.getOccurrenceListItemSvcDto().add(occurrence2);

        theCase.setOccurrences(arrayOfOccurrence);

        when(minutMiljoIntegrationService.getCase(any())).thenReturn(theCase);

        List<CaseMapping> byggrCaseMappingList = new ArrayList<>();
        CaseMapping byggrCaseMapping = new CaseMapping();
        byggrCaseMapping.setCaseId(BYGG_CASE_ID);
        String byggrExternalCaseId = String.valueOf(new Random().nextLong());
        byggrCaseMapping.setExternalCaseId(byggrExternalCaseId);
        byggrCaseMapping.setSystem(SystemType.BYGGR);

        byggrCaseMappingList.add(byggrCaseMapping);

        when(caseDaoMock.getCaseMapping(null, BYGG_CASE_ID)).thenReturn(byggrCaseMappingList);

        List<CaseMapping> ecosCaseMappingList = new ArrayList<>();
        CaseMapping ecosCaseMapping = new CaseMapping();
        ecosCaseMapping.setCaseId(ECOS_CASE_ID);
        String ecosExternalCaseId = String.valueOf(new Random().nextLong());
        ecosCaseMapping.setExternalCaseId(ecosExternalCaseId);
        ecosCaseMapping.setSystem(SystemType.ECOS);

        ecosCaseMappingList.add(ecosCaseMapping);

        when(caseDaoMock.getCaseMapping(null, ECOS_CASE_ID)).thenReturn(ecosCaseMappingList);

        String organizationNumber = "121212-1234";

        given().contentType(MediaType.APPLICATION_JSON).when().get("/organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat()
                .body(containsString(Constants.BYGGR_HANDELSESLAG_SLUTBESKED))
                .and().body(containsString("Komplettering"))
                .and().body(containsString(byggrExternalCaseId))
                .and().body(containsString(ecosExternalCaseId));
    }

    private void mockGetCaseMapping(String externalCaseId, String caseId, SystemType systemType) {
        List<CaseMapping> caseMappingList = new ArrayList<>();
        CaseMapping caseMapping = new CaseMapping();
        caseMapping.setCaseId(caseId);
        caseMapping.setExternalCaseId(externalCaseId);
        caseMapping.setSystem(systemType);

        caseMappingList.add(caseMapping);

        when(caseDaoMock.getCaseMapping(externalCaseId, null)).thenReturn(caseMappingList);
    }

}
