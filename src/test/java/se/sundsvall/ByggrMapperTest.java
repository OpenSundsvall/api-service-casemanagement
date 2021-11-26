package se.sundsvall;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.sundsvall.lantmateriet.registerbeteckning.RegisterbeteckningService;
import se.sundsvall.lantmateriet.registerbeteckning.Registerbeteckningsreferens;
import se.sundsvall.sokigo.arendeexport.ByggrMapper;
import se.sundsvall.sokigo.fb.AdressplatsIdentifierDto;
import se.sundsvall.sokigo.fb.FastighetDto;
import se.sundsvall.sokigo.fb.FbService;
import se.sundsvall.sokigo.fb.ResponseDto;
import se.sundsvall.sundsvall.citizenmapping.CitizenMappingService;
import se.sundsvall.util.Constants;
import se.sundsvall.vo.*;
import se.tekis.arende.Arende;
import se.tekis.arende.ArendeFastighet;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@QuarkusTest
class ByggrMapperTest {

    private static final String PROPERTY_DESIGNATION_1 = "SUNDSVALL FILLA 8:185";
    private static final String PROPERTY_DESIGNATION_2 = "SUNDSVALL BIRSTA 1:1";
    private static final String PERSON_ID = "a56296af-9298-46fc-a6fe-ca214847f718";

    @Inject
    ByggrMapper byggrMapper;

    @InjectMock
    @RestClient
    RegisterbeteckningService registerbeteckningService;

    @InjectMock
    @RestClient
    CitizenMappingService citizenMappingService;

    @InjectMock
    @RestClient
    FbService fbService;

    @BeforeEach
    void beforeEach() {
        // Lantmäteriet mocks
        List<Registerbeteckningsreferens> registerbeteckningsreferenser1 = new ArrayList<>();
        Registerbeteckningsreferens registerbeteckningsreferens1 = new Registerbeteckningsreferens();
        registerbeteckningsreferens1.setBeteckning(PROPERTY_DESIGNATION_1);
        registerbeteckningsreferens1.setBeteckningsid("ny-4020855");
        registerbeteckningsreferens1.setRegisterenhet("909a6a80-8add-90ec-e040-ed8f66444c3f");
        registerbeteckningsreferenser1.add(registerbeteckningsreferens1);
        when(registerbeteckningService.getReferenser(anyString(),
                eq(Constants.LANTMATERIET_REFERENS_STATUS_GALLANDE), eq(1)))
                .thenReturn(registerbeteckningsreferenser1);

        List<Registerbeteckningsreferens> registerbeteckningsreferenser2 = new ArrayList<>();
        Registerbeteckningsreferens registerbeteckningsreferens2 = new Registerbeteckningsreferens();
        registerbeteckningsreferens2.setBeteckning(PROPERTY_DESIGNATION_2);
        registerbeteckningsreferens2.setBeteckningsid("ny-4020855");
        registerbeteckningsreferens2.setRegisterenhet("909a6a80-8add-90ec-e040-ed8f66444c3f");
        registerbeteckningsreferenser2.add(registerbeteckningsreferens2);
        when(registerbeteckningService.getReferenser(PROPERTY_DESIGNATION_2,
                Constants.LANTMATERIET_REFERENS_STATUS_GALLANDE, 1))
                .thenReturn(registerbeteckningsreferenser2);

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


    @Test
    void oneFacilityMainTrue() throws JsonProcessingException {
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
        planningPermissionFacility.setMainFacility(true);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION_1);
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

        Arende arende = byggrMapper.getByggrCase(pCase);

        Assertions.assertEquals(1, arende.getObjektLista().getAbstractArendeObjekt().size());

        ArendeFastighet arendeFastighet = (ArendeFastighet) arende.getObjektLista().getAbstractArendeObjekt().get(0);

        Assertions.assertTrue(arendeFastighet.isArHuvudObjekt());
        Assertions.assertNotNull(arendeFastighet.getFastighet().getFnr());

        // ByggR is automatically setting the name when there is only one facility
        Assertions.assertNull(arende.getBeskrivning());
    }

    @Test
    void oneFacilityMainFalse() throws JsonProcessingException {
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
        planningPermissionFacility.setMainFacility(false);
        Address address = new Address();
        address.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address.setPropertyDesignation(PROPERTY_DESIGNATION_1);
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

        Arende arende = byggrMapper.getByggrCase(pCase);

        Assertions.assertEquals(1, arende.getObjektLista().getAbstractArendeObjekt().size());

        ArendeFastighet arendeFastighet = (ArendeFastighet) arende.getObjektLista().getAbstractArendeObjekt().get(0);

        Assertions.assertFalse(arendeFastighet.isArHuvudObjekt());
        Assertions.assertNotNull(arendeFastighet.getFastighet().getFnr());

        // ByggR is automatically setting the name when there is only one facility
        Assertions.assertNull(arende.getBeskrivning());
    }

    @Test
    void threeFacilitiesOneMain() throws JsonProcessingException {

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
        planningPermissionFacility1.setMainFacility(false);
        Address address1 = new Address();
        address1.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address1.setPropertyDesignation(PROPERTY_DESIGNATION_2);
        planningPermissionFacility1.setAddress(address1);

        PlanningPermissionFacility planningPermissionFacility2 = new PlanningPermissionFacility();
        planningPermissionFacility2.setFacilityType(FacilityType.GREENHOUSE);
        planningPermissionFacility2.setMainFacility(true);
        Address address2 = new Address();
        address2.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address2.setPropertyDesignation(PROPERTY_DESIGNATION_1);
        planningPermissionFacility2.setAddress(address2);

        PlanningPermissionFacility planningPermissionFacility3 = new PlanningPermissionFacility();
        planningPermissionFacility3.setFacilityType(FacilityType.INDUSTRIAL_BUILDING);
        planningPermissionFacility3.setMainFacility(false);
        Address address3 = new Address();
        address3.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address3.setPropertyDesignation(PROPERTY_DESIGNATION_1);
        planningPermissionFacility3.setAddress(address3);

        pCase.setFacilities(List.of(planningPermissionFacility1, planningPermissionFacility2, planningPermissionFacility3));

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

        Arende arende = byggrMapper.getByggrCase(pCase);

        // Only one "arendeFastighet" per propertyDesignation
        Assertions.assertEquals(2, arende.getObjektLista().getAbstractArendeObjekt().size());

        ArendeFastighet arendeFastighet1 = (ArendeFastighet) arende.getObjektLista().getAbstractArendeObjekt().get(0);
        Assertions.assertFalse(arendeFastighet1.isArHuvudObjekt());

        ArendeFastighet arendeFastighet2 = (ArendeFastighet) arende.getObjektLista().getAbstractArendeObjekt().get(1);
        Assertions.assertTrue(arendeFastighet2.isArHuvudObjekt());

        arende.getObjektLista().getAbstractArendeObjekt().forEach(f -> {
            ArendeFastighet arendeFastighet = (ArendeFastighet) f;
            Assertions.assertNotNull(arendeFastighet.getFastighet().getFnr());
        });

        Assertions.assertTrue(PROPERTY_DESIGNATION_1.contains(arende.getProjektnr()));

        Assertions.assertEquals(Constants.BYGGR_ARENDEMENING_BYGGLOV_FOR_NYBYGGNAD_AV + " växthus, enbostadshus & industribyggnad", arende.getBeskrivning());
    }

    @Test
    void twoFacilitiesNoMain() throws JsonProcessingException {

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
        planningPermissionFacility1.setMainFacility(false);
        Address address1 = new Address();
        address1.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address1.setPropertyDesignation(PROPERTY_DESIGNATION_2);
        planningPermissionFacility1.setAddress(address1);

        PlanningPermissionFacility planningPermissionFacility2 = new PlanningPermissionFacility();
        planningPermissionFacility2.setFacilityType(FacilityType.ONE_FAMILY_HOUSE);
        planningPermissionFacility2.setMainFacility(false);
        Address address2 = new Address();
        address2.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address2.setPropertyDesignation(PROPERTY_DESIGNATION_1);
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

        Arende arende = byggrMapper.getByggrCase(pCase);

        Assertions.assertEquals(2, arende.getObjektLista().getAbstractArendeObjekt().size());

        ArendeFastighet arendeFastighet1 = (ArendeFastighet) arende.getObjektLista().getAbstractArendeObjekt().get(0);
        Assertions.assertFalse(arendeFastighet1.isArHuvudObjekt());

        ArendeFastighet arendeFastighet2 = (ArendeFastighet) arende.getObjektLista().getAbstractArendeObjekt().get(1);
        Assertions.assertFalse(arendeFastighet2.isArHuvudObjekt());

        arende.getObjektLista().getAbstractArendeObjekt().forEach(f -> {
            ArendeFastighet arendeFastighet = (ArendeFastighet) f;
            Assertions.assertNotNull(arendeFastighet.getFastighet().getFnr());
        });

        Assertions.assertNull(arende.getProjektnr());

        Assertions.assertEquals(Constants.BYGGR_ARENDEMENING_BYGGLOV_FOR_NYBYGGNAD_AV + " enbostadshus & enbostadshus", arende.getBeskrivning());
    }

    @Test
    void twoFacilitiesWithSamePropertyDesignation() throws JsonProcessingException {
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
        planningPermissionFacility1.setMainFacility(false);
        Address address1 = new Address();
        address1.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address1.setPropertyDesignation(PROPERTY_DESIGNATION_1);
        planningPermissionFacility1.setAddress(address1);

        PlanningPermissionFacility planningPermissionFacility2 = new PlanningPermissionFacility();
        planningPermissionFacility2.setFacilityType(FacilityType.GUEST_HOUSE);
        planningPermissionFacility2.setMainFacility(false);
        Address address2 = new Address();
        address2.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address2.setPropertyDesignation(PROPERTY_DESIGNATION_1);
        planningPermissionFacility2.setAddress(address2);

        PlanningPermissionFacility planningPermissionFacility3 = new PlanningPermissionFacility();
        planningPermissionFacility3.setFacilityType(FacilityType.CARPORT);
        planningPermissionFacility3.setMainFacility(false);
        Address address3 = new Address();
        address3.setAddressCategories(List.of(AddressCategory.VISITING_ADDRESS));
        address3.setPropertyDesignation(PROPERTY_DESIGNATION_2);
        planningPermissionFacility3.setAddress(address3);

        pCase.setFacilities(List.of(planningPermissionFacility1, planningPermissionFacility2, planningPermissionFacility3));

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

        Arende arende = byggrMapper.getByggrCase(pCase);

        Assertions.assertEquals(2, arende.getObjektLista().getAbstractArendeObjekt().size());

        ArendeFastighet arendeFastighet1 = (ArendeFastighet) arende.getObjektLista().getAbstractArendeObjekt().get(0);
        Assertions.assertFalse(arendeFastighet1.isArHuvudObjekt());

        ArendeFastighet arendeFastighet2 = (ArendeFastighet) arende.getObjektLista().getAbstractArendeObjekt().get(1);
        Assertions.assertFalse(arendeFastighet2.isArHuvudObjekt());

        arende.getObjektLista().getAbstractArendeObjekt().forEach(f -> {
            ArendeFastighet arendeFastighet = (ArendeFastighet) f;
            Assertions.assertNotNull(arendeFastighet.getFastighet().getFnr());
        });

        Assertions.assertNull(arende.getProjektnr());

        Assertions.assertEquals(Constants.BYGGR_ARENDEMENING_BYGGLOV_FOR_NYBYGGNAD_AV + " enbostadshus, gäststuga & carport", arende.getBeskrivning());
    }

}
