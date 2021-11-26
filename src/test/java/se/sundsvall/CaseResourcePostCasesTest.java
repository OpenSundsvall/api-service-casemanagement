package se.sundsvall;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.filter.log.LogDetail;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sundsvall.lantmateriet.registerbeteckning.RegisterbeteckningService;
import se.sundsvall.lantmateriet.registerbeteckning.Registerbeteckningsreferens;
import se.sundsvall.sokigo.arendeexport.ArendeExportIntegrationService;
import se.sundsvall.sokigo.fb.AdressplatsIdentifierDto;
import se.sundsvall.sokigo.fb.FastighetDto;
import se.sundsvall.sokigo.fb.FbService;
import se.sundsvall.sokigo.fb.ResponseDto;
import se.sundsvall.sokigo.minutmiljo.MinutMiljoIntegrationService;
import se.sundsvall.sundsvall.citizenmapping.CitizenMappingErrorResponse;
import se.sundsvall.sundsvall.citizenmapping.CitizenMappingService;
import se.sundsvall.util.Constants;
import se.sundsvall.vo.*;
import se.tekis.servicecontract.SaveNewArendeResponse2;
import v1.datacontracts.minutmiljo.api.ecos.ArrayOfPartySvcDto;
import v1.datacontracts.minutmiljo.api.ecos.RegisterDocumentCaseResultSvcDto;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@TestHTTPEndpoint(CaseResource.class)
@QuarkusTest
class CaseResourcePostCasesTest {

    private static final String BYGG_CASE_ID = "BYGG 2021-000200";
    private static final String ECOS_CASE_NUMBER = "MK-2021-837";
    private static final String ECOS_CASE_ID = "9d08772b-02cb-4b12-859d-2b3e5b9db008";
    private static final String PROPERTY_DESIGNATION = "SUNDSVALL FILLA 8:185";
    private static final String PERSON_ID = "a56296af-9298-46fc-a6fe-ca214847f718";
    private static final String ORG_NUMBER = "123456-1234";

    @InjectMock
    @RestClient
    RegisterbeteckningService registerbeteckningService;

    @InjectMock
    @RestClient
    CitizenMappingService citizenMappingService;

    @InjectMock
    @RestClient
    FbService fbService;

    @InjectMock
    MinutMiljoIntegrationService minutMiljoIntegrationService;

    @InjectMock
    ArendeExportIntegrationService arendeExportIntegrationService;

    @Inject
    CaseDao caseDao;

    static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @BeforeAll
    static void beforeAll() {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @BeforeEach
    void beforeEach() {
        // Minutmiljö mocks
        when(minutMiljoIntegrationService.searchParty(any())).thenReturn(new ArrayOfPartySvcDto());
        when(minutMiljoIntegrationService.createPersonParty(any())).thenReturn("123");
        when(minutMiljoIntegrationService.createOrganizationParty(any())).thenReturn("321");
        RegisterDocumentCaseResultSvcDto registerDocumentCaseResultSvcDto = new RegisterDocumentCaseResultSvcDto();
        registerDocumentCaseResultSvcDto.setCaseId(ECOS_CASE_ID);
        registerDocumentCaseResultSvcDto.setCaseNumber(ECOS_CASE_NUMBER);
        when(minutMiljoIntegrationService.registerDocumentV2(any()))
                .thenReturn(registerDocumentCaseResultSvcDto);
        when(minutMiljoIntegrationService.createFoodFacility(any())).thenReturn("111111111111");
        // when(minutMiljoIntegrationService.addPartyToCase(any()));

        // ByggR mocks
        SaveNewArendeResponse2 saveNewArendeResult = new SaveNewArendeResponse2();
        saveNewArendeResult.setDnr(BYGG_CASE_ID);
        when(arendeExportIntegrationService.saveNewArende(any())).thenReturn(saveNewArendeResult);

        // Lantmäteriet mocks
        List<Registerbeteckningsreferens> registerbeteckningsreferenser = new ArrayList<>();
        Registerbeteckningsreferens registerbeteckningsreferens = new Registerbeteckningsreferens();
        registerbeteckningsreferens.setBeteckning(PROPERTY_DESIGNATION);
        registerbeteckningsreferens.setBeteckningsid("ny-4020855");
        registerbeteckningsreferens.setRegisterenhet("909a6a80-8add-90ec-e040-ed8f66444c3f");
        registerbeteckningsreferenser.add(registerbeteckningsreferens);
        when(registerbeteckningService.getReferenser(anyString(),
                eq(Constants.LANTMATERIET_REFERENS_STATUS_GALLANDE), eq(1)))
                .thenReturn(registerbeteckningsreferenser);

        // FbService mocks
        ResponseDto fnrFbResponseDto = new ResponseDto();
        FastighetDto fnrFbFastighetDto = new FastighetDto();
        fnrFbFastighetDto.setFnr(22045604);
        fnrFbResponseDto.setData(List.of(fnrFbFastighetDto));

        when(fbService.getPropertyInfo(any(), any(), any(), any())).thenReturn(fnrFbResponseDto);

        ResponseDto adressFbResponseDto = new ResponseDto();
        FastighetDto adressFbFastighetDto = new FastighetDto();
        AdressplatsIdentifierDto adressplatsIdentifierDto = new AdressplatsIdentifierDto();
        adressplatsIdentifierDto.setAdressplatsId(90022392);
        adressFbFastighetDto.setGrupp(List.of(adressplatsIdentifierDto));
        adressFbResponseDto.setData(List.of(adressFbFastighetDto));

        when(fbService.getAddressInfo(any(), any(), any(), any())).thenReturn(adressFbResponseDto);

        // Citizen-mapping mocks
        when(citizenMappingService.getPersonalNumber(anyString())).thenReturn("19910101-1234");
    }

    ////////////////////////////////////////////////////////////////
    // ECOS //
    ////////////////////////////////////////////////////////////////

    @Test
    void testEcosNormalCase() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        List<Address> addresses = new ArrayList<>();
        Address orgAddress = new Address();
        orgAddress.setStreet("Testvägen");
        orgAddress.setHouseNumber("123");
        orgAddress.setCity("Sundsvall");
        orgAddress.setCountry("Sweden");
        orgAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses.add(orgAddress);
        organization.setAddresses(addresses);
        sList.add(organization);

        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        List<StakeholderRole> srList2 = new ArrayList<>();
        srList2.add(StakeholderRole.CONTACT_PERSON);
        person.setRoles(srList2);
        person.setPersonId(PERSON_ID);
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        sList.add(person);

        Person person2 = new Person();
        person2.setType(StakeholderType.PERSON);
        List<StakeholderRole> srList3 = new ArrayList<>();
        srList3.add(StakeholderRole.CONTACT_PERSON);
        person2.setRoles(srList3);
        person2.setFirstName("firstName2");
        person2.setLastName("lastName2");
        person2.setCellphoneNumber("060121213");
        person2.setPhoneNumber("0701231213");
        person2.setEmailAddress("test2@test.se");
        sList.add(person2);

        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(address);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        // Testar att startDate kan vara bakåt i tiden
        eCase.setStartDate(LocalDate.now().minusDays(10));
        // Testar att endDate kan vara dagens datum
        eCase.setEndDate(LocalDate.now());
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and()
                .body(containsString(ECOS_CASE_NUMBER));

        verifyPersistanceEcos(eCase.getExternalCaseId(), true);

        verify(minutMiljoIntegrationService, times(2)).searchParty(any());
        verify(minutMiljoIntegrationService, times(1)).createOrganizationParty(any());
        verify(minutMiljoIntegrationService, times(2)).createPersonParty(any());
        verify(minutMiljoIntegrationService, times(1)).createFoodFacility(any());
        verify(minutMiljoIntegrationService, times(3)).addPartyToFacility(any());
        verify(minutMiljoIntegrationService, times(3)).addPartyToCase(any());
        verify(minutMiljoIntegrationService, times(1)).registerDocumentV2(any());

    }

    @Test
    void testEcosMissingFacilityAddress() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        List<Address> addresses = new ArrayList<>();
        Address orgAddress = new Address();
        orgAddress.setStreet("Testvägen");
        orgAddress.setHouseNumber("123");
        orgAddress.setCity("Sundsvall");
        orgAddress.setCountry("Sweden");
        orgAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses.add(orgAddress);
        organization.setAddresses(addresses);
        sList.add(organization);

        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);

        // Testar att startDate kan vara bakåt i tiden
        eCase.setStartDate(LocalDate.now().minusDays(10));
        // Testar att endDate kan vara dagens datum
        eCase.setEndDate(LocalDate.now());
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and()
                .body(containsString(ECOS_CASE_NUMBER));

        verifyPersistanceEcos(eCase.getExternalCaseId(), true);

        verify(minutMiljoIntegrationService, times(1)).searchParty(any());
        verify(minutMiljoIntegrationService, times(1)).createOrganizationParty(any());
        verify(minutMiljoIntegrationService, times(1)).addPartyToCase(any());
        verify(minutMiljoIntegrationService, times(1)).registerDocumentV2(any());
        verify(minutMiljoIntegrationService, times(1)).createOccurrenceOnCase(any());

        // Om facility inte har någon address så ska vi inte registrera någon anläggning och därmed inte heller
        // koppla någon intressent till anläggning.
        // Det blir manuell hantering för handläggaren.
        verify(minutMiljoIntegrationService, times(0)).createPersonParty(any());
        verify(minutMiljoIntegrationService, times(0)).createFoodFacility(any());
        verify(minutMiljoIntegrationService, times(0)).addPartyToFacility(any());
    }

    @Test
    void testEcosMissingFacilityPropertyDesignation() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        List<Address> addresses = new ArrayList<>();
        Address orgAddress = new Address();
        orgAddress.setStreet("Testvägen");
        orgAddress.setHouseNumber("123");
        orgAddress.setCity("Sundsvall");
        orgAddress.setCountry("Sweden");
        orgAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses.add(orgAddress);
        organization.setAddresses(addresses);
        sList.add(organization);

        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address facilityAddress = new Address();
        facilityAddress.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        facility.setAddress(facilityAddress);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);

        // Testar att startDate kan vara bakåt i tiden
        eCase.setStartDate(LocalDate.now().minusDays(10));
        // Testar att endDate kan vara dagens datum
        eCase.setEndDate(LocalDate.now());
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString("must not be blank")).and()
                .body(containsString("propertyDesignation"));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();
    }


    @Test
    void testEcosWrongEndDate() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        List<Address> addresses = new ArrayList<>();
        Address orgAddress = new Address();
        orgAddress.setStreet("Testvägen");
        orgAddress.setHouseNumber("123");
        orgAddress.setCity("Sundsvall");
        orgAddress.setCountry("Sweden");
        orgAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses.add(orgAddress);
        organization.setAddresses(addresses);
        sList.add(organization);

        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address address = new Address();
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(address);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        // Testar att endDate inte kan vara bakåt i tiden
        eCase.setEndDate(LocalDate.now().minusDays(1));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_THIS_DATE_MUST_BE_TODAY_OR_FUTURE));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();

    }

    @Test
    void testEcosEndDateBeforeStartDate() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        List<Address> addresses = new ArrayList<>();
        Address orgAddress = new Address();
        orgAddress.setStreet("Testvägen");
        orgAddress.setHouseNumber("123");
        orgAddress.setCity("Sundsvall");
        orgAddress.setCountry("Sweden");
        orgAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses.add(orgAddress);
        organization.setAddresses(addresses);
        sList.add(organization);

        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address address = new Address();
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(address);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        // Testar att startDate inte kan vara efter endDate
        eCase.setStartDate(LocalDate.now().plusDays(1));
        eCase.setEndDate(LocalDate.now());
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_START_MUST_BE_BEFORE_END));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();

    }

    @Test
    void testEcosStakeholderWithoutPnr() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();

        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        List<StakeholderRole> srList2 = new ArrayList<>();
        srList2.add(StakeholderRole.CONTACT_PERSON);
        person.setRoles(srList2);
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        sList.add(person);

        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(address);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and()
                .body(containsString(ECOS_CASE_NUMBER));

        verifyPersistanceEcos(eCase.getExternalCaseId(), true);

        verify(minutMiljoIntegrationService, times(0)).searchParty(any());
        verify(minutMiljoIntegrationService, times(0)).createOrganizationParty(any());
        verify(minutMiljoIntegrationService, times(1)).createPersonParty(any());
        verify(minutMiljoIntegrationService, times(1)).createFoodFacility(any());
        verify(minutMiljoIntegrationService, times(1)).addPartyToFacility(any());
        verify(minutMiljoIntegrationService, times(1)).addPartyToCase(any());
        verify(minutMiljoIntegrationService, times(1)).registerDocumentV2(any());

    }


    @Test
    void testEcosWrongStakeholderRole() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.APPLICANT);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        sList.add(organization);
        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(address);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat().body(containsString(
                        Constants.ERR_MSG_WRONG_ROLE_ENV_CASE));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();
    }

    @Test
    void testEcosAddressIdNull() throws JsonProcessingException {

        ResponseDto adressFbResponseDto = new ResponseDto();

        when(fbService.getAddressInfo(any(), any(), any(), any())).thenReturn(adressFbResponseDto);

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        sList.add(organization);
        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(address);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and()
                .body(containsString(ECOS_CASE_NUMBER));

        verifyPersistanceEcos(eCase.getExternalCaseId(), true);

        verify(minutMiljoIntegrationService, times(1)).searchParty(any());
        verify(minutMiljoIntegrationService, times(1)).createOrganizationParty(any());
        verify(minutMiljoIntegrationService, times(0)).createPersonParty(any());
        verify(minutMiljoIntegrationService, times(1)).createFoodFacility(any());
        verify(minutMiljoIntegrationService, times(1)).addPartyToFacility(any());
        verify(minutMiljoIntegrationService, times(1)).addPartyToCase(any());
        verify(minutMiljoIntegrationService, times(1)).registerDocumentV2(any());

    }

    @Test
    void testEcosFnrNull() throws JsonProcessingException {

        ResponseDto fnrFbResponseDto = new ResponseDto();
        FastighetDto fnrFbFastighetDto = new FastighetDto();
        fnrFbResponseDto.setData(List.of(fnrFbFastighetDto));

        when(fbService.getPropertyInfo(any(), any(), any(), any())).thenReturn(fnrFbResponseDto);

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        sList.add(organization);
        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(address);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat().body(containsString(
                        Constants.ERR_MSG_PROPERTY_DESIGNATION_NOT_FOUND(PROPERTY_DESIGNATION)));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();
    }

    @Test
    void testEcosMissingStakeholder() throws JsonProcessingException {
        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat()
                .body(containsString("must not be empty")).and().body(containsString("stakeholders"));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();

    }

    @Test
    void testEcosMissingFacilityCollectionName() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        List<Address> addresses = new ArrayList<>();
        Address orgAddress = new Address();
        orgAddress.setStreet("Testvägen");
        orgAddress.setHouseNumber("123");
        orgAddress.setCity("Sundsvall");
        orgAddress.setCountry("Sweden");
        orgAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses.add(orgAddress);
        organization.setAddresses(addresses);
        sList.add(organization);

        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        Address address = new Address();
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(address);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString("must not be blank"))
                .and().body(containsString("facilityCollectionName"))
                .and().body(containsString("must not be empty"))
                .and().body(containsString("addressCategories"));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();

    }

    @Test
    void testEcosMissingFacility() throws JsonProcessingException {
        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        sList.add(organization);
        eCase.setStakeholders(sList);
        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        // TODO - needs to be adjusted when "facility" not is supported anymore and the temporary validation is removed
        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat()
                .body(containsString("Both facility and facilities can't be null or empty.")).and().body(containsString("facility"));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();
    }

    /*
    Testfall med minimalt antal parametrar på alla objekt
     */
    @Test
    void testEcosMinimalCase() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setName("Document Name");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);

        sList.add(organization);

        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        List<StakeholderRole> srList2 = new ArrayList<>();
        srList2.add(StakeholderRole.INVOICE_RECIPENT);
        person.setRoles(srList2);
        person.setFirstName("Förnamn");
        person.setLastName("Efternamn");

        sList.add(person);

        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address facilityAddress = new Address();
        facilityAddress.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        facilityAddress.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(facilityAddress);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and()
                .body(containsString(ECOS_CASE_NUMBER));

        verifyPersistanceEcos(eCase.getExternalCaseId(), true);

        verify(minutMiljoIntegrationService, times(1)).searchParty(any());
        verify(minutMiljoIntegrationService, times(1)).createOrganizationParty(any());
        verify(minutMiljoIntegrationService, times(1)).createPersonParty(any());
        verify(minutMiljoIntegrationService, times(1)).createFoodFacility(any());
        verify(minutMiljoIntegrationService, times(2)).addPartyToFacility(any());
        verify(minutMiljoIntegrationService, times(2)).addPartyToCase(any());
        verify(minutMiljoIntegrationService, times(1)).registerDocumentV2(any());
    }

    @Test
    void testEcosMissingAddressCategories() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setName("Document Name");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        Address orgAddress = new Address();
        organization.setAddresses(List.of(orgAddress));

        sList.add(organization);

        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        List<StakeholderRole> srList2 = new ArrayList<>();
        srList2.add(StakeholderRole.INVOICE_RECIPENT);
        person.setRoles(srList2);
        person.setFirstName("Förnamn");
        person.setLastName("Efternamn");
        Address personAddress = new Address();
        personAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS));
        person.setAddresses(List.of(personAddress));

        sList.add(person);

        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address facilityAddress = new Address();
        facilityAddress.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        facilityAddress.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(facilityAddress);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString("must not be empty")).and()
                .body(containsString("postCases.caseInput.stakeholders[0].addresses[0].addressCategories"));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);
        verifyNoEcosMethodWasCalled();
    }


    @Test
    void testEcosPropertyDesignationNotFound() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        sList.add(organization);
        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation("SUNDSVALL FILLA 8:18");
        facility.setAddress(address);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat()
                .body(containsString(Constants.ERR_MSG_PROPERTY_DESIGNATION_NOT_FOUND(eCase.getFacilities().get(0).getAddress().getPropertyDesignation())));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();
    }

    @Test
    void testEcosMaximumOneFacility() throws JsonProcessingException {

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.OPERATOR);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);
        sList.add(organization);
        eCase.setStakeholders(sList);

        EnvironmentalFacility facility1 = new EnvironmentalFacility();
        facility1.setFacilityCollectionName("facilityCollectionName");
        Address address1 = new Address();
        address1.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address1.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility1.setAddress(address1);

        EnvironmentalFacility facility2 = new EnvironmentalFacility();
        facility2.setFacilityCollectionName("facilityCollectionName2");
        Address address2 = new Address();
        address2.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address2.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility2.setAddress(address2);
        eCase.setFacilities(List.of(facility1, facility2));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat()
                .body(containsString("size must be 1"))
                .and().body(containsString("facilities"));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();
    }

    @Test
    void testEcosCitizenMapping404() throws JsonProcessingException {

        CitizenMappingErrorResponse citizenMappingErrorResponse = new CitizenMappingErrorResponse();
        citizenMappingErrorResponse.setStatus(Status.NOT_FOUND.getStatusCode());
        citizenMappingErrorResponse.setTitle(Status.NOT_FOUND.getReasonPhrase());
        citizenMappingErrorResponse.setTraceId("00-1f5c4c8a517e2a4b9742fbaf631654e1-946ca92a4c74fa43-00");
        citizenMappingErrorResponse.setType(Constants.RFC_LINK_NOT_FOUND);

        // Citizen-mapping mocks
        when(citizenMappingService.getPersonalNumber(anyString())).thenThrow(new WebApplicationException(
                Response.status(Status.NOT_FOUND).entity(citizenMappingErrorResponse).build()));

        EnvironmentalCase eCase = new EnvironmentalCase();
        List<Attachment> aList = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANMALAN_LIVSMEDELSANLAGGNING);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("name");
        attachment.setNote("note");
        attachment.setFile(TestConstants.BASE64_STRING);
        aList.add(attachment);
        eCase.setAttachments(aList);

        List<Stakeholder> sList = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.CONTACT_PERSON);
        person.setRoles(srList);
        person.setPersonId(PERSON_ID);
        person.setFirstName("firstName");
        person.setLastName("lastName");
        sList.add(person);
        eCase.setStakeholders(sList);

        EnvironmentalFacility facility = new EnvironmentalFacility();
        facility.setFacilityCollectionName("facilityCollectionName");
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(address);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat()
                .body(containsString(Constants.ERR_MSG_PERSONAL_NUMBER_NOT_FOUND_WITH_PERSON_ID(PERSON_ID)));

        verifyPersistanceEcos(eCase.getExternalCaseId(), false);

        verifyNoEcosMethodWasCalled();
    }

    ////////////////////////////////////////////////////////////////
    // ByggR //
    ////////////////////////////////////////////////////////////////

    @Test
    void testByggrNormalCase() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);
        stakeholders.add(person);

        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.PROPERTY_OWNER);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);

        List<Address> addresses = new ArrayList<>();
        Address orgAddress = new Address();
        orgAddress.setStreet("Testvägen");
        orgAddress.setHouseNumber("123");
        orgAddress.setCity("Sundsvall");
        orgAddress.setCountry("Sweden");
        orgAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses.add(orgAddress);
        organization.setAddresses(addresses);

        stakeholders.add(organization);
        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and().body(containsString(BYGG_CASE_ID));

        verifyPersistanceByggr(pCase.getExternalCaseId(), true);

        verify(arendeExportIntegrationService, times(1)).saveNewArende(any());
        verify(arendeExportIntegrationService, times(0)).saveNewHandelse(any());
    }

    @Test
    void testByggrMultipleMainFacilities400() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility1 = new PlanningPermissionFacility();
        planningPermissionFacility1.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        planningPermissionFacility1.setMainFacility(true);
        Address address1 = new Address();
        address1.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address1.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility1.setAddress(address1);

        PlanningPermissionFacility planningPermissionFacility2 = new PlanningPermissionFacility();
        planningPermissionFacility2.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        planningPermissionFacility2.setMainFacility(true);
        Address address2 = new Address();
        address2.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address2.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility2.setAddress(address2);

        pCase.setFacilities(List.of(planningPermissionFacility1, planningPermissionFacility2));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);

        stakeholders.add(person);
        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString(Constants.ERR_MSG_ONLY_ONE_MAIN_FACILITY)).and().body(containsString("postCases.caseInput.facilities"));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);
        verifyNoByggrMethodWasCalled();
    }

    @Test
    void testByggrMissingFacilities400() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);

        stakeholders.add(person);
        pCase.setStakeholders(stakeholders);

        // TODO - needs to be adjusted when "facility" not is supported anymore and the temporary validation is removed
        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString("Both facility and facilities can't be null or empty."));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);
        verifyNoByggrMethodWasCalled();
    }

    // TODO - needs to be removed when "facility" not is supported anymore and the temporary validation is removed
    @Test
    void testByggrFacilityAndFacilitiesSameTime400() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);

        stakeholders.add(person);
        pCase.setStakeholders(stakeholders);

        PlanningPermissionFacility facility = new PlanningPermissionFacility();
        facility.setFacilityType(FacilityType.CARPORT);
        pCase.setFacilities(List.of(facility));

        pCase.setFacility(facility);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString("facility and facilities can't be used at the same time."));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);
        verifyNoByggrMethodWasCalled();
    }

    // TODO - needs to be removed when "facility" not is supported anymore
    @Test
    void testByggrOldFacilityObject() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);

        stakeholders.add(person);
        pCase.setStakeholders(stakeholders);

        PlanningPermissionFacility facility = new PlanningPermissionFacility();
        facility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        facility.setMainFacility(true);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(address);
        pCase.setFacility(facility);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString(BYGG_CASE_ID));

        verifyPersistanceByggr(pCase.getExternalCaseId(), true);
        verify(arendeExportIntegrationService, times(1)).saveNewArende(any());
        verify(arendeExportIntegrationService, times(0)).saveNewHandelse(any());
    }

    @Test
    void testByggrMissingFacilityType400() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);

        stakeholders.add(person);
        pCase.setStakeholders(stakeholders);

        pCase.setFacilities(List.of(new PlanningPermissionFacility()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString("must not be null")).and().body(containsString("postCases.caseInput.facilities[0].facilityType"));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);
        verifyNoByggrMethodWasCalled();
    }



    @Test
    void testByggrPersonWithNoId() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);
        stakeholders.add(person);

        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString("must not be blank"));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);
        verifyNoByggrMethodWasCalled();
    }

    @Test
    void testByggrInvalidOrgNr() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();

        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.PROPERTY_OWNER);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber("17123456-1234");

        List<Address> addresses = new ArrayList<>();
        Address orgAddress = new Address();
        orgAddress.setStreet("Testvägen");
        orgAddress.setHouseNumber("123");
        orgAddress.setCity("Sundsvall");
        orgAddress.setCountry("Sweden");
        orgAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses.add(orgAddress);
        organization.setAddresses(addresses);

        stakeholders.add(organization);
        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat()
                .body(containsString("organizationNumber must consist of 10 or 12 digits"));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);

        verifyNoByggrMethodWasCalled();
    }

    @Test
    void testByggrAdressIdNull() throws JsonProcessingException {

        ResponseDto adressFbResponseDto = new ResponseDto();
        FastighetDto adressFbFastighetDto = new FastighetDto();
        AdressplatsIdentifierDto adressplatsIdentifierDto = new AdressplatsIdentifierDto();
        adressFbFastighetDto.setGrupp(List.of(adressplatsIdentifierDto));
        adressFbResponseDto.setData(List.of(adressFbFastighetDto));

        when(fbService.getAddressInfo(any(), any(), any(), any())).thenReturn(adressFbResponseDto);

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);
        stakeholders.add(person);
        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString(BYGG_CASE_ID));

        verifyPersistanceByggr(pCase.getExternalCaseId(), true);

        verify(arendeExportIntegrationService, times(1)).saveNewArende(any());
        verify(arendeExportIntegrationService, times(0)).saveNewHandelse(any());

    }

    @Test
    void testByggrControlOfficial() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.INVOICE_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.CONTROL_OFFICIAL);
        person.setRoles(roles);
        stakeholders.add(person);
        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and()
                .body(containsString(BYGG_CASE_ID));

        verify(arendeExportIntegrationService, times(1)).saveNewArende(any());
        verify(arendeExportIntegrationService, times(1)).saveNewHandelse(any());

        verifyPersistanceByggr(pCase.getExternalCaseId(), true);
    }

    @Test
    void testByggrDoublePerson() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);
        stakeholders.add(person);

        Person person2 = new Person();
        person2.setType(StakeholderType.PERSON);
        person2.setFirstName("Test");
        person2.setLastName("Testorsson");
        person2.setPersonId(PERSON_ID);
        List<StakeholderRole> roles2 = new ArrayList<>();
        roles2.add(StakeholderRole.PAYMENT_PERSON);
        person2.setRoles(roles2);
        stakeholders.add(person2);

        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and()
                .body(containsString(BYGG_CASE_ID));

        verify(arendeExportIntegrationService, times(1)).saveNewArende(any());
        verify(arendeExportIntegrationService, times(1)).saveNewHandelse(any());

        verifyPersistanceByggr(pCase.getExternalCaseId(), true);

    }

    @Test
    void testByggrMissingFacilityAddress() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);
        stakeholders.add(person);

        Person person2 = new Person();
        person2.setType(StakeholderType.PERSON);
        person2.setFirstName("Test");
        person2.setLastName("Testorsson");
        person2.setPersonId(PERSON_ID);
        List<StakeholderRole> roles2 = new ArrayList<>();
        roles2.add(StakeholderRole.PAYMENT_PERSON);
        person2.setRoles(roles2);
        stakeholders.add(person2);

        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat()
                .body(containsString("must not be null")).and()
                .body(containsString("facilities[0].address"));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);

        verifyNoByggrMethodWasCalled();

    }

    @Test
    void testByggrMissingPropertyDesignation() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);
        stakeholders.add(person);

        Person person2 = new Person();
        person2.setType(StakeholderType.PERSON);
        person2.setFirstName("Test");
        person2.setLastName("Testorsson");
        person2.setPersonId(PERSON_ID);
        List<StakeholderRole> roles2 = new ArrayList<>();
        roles2.add(StakeholderRole.PAYMENT_PERSON);
        person2.setRoles(roles2);
        stakeholders.add(person2);

        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat()
                .body(containsString("must not be blank")).and()
                .body(containsString("propertyDesignation"));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);

        verifyNoByggrMethodWasCalled();

    }

    @Test
    void testByggrWrongStakeholderRole() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.CONTACT_PERSON);
        roles.add(StakeholderRole.OPERATOR);
        person.setRoles(roles);
        stakeholders.add(person);
        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat().body(containsString(
                        Constants.ERR_MSG_WRONG_ROLE_PLANNING_CASE));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);

        verifyNoByggrMethodWasCalled();

    }

    @Test
    void testByggrWrongAddressType() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);

        List<Address> addresses = new ArrayList<>();
        Address personAddress = new Address();
        personAddress.setStreet("Testvägen");
        personAddress.setHouseNumber("123");
        personAddress.setCity("Sundsvall");
        personAddress.setCountry("Sweden");
        personAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses.add(personAddress);
        person.setAddresses(addresses);

        stakeholders.add(person);

        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat().body(containsString(
                        Constants.ERR_MSG_PERSON_INVOICE_ADDRESS));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);

        verifyNoByggrMethodWasCalled();
    }

    @Test
    void testByggrWrongAttachmentExtension() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(".doc");
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);
        stakeholders.add(person);

        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat().body(containsString(
                        "extension must be valid. Must match regex:"));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);

        verifyNoByggrMethodWasCalled();
    }

    @Test
    void testByggrWrongAttachmentMimeType() throws JsonProcessingException {

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType("application/msword");
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);
        stakeholders.add(person);

        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat().body(containsString(
                        "mimeType must be valid. Must match regex:"));

        verifyPersistanceByggr(pCase.getExternalCaseId(), false);

        verifyNoByggrMethodWasCalled();
    }

    ////////////////////////////////////////////////////////////////
    // Exception-tester //
    ////////////////////////////////////////////////////////////////

    @Test
    void testEntityExistsException() throws JsonProcessingException {
        String externalCaseId = String.valueOf(new Random().nextLong());

        PlanningPermissionCase pCase = new PlanningPermissionCase();
        pCase.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase.setExternalCaseId(externalCaseId);

        List<Attachment> listOfAttachment = new ArrayList<>();
        Attachment attachment = new Attachment();
        attachment.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment.setExtension(TestConstants.PDF_EXTENSION);
        attachment.setFile(TestConstants.BASE64_STRING);
        attachment.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment.setName("Ansökan om bygglov");
        listOfAttachment.add(attachment);
        pCase.setAttachments(listOfAttachment);

        PlanningPermissionFacility planningPermissionFacility = new PlanningPermissionFacility();
        planningPermissionFacility.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility.setAddress(address);
        pCase.setFacilities(List.of(planningPermissionFacility));

        List<Stakeholder> stakeholders = new ArrayList<>();
        Person person = new Person();
        person.setType(StakeholderType.PERSON);
        person.setFirstName("Test");
        person.setLastName("Testorsson");
        person.setPersonId(PERSON_ID);
        person.setCellphoneNumber("060121212");
        person.setPhoneNumber("0701231212");
        person.setEmailAddress("test@test.se");
        List<StakeholderRole> roles = new ArrayList<>();
        roles.add(StakeholderRole.APPLICANT);
        person.setRoles(roles);
        stakeholders.add(person);

        Organization organization = new Organization();
        organization.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList = new ArrayList<>();
        srList.add(StakeholderRole.PROPERTY_OWNER);
        organization.setRoles(srList);
        organization.setOrganizationName("organizationName");
        organization.setOrganizationNumber(ORG_NUMBER);

        List<Address> addresses = new ArrayList<>();
        Address orgAddress = new Address();
        orgAddress.setStreet("Testvägen");
        orgAddress.setHouseNumber("123");
        orgAddress.setCity("Sundsvall");
        orgAddress.setCountry("Sweden");
        orgAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses.add(orgAddress);
        organization.setAddresses(addresses);

        stakeholders.add(organization);
        pCase.setStakeholders(stakeholders);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and().body(containsString(BYGG_CASE_ID));

        verifyPersistanceByggr(pCase.getExternalCaseId(), true);

        PlanningPermissionCase pCase2 = new PlanningPermissionCase();
        pCase2.setCaseType(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV);
        pCase2.setExternalCaseId(externalCaseId);

        List<Attachment> listOfAttachment2 = new ArrayList<>();
        Attachment attachment2 = new Attachment();
        attachment2.setCategory(AttachmentCategory.ANSOKAN_OM_BYGGLOV);
        attachment2.setExtension(TestConstants.PDF_EXTENSION);
        attachment2.setFile(TestConstants.BASE64_STRING);
        attachment2.setMimeType(TestConstants.MIMETYPE_PDF);
        attachment2.setName("Ansökan om bygglov");
        listOfAttachment2.add(attachment2);
        pCase2.setAttachments(listOfAttachment2);

        PlanningPermissionFacility planningPermissionFacility2 = new PlanningPermissionFacility();
        planningPermissionFacility2.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        Address address2 = new Address();
        address2.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address2.setPropertyDesignation(PROPERTY_DESIGNATION);
        planningPermissionFacility2.setAddress(address2);
        pCase2.setFacilities(List.of(planningPermissionFacility2));

        List<Stakeholder> stakeholders2 = new ArrayList<>();
        Person person2 = new Person();
        person2.setType(StakeholderType.PERSON);
        person2.setFirstName("Test");
        person2.setLastName("Testorsson");
        person2.setPersonId(PERSON_ID);
        person2.setCellphoneNumber("060121212");
        person2.setPhoneNumber("0701231212");
        person2.setEmailAddress("test@test.se");
        List<StakeholderRole> roles2 = new ArrayList<>();
        roles2.add(StakeholderRole.APPLICANT);
        person2.setRoles(roles2);
        stakeholders2.add(person2);

        Organization organization2 = new Organization();
        organization2.setType(StakeholderType.ORGANIZATION);
        List<StakeholderRole> srList2 = new ArrayList<>();
        srList2.add(StakeholderRole.PROPERTY_OWNER);
        organization2.setRoles(srList2);
        organization2.setOrganizationName("organizationName");
        organization2.setOrganizationNumber(ORG_NUMBER);

        List<Address> addresses2 = new ArrayList<>();
        Address orgAddress2 = new Address();
        orgAddress2.setStreet("Testvägen");
        orgAddress2.setHouseNumber("123");
        orgAddress2.setCity("Sundsvall");
        orgAddress2.setCountry("Sweden");
        orgAddress2.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS,
                AddressCategory.VISITING_ADDRESS, AddressCategory.INVOICE_ADDRESS));
        addresses2.add(orgAddress2);
        organization2.setAddresses(addresses2);

        stakeholders2.add(organization2);
        pCase2.setStakeholders(stakeholders2);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(pCase2)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Status.BAD_REQUEST.getStatusCode())
                .assertThat().body(containsString("A resources already exists with the same externalCaseId: ")).and().body(containsString(externalCaseId));

        // saveNewArende ska endast ha blivit anropad första gången
        verify(arendeExportIntegrationService, times(1)).saveNewArende(any());
        verify(arendeExportIntegrationService, times(0)).saveNewHandelse(any());
    }

    /**
     * Testar skicka in en JSON som har en stakeholder av typen PERSON men som ändå
     * har fältet "orgainzationName". Kontrollerar att validering av indata
     * fungerar.
     * <p>
     * UnrecognizedPropertyExceptionMapper används.
     */
    @Test
    void testUnrecognizedPropertyException() {

        given().contentType(MediaType.APPLICATION_JSON).body(new File("src/test/resources/unrecognizedProperty.json"))
                .when().post("/cases").then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat()
                .body(containsString("Unrecognized field"));

    }

    /**
     * Testar skicka in en JSON som har en stakeholder med rollen UNKNOWN. Denna typ
     * existerar inte som ENUM och kommer resultera i ett InvalidFormatException.
     * <p>
     * MismatchedInputExceptionMapper används.
     */
    @Test
    void testInvalidFormatException() {

        given().contentType(MediaType.APPLICATION_JSON).body(new File("src/test/resources/invalidFormat.json"))
                .when().post("/cases").then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat().body(containsString(
                        "Cannot deserialize value of type `se.sundsvall.vo.StakeholderRole` from String"));

    }

    /**
     * Testar skicka in en JSON som har "caseType": "NO_ONE". Denna typ existerar
     * inte och kommer resultera i ett InvalidTypeIdException när vi försöker lista
     * ut vilket subtype ärendet ska vara.
     * <p>
     * MismatchedInputExceptionMapper används.
     */
    @Test
    void testInvalidTypeIdException() {

        given().contentType(MediaType.APPLICATION_JSON).body(new File("src/test/resources/invalidTypeId.json"))
                .when().post("/cases").then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat().body(containsString(
                        "Could not resolve type id 'NO_ONE' as a subtype of `se.sundsvall.vo.Case`"));

    }

    /**
     * Testar skicka in en JSON som har en attachment med "mimeType" :
     * "application/pd". Denna typ matchar inte regex och kommer resultera i ett
     * ConstraintViolationException.
     * <p>
     * ConstraintViolationExceptionMapper används.
     */
    @Test
    void testConstraintViolationException() {

        given().contentType(MediaType.APPLICATION_JSON).body(new File("src/test/resources/constraintViolation.json"))
                .when().post("/cases").then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat()
                .body(containsString("mimeType must be valid. Must match regex:"));

    }

    /**
     * ConstraintViolationExceptionMapper används.
     */
    @Test
    void testRequestBodyMustNotBeNull() {

        given().contentType(MediaType.APPLICATION_JSON).body(new File("src/test/resources/emptyBody.json"))
                .when().post("/cases").then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.BAD_REQUEST.getStatusCode()).assertThat().body(containsString(
                        "Request body must not be null"));
    }


    /**
     * WebApplicationExceptionMapper används.
     */
    @Test
    void test302Found() {

        when(minutMiljoIntegrationService.registerDocumentV2(any())).thenThrow(new WebApplicationException(Status.FOUND));

        given().contentType(MediaType.APPLICATION_JSON).body(new File("src/test/resources/normalEcosCase.json"))
                .when().post("/cases").then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.FOUND.getStatusCode()).assertThat().body(containsString(
                        Status.FOUND.getReasonPhrase()));
    }

    /**
     * WebApplicationExceptionMapper används.
     */
    @Test
    void test404NotFoundException() {

        given().contentType(MediaType.APPLICATION_JSON).body("{}")
                .when().post("/cat").then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.NOT_FOUND.getStatusCode()).assertThat()
                .body(containsString(Status.NOT_FOUND.getReasonPhrase()));

    }

    /**
     * WebApplicationExceptionMapper används.
     */
    @Test
    void test405MethodNotAllowedException() {

        given().contentType(MediaType.APPLICATION_JSON).body("{}")
                .when().patch().then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.METHOD_NOT_ALLOWED.getStatusCode()).assertThat()
                .body(containsString(Status.METHOD_NOT_ALLOWED.getReasonPhrase()));

    }

    /**
     * DefaultExceptionMapper används.
     */
    @Test
    void testDefaultExceptionMapper() {

        when(minutMiljoIntegrationService.registerDocumentV2(any())).thenThrow(new RuntimeException("Testar"));

        given().contentType(MediaType.APPLICATION_JSON).body(new File("src/test/resources/normalEcosCase.json"))
                .when().post("/cases").then().log().ifValidationFails(LogDetail.BODY)
                .statusCode(Status.INTERNAL_SERVER_ERROR.getStatusCode()).assertThat().body(containsString(
                        Status.INTERNAL_SERVER_ERROR.getReasonPhrase())).and().body(containsString(Constants.ERR_MSG_UNHANDLED_EXCEPTION));
    }

    private void verifyNoEcosMethodWasCalled() {
        verify(minutMiljoIntegrationService, never()).searchParty(any());
        verify(minutMiljoIntegrationService, never()).createOrganizationParty(any());
        verify(minutMiljoIntegrationService, never()).createPersonParty(any());
        verify(minutMiljoIntegrationService, never()).createFoodFacility(any());
        verify(minutMiljoIntegrationService, never()).addPartyToFacility(any());
        verify(minutMiljoIntegrationService, never()).addPartyToCase(any());
        verify(minutMiljoIntegrationService, never()).registerDocumentV2(any());
    }

    private void verifyNoByggrMethodWasCalled() {
        verify(arendeExportIntegrationService, never()).saveNewArende(any());
        verify(arendeExportIntegrationService, never()).saveNewHandelse(any());
    }

    private void verifyPersistanceEcos(String externalCaseId, boolean persisted) {
        List<CaseMapping> caseMappingList = caseDao.getCaseMapping(externalCaseId, null);

        if (persisted) {
            assertTrue(caseMappingList.stream().anyMatch(c -> c.getExternalCaseId().equals(externalCaseId) && c.getCaseId().equals(ECOS_CASE_ID) && c.getSystem().equals(SystemType.ECOS)));
        } else {
            assertFalse(caseMappingList.stream().anyMatch(c -> c.getExternalCaseId().equals(externalCaseId) && c.getCaseId().equals(ECOS_CASE_ID) && c.getSystem().equals(SystemType.ECOS)));
        }

    }

    private void verifyPersistanceByggr(String externalCaseId, boolean persisted) {
        List<CaseMapping> caseMappingList = caseDao.getCaseMapping(externalCaseId, null);

        if (persisted) {
            assertTrue(caseMappingList.stream().anyMatch(c -> c.getExternalCaseId().equals(externalCaseId) && c.getCaseId().equals(BYGG_CASE_ID) && c.getSystem().equals(SystemType.BYGGR)));
        } else {
            assertFalse(caseMappingList.stream().anyMatch(c -> c.getExternalCaseId().equals(externalCaseId) && c.getCaseId().equals(BYGG_CASE_ID) && c.getSystem().equals(SystemType.BYGGR)));
        }

    }

}
