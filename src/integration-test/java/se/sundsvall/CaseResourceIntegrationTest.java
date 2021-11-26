package se.sundsvall;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.filter.log.LogDetail;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sundsvall.util.Constants;
import se.sundsvall.vo.*;

import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.ws.soap.SOAPFaultException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class CaseResourceIntegrationTest {
    private static final String PROPERTY_DESIGNATION = "SUNDSVALL BIRSTA 36:14";
    private static final String PERSON_ID = "a56296af-9298-46fc-a6fe-ca214847f718";
    private static final String BYGG_CASE_ID = "BYGG 2021-000200";
    private static final String ECOS_CASE_NUMBER = "MK-2021-837";
    private static final String ORG_NUMBER = "123456-1234";

    @Inject
    CaseResource caseResource;

    static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    static WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8090).usingFilesUnderDirectory("src/integration-test/resources"));

    @BeforeAll
    public static void beforeAll() {
        wireMockServer.start();
    }

    @AfterAll
    public static void afterAll() {
        wireMockServer.stop();
    }


    @BeforeEach
    public void setup() {
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Test
    void testIntegrationEcosCase() throws JsonProcessingException {

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
        facility.setFacilityCollectionName("TestFacility");
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
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Response.Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and()
                .body(containsString(ECOS_CASE_NUMBER));
    }

    @Test
    void testIntegrationEcosCaseMovingFacility() throws JsonProcessingException {

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
        facility.setFacilityCollectionName("TestFacility");
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setDescription("test");
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setEndDate(LocalDate.now().plusDays(365));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Response.Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and()
                .body(containsString(ECOS_CASE_NUMBER));
    }

    @Test
    void testIntegrationByggrCase() throws JsonProcessingException {
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
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Response.Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and().body(containsString(BYGG_CASE_ID));

    }

    @Test
    void testEcosRegisterDoc500Response() {

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
        // Sätter denna till "INTERNAL_SERVER_ERROR" för att kunna styra vilket svar jag får i request mapping
        facility.setFacilityCollectionName("INTERNAL_SERVER_ERROR");
        Address facilityAddress = new Address();
        facilityAddress.setAddressCategories(List.of(AddressCategory.POSTAL_ADDRESS));
        facilityAddress.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(facilityAddress);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setStartDate(LocalDate.now().plusDays(10));
        eCase.setExternalCaseId(String.valueOf(new Random().nextLong()));

        SOAPFaultException exception = assertThrows(SOAPFaultException.class, () -> caseResource.postCases(eCase));

        String expectedMessage = "Object reference not set to an instance of an object.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void getEcosStatusByExternalCaseId() throws JsonProcessingException {

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
        // Sätter denna till "200_response" för att kunna styra vilket svar jag får i request mapping
        facility.setFacilityCollectionName("200_response");
        Address facilityAddress = new Address();
        facilityAddress.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        facilityAddress.setPropertyDesignation(PROPERTY_DESIGNATION);
        facility.setAddress(facilityAddress);
        eCase.setFacilities(List.of(facility));

        eCase.setCaseType(CaseType.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING);
        eCase.setStartDate(LocalDate.now().plusDays(10));
        String externalCaseId = String.valueOf(new Random().nextLong());
        eCase.setExternalCaseId(externalCaseId);

        given().contentType(MediaType.APPLICATION_JSON).body(mapper.writeValueAsString(eCase)).when().post("/cases")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Response.Status.OK.getStatusCode())
                .assertThat().body(containsString("caseId")).and()
                .body(containsString(ECOS_CASE_NUMBER));


        given().contentType(MediaType.APPLICATION_JSON).when().get("/cases/" + externalCaseId + "/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Response.Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and()
                .body(containsString("Begäran om anstånd"));
    }

    @Test
    void getStatusByOrgNr() {
        String organizationNumber = "123456-4321";

        given().contentType(MediaType.APPLICATION_JSON).when().get("organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Response.Status.OK.getStatusCode())
                .assertThat().body(containsString("status")).and()
                .body(containsString("ANSÖKAN")).and()
                .body(containsString("Begäran om anstånd"));
    }

    @Test
    void getStatusByOrgNrNotFound() {
        String organizationNumber = "000000-0404";

        given().contentType(MediaType.APPLICATION_JSON).when().get("organization/" + organizationNumber + "/cases/status")
                .then().log().ifValidationFails(LogDetail.BODY).statusCode(Response.Status.NOT_FOUND.getStatusCode())
                .assertThat()
                .body(containsString(Constants.ERR_MSG_STATUS_NOT_FOUND));
    }

}