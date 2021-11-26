package se.sundsvall.sokigo.minutmiljo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfguid;
import org.jboss.logging.Logger;
import se.sundsvall.CaseDao;
import se.sundsvall.exceptions.ApplicationException;
import se.sundsvall.sokigo.fb.FbPropertyInfo;
import se.sundsvall.util.CaseUtil;
import se.sundsvall.util.Constants;
import se.sundsvall.validators.EnvironmentalConstraints;
import se.sundsvall.vo.*;
import v1.datacontracts.minutmiljo.api.ecos.*;
import v2.datacontracts.minutmiljo.api.ecos.RegisterDocumentCaseSvcDtoV2;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.*;

@ApplicationScoped
public class EcosMapper {

    private final ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    @Inject
    Logger log;

    @Inject
    CaseUtil caseUtil;

    @Inject
    CaseDao caseDao;

    @Inject
    MinutMiljoIntegrationService minutMiljoIntegrationService;

    public void addPartyToCase(Map<String, ArrayOfguid> partyRoles, List<PartySvcDto> partyList, String caseId) throws JsonProcessingException {
        for (PartySvcDto p : partyList) {
            AddPartyToCaseSvcDto addPartyToCaseSvcDto = new AddPartyToCaseSvcDto();
            addPartyToCaseSvcDto.setCaseId(caseId);
            addPartyToCaseSvcDto.setPartyId(p.getId());
            addPartyToCaseSvcDto.setRoles(partyRoles.get(p.getId()));

            log.debug("Lägger till party på case: \n" + mapper.writeValueAsString(addPartyToCaseSvcDto));
            minutMiljoIntegrationService.addPartyToCase(addPartyToCaseSvcDto);
        }
    }

    public void addPartyToFacility(Map<String, ArrayOfguid> partyRoles, List<PartySvcDto> partyList, String foodFacilityGuid) throws JsonProcessingException {
        for (PartySvcDto p : partyList) {
            AddPartyToFacilitySvcDto addPartyToFacility = new AddPartyToFacilitySvcDto();
            addPartyToFacility.setFacilityId(foodFacilityGuid);
            addPartyToFacility.setPartyId(p.getId());
            addPartyToFacility.setRoles(partyRoles.get(p.getId()));

            log.debug("Lägger till party på facility: \n" + mapper.writeValueAsString(addPartyToFacility));
            minutMiljoIntegrationService.addPartyToFacility(addPartyToFacility);
        }
    }

    public String createFoodFacility(EnvironmentalCase eCase, FbPropertyInfo propertyInfo, RegisterDocumentCaseResultSvcDto registerDocumentResult) throws ApplicationException {

        CreateFoodFacilitySvcDto createFoodFacilitySvcDto = new CreateFoodFacilitySvcDto();

        if (propertyInfo.getAddressId() != null) {
            FacilityAddressSvcDto facilityAddressSvcDto = new FacilityAddressSvcDto();
            facilityAddressSvcDto.setAdressPlatsId(propertyInfo.getAddressId());
            createFoodFacilitySvcDto.setAddress(facilityAddressSvcDto);
        }

        createFoodFacilitySvcDto.setCase(registerDocumentResult.getCaseId());

        EstateSvcDto estateSvcDto = new EstateSvcDto();

        // FNR - must exist in FB
        estateSvcDto.setFnr(propertyInfo.getFnr());

        createFoodFacilitySvcDto.setEstateDesignation(estateSvcDto);
        createFoodFacilitySvcDto.setFacilityCollectionName(eCase.getFacilities().get(0).getFacilityCollectionName());
        createFoodFacilitySvcDto.setNote(eCase.getFacilities().get(0).getDescription());

        String foodFacilityGuid = minutMiljoIntegrationService.createFoodFacility(createFoodFacilitySvcDto);

        if (foodFacilityGuid != null) {
            log.debug("FoodFacility skapad: " + foodFacilityGuid);
            return foodFacilityGuid;
        } else {
            throw new ApplicationException("FoodFacility i Ecos kunde inte skapas.");
        }
    }

    public RegisterDocumentCaseResultSvcDto registerDocument(EnvironmentalCase eCase) throws ApplicationException, JsonProcessingException {

        RegisterDocumentCaseSvcDtoV2 registerDocumentCaseSvcDtoV2 = new RegisterDocumentCaseSvcDtoV2();

        if (eCase.getFacilities().get(0).getAddress() == null || eCase.getFacilities().get(0).getAddress().getPropertyDesignation() == null) {
            registerDocumentCaseSvcDtoV2.setCaseSubtitleFree(eCase.getFacilities().get(0).getFacilityCollectionName().trim());
        } else {
            registerDocumentCaseSvcDtoV2.setCaseSubtitleFree(eCase.getFacilities().get(0).getFacilityCollectionName().trim() + ", "
                    + eCase.getFacilities().get(0).getAddress().getPropertyDesignation().trim().toUpperCase());
        }

        registerDocumentCaseSvcDtoV2.setOccurrenceTypeId(Constants.ECOS_OCCURENCE_TYPE_ID_ANMALAN);
        registerDocumentCaseSvcDtoV2.setProcessTypeId(Constants.ECOS_PROCESS_TYPE_ID_REGISTRERING_AV_LIVSMEDELSANLAGGNING);
        registerDocumentCaseSvcDtoV2.setHandlingOfficerGroupId(Constants.ECOS_HANDLING_OFFICER_GROUP_ID_EXPEDITIONEN);

        ArrayOfDocumentSvcDto arrayOfDocumentSvcDto = new ArrayOfDocumentSvcDto();
        if (eCase.getAttachments() != null) {
            for (Attachment a : eCase.getAttachments()) {
                DocumentSvcDto documentSvcDto = new DocumentSvcDto();

                documentSvcDto.setContentType(a.getMimeType());
                documentSvcDto.setData(caseUtil.base64ToByteArray(a.getFile()));
                documentSvcDto.setDocumentTypeId(Constants.ECOS_DOCUMENT_TYPE_ID_ANMALAN_LIVSMEDELSANLAGGNING);

                // Filename must end with extension for the preview in Ecos to work
                String filename = a.getName();
                if (!filename.endsWith(a.getExtension())) {
                    filename = filename + a.getExtension();
                }
                documentSvcDto.setFilename(filename);

                documentSvcDto.setNote(a.getNote());

                arrayOfDocumentSvcDto.getDocumentSvcDto().add(documentSvcDto);
            }
        }

        registerDocumentCaseSvcDtoV2.setDocuments(arrayOfDocumentSvcDto);

        RegisterDocumentCaseResultSvcDto registerDocumentResult = minutMiljoIntegrationService
                .registerDocumentV2(registerDocumentCaseSvcDtoV2);

        if (registerDocumentResult != null) {
            log.debug("Ärende skapat: \n" + mapper.writeValueAsString(registerDocumentResult));
            return registerDocumentResult;
        } else {
            throw new ApplicationException("Ärendet i Ecos kunde inte skapas.");
        }
    }

    public void createParty(Map<String, ArrayOfguid> partyRoles, List<PartySvcDto> partyList, List<Stakeholder> missingStakeholders) throws JsonProcessingException, ApplicationException {

        if (!missingStakeholders.isEmpty()) {
            for (Stakeholder s : missingStakeholders) {
                String guidResult = null;

                if (s instanceof Organization) {
                    Organization organization = (Organization) s;

                    OrganizationSvcDto osd = getOrganizationSvcDto(s, organization);

                    guidResult = minutMiljoIntegrationService.createOrganizationParty(osd);

                } else if (s instanceof Person) {
                    Person person = (Person) s;
                    PersonSvcDto personSvcDto = getPersonSvcDto(s, person);

                    guidResult = minutMiljoIntegrationService.createPersonParty(personSvcDto);
                }

                if (guidResult != null) {
                    PartySvcDto party = new PartySvcDto();
                    party.setId(guidResult);

                    partyList.add(party);

                    // Adds party in a hashmap with the role so that we can connect stakeholder to case with the
                    // role later
                    partyRoles.put(party.getId(), getEcosFacilityRoles(s));

                }
            }

            log.debug("Partylistan efter CreateParty: \n" + mapper.writeValueAsString(partyList));
        } else {
            log.debug("Samtliga parter fanns redan registrerade i Ecos. Hoppar över CreateParty.");
        }
    }

    PersonSvcDto getPersonSvcDto(Stakeholder s, Person person) throws JsonProcessingException {
        PersonSvcDto personSvcDto = new PersonSvcDto();
        personSvcDto.setFirstName(person.getFirstName());
        personSvcDto.setLastName(person.getLastName());

        if (person.getPersonId() != null && !person.getPersonId().isBlank()) {
            personSvcDto.setNationalIdentificationNumber(caseUtil.getPersonalNumber(person.getPersonId()));
        }

        personSvcDto.setAddresses(getEcosAddresses(s.getAddresses()));
        personSvcDto.setContactInfo(getEcosContactInfo(s).getContactInfoSvcDto().get(0));
        return personSvcDto;
    }

    OrganizationSvcDto getOrganizationSvcDto(Stakeholder s, Organization organization) {
        OrganizationSvcDto osd = new OrganizationSvcDto();
        osd.setNationalIdentificationNumber(caseUtil.getCompletedOrganizationNumber(organization.getOrganizationNumber()));
        osd.setOrganizationName(organization.getOrganizationName());

        osd.setAddresses(getEcosAddresses(s.getAddresses()));
        osd.setContactInfo(getEcosContactInfo(s));
        return osd;
    }


    public void searchParty(EnvironmentalCase eCase, Map<String, ArrayOfguid> partyRoles, List<PartySvcDto> partyList, List<Stakeholder> missingStakeholders) throws JsonProcessingException, ApplicationException {

        for (Stakeholder s : eCase.getStakeholders()) {
            SearchPartySvcDto searchPartyMsg = new SearchPartySvcDto();

            if (s instanceof Person) {
                Person person = (Person) s;

                if (person.getPersonId() != null && !person.getPersonId().isBlank()) {
                    searchPartyMsg.setPersonalIdentificationNumber(caseUtil.getPersonalNumber(person.getPersonId()));
                }

            } else if (s instanceof Organization) {
                Organization organization = (Organization) s;
                searchPartyMsg.setOrganizationIdentificationNumber(caseUtil.getCompletedOrganizationNumber(organization.getOrganizationNumber()));
            }

            ArrayOfPartySvcDto searchPartyResult = null;
            if (searchPartyMsg.getOrganizationIdentificationNumber() != null || searchPartyMsg.getPersonalIdentificationNumber() != null) {
                searchPartyResult = minutMiljoIntegrationService.searchParty(searchPartyMsg);
            }

            // If we get a result we put it in partyList, else we put it in missingStakeholders
            if (searchPartyResult != null && !searchPartyResult.getPartySvcDto().isEmpty()
                    && searchPartyResult.getPartySvcDto().size() == 1) {

                PartySvcDto party = searchPartyResult.getPartySvcDto().get(0);
                partyList.add(party);

                // Adds stakeholder to a hashmap with the role so that we can connect the stakeholder to the case later
                partyRoles.put(party.getId(), getEcosFacilityRoles(s));

            } else {
                // These, we are going to create later
                missingStakeholders.add(s);
            }
        }

        log.debug("PartyList after SearchParty: \n" + mapper.writeValueAsString(partyList));
        log.debug("MissingStakeholders after SearchParty: \n" + mapper.writeValueAsString(missingStakeholders));
    }


    public void validate(EnvironmentalCase eCase) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<EnvironmentalCase>> violations = validator.validate(eCase,
                EnvironmentalConstraints.class);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }


    ArrayOfguid getEcosFacilityRoles(Stakeholder s) throws ApplicationException {
        final String ERROR = "error";

        ArrayOfguid roles = new ArrayOfguid();
        for (StakeholderRole role : s.getRoles()) {
            String roleId;
            if (role.equals(StakeholderRole.INVOICE_RECIPENT)) {
                roleId = Constants.ECOS_FACILITY_ROLE_ID_FAKTURAMOTTAGARE;
            } else if (role.equals(StakeholderRole.OPERATOR)) {
                roleId = Constants.ECOS_FACILITY_ROLE_ID_VERKSAMHETSUTOVARE;
            } else if (role.equals(StakeholderRole.CONTACT_PERSON)) {
                roleId = Constants.ECOS_FACILITY_ROLE_ID_KONTAKTPERSON;
            } else {
                roleId = ERROR;
            }

            roles.getGuid().add(roleId);
        }

        if (roles.getGuid().contains(ERROR)) {
            throw new ApplicationException(
                    "The request contained a stakeholder role that was not expected. This should be discovered in the validation of the input. Something in the validation is wrong.");
        }

        return roles;
    }

    ArrayOfContactInfoSvcDto getEcosContactInfo(Stakeholder s) {
        ArrayOfContactInfoSvcDto arrayOfContactInfoSvcDto = new ArrayOfContactInfoSvcDto();
        ContactInfoSvcDto contactInfoSvcDto = new ContactInfoSvcDto();
        ArrayOfContactInfoItemSvcDto arrayOfContactInfoItemSvcDto = new ArrayOfContactInfoItemSvcDto();

        if (s.getEmailAddress() != null) {
            ContactInfoItemSvcDto item = new ContactInfoItemSvcDto();

            item.setContactDetailTypeId(Constants.ECOS_CONTACT_DETAIL_TYPE_ID_OVRIGT);
            item.setContactPathId(Constants.ECOS_CONTACT_DETAIL_TYPE_ID_EPOST);
            item.setValue(s.getEmailAddress());

            arrayOfContactInfoItemSvcDto.getContactInfoItemSvcDto().add(item);
        }
        if (s.getCellphoneNumber() != null) {
            ContactInfoItemSvcDto item = new ContactInfoItemSvcDto();

            item.setContactDetailTypeId(Constants.ECOS_CONTACT_DETAIL_TYPE_ID_MOBIL);
            item.setContactPathId(Constants.ECOS_CONTACT_DETAIL_TYPE_ID_TELEFON);
            item.setValue(s.getCellphoneNumber());

            arrayOfContactInfoItemSvcDto.getContactInfoItemSvcDto().add(item);
        }

        if (s.getPhoneNumber() != null) {
            ContactInfoItemSvcDto item = new ContactInfoItemSvcDto();

            item.setContactDetailTypeId(Constants.ECOS_CONTACT_DETAIL_TYPE_ID_HUVUDNUMMER);
            item.setContactPathId(Constants.ECOS_CONTACT_DETAIL_TYPE_ID_TELEFON);
            item.setValue(s.getPhoneNumber());

            arrayOfContactInfoItemSvcDto.getContactInfoItemSvcDto().add(item);
        }

        contactInfoSvcDto.setContactDetails(arrayOfContactInfoItemSvcDto);

        if (s instanceof Person) {
            Person person = (Person) s;
            contactInfoSvcDto.setTitle(person.getFirstName() + " " + person.getLastName());
        } else if (s instanceof Organization) {
            Organization organization = (Organization) s;
            contactInfoSvcDto.setTitle(organization.getAuthorizedSignatory());
        }

        arrayOfContactInfoSvcDto.getContactInfoSvcDto().add(contactInfoSvcDto);
        return arrayOfContactInfoSvcDto;
    }

    ArrayOfPartyAddressSvcDto getEcosAddresses(List<Address> addresses) {
        if (addresses == null) {
            return null;
        }

        ArrayOfPartyAddressSvcDto partyAddresses = new ArrayOfPartyAddressSvcDto();

        for (Address address : addresses) {
            PartyAddressSvcDto partyAddress = new PartyAddressSvcDto();

            ArrayOfAddressTypeSvcDto arrayOfAddressType = new ArrayOfAddressTypeSvcDto();

            for (AddressCategory at : address.getAddressCategories()) {
                AddressTypeSvcDto addressType = new AddressTypeSvcDto();

                switch (at) {
                    case INVOICE_ADDRESS:
                        addressType.setId(Constants.ECOS_ADDRESS_TYPE_ID_FAKTURAADRESS);
                        break;
                    case POSTAL_ADDRESS:
                        addressType.setId(Constants.ECOS_ADDRESS_TYPE_ID_POSTADRESS);
                        break;
                    case VISITING_ADDRESS:
                        addressType.setId(Constants.ECOS_ADDRESS_TYPE_ID_BESOKSADRESS);
                        break;
                }

                arrayOfAddressType.getAddressTypeSvcDto().add(addressType);
            }

            partyAddress.setAddressTypes(arrayOfAddressType);

            partyAddress.setCareOfName(address.getCareOf());
            partyAddress.setCountry(address.getCountry());
            partyAddress.setPostalArea(address.getCity());
            partyAddress.setPostCode(address.getPostalCode());
            partyAddress.setStreetName(address.getStreet());
            partyAddress.setStreetNumber(address.getHouseNumber());
            partyAddresses.getPartyAddressSvcDto().add(partyAddress);
        }

        return partyAddresses;
    }

    public void createOccurrenceOnCase(String caseId) {

        CreateOccurrenceOnCaseSvcDto createOccurrenceOnCaseSvcDto = new CreateOccurrenceOnCaseSvcDto();
        createOccurrenceOnCaseSvcDto.setCaseId(caseId);
        createOccurrenceOnCaseSvcDto.setOccurrenceDate(LocalDateTime.now());
        createOccurrenceOnCaseSvcDto.setOccurrenceTypeId(Constants.ECOS_OCCURRENCE_TYPE_ID_INFO_FRAN_ETJANST);
        createOccurrenceOnCaseSvcDto.setNote(Constants.ECOS_OCCURENCE_TEXT_MOBIL_ANLAGGNING);

        minutMiljoIntegrationService.createOccurrenceOnCase(createOccurrenceOnCaseSvcDto);
    }

    public String getStatus(String caseId) {
        CaseSvcDto ecosCase = minutMiljoIntegrationService.getCase(caseId);

        List<OccurrenceListItemSvcDto> listOfOccurrence;
        if (ecosCase != null
                && ecosCase.getOccurrences() != null
                && ecosCase.getOccurrences().getOccurrenceListItemSvcDto() != null
                && !ecosCase.getOccurrences().getOccurrenceListItemSvcDto().isEmpty()) {
            listOfOccurrence = ecosCase.getOccurrences().getOccurrenceListItemSvcDto();

            listOfOccurrence.sort(Comparator.comparing(OccurrenceListItemSvcDto::getOccurrenceDate).reversed());

            // Use the latest
            return listOfOccurrence.get(0).getOccurrenceDescription();
        }
        return null;
    }

    public List<CaseStatus> getEcosStatusByOrgNr(String organizationNumber) {
        List<CaseStatus> caseStatusList = new ArrayList<>();

        ArrayOfPartySvcDto arrayOfPartySvcDto = searchParty(organizationNumber);

        // If we didn't find anything on the original organization number we modify and try again
        if (arrayOfPartySvcDto != null
                && arrayOfPartySvcDto.getPartySvcDto() != null
                && arrayOfPartySvcDto.getPartySvcDto().isEmpty()) {
            arrayOfPartySvcDto = searchParty(caseUtil.getCompletedOrganizationNumber(organizationNumber));
        }

        // Search Ecos Case
        if (arrayOfPartySvcDto != null
                && arrayOfPartySvcDto.getPartySvcDto() != null
                && !arrayOfPartySvcDto.getPartySvcDto().isEmpty()) {
            ArrayOfSearchCaseResultSvcDto caseResult = searchCase(arrayOfPartySvcDto.getPartySvcDto().get(0).getId(), Constants.ECOS_FACILITY_ROLE_ID_VERKSAMHETSUTOVARE);
            if (caseResult != null) {
                caseResult.getSearchCaseResultSvcDto().forEach(ecosArende -> {
                    List<CaseMapping> caseMappingList = caseDao.getCaseMapping(null, ecosArende.getCaseId());
                    String externalCaseId = caseMappingList.isEmpty() ? null : caseMappingList.get(0).getExternalCaseId();
                    String status = getStatus(ecosArende.getCaseId());

                    if (status != null) {
                        caseStatusList.add(new CaseStatus(SystemType.ECOS, externalCaseId, ecosArende.getCaseId(), status));
                    }
                });
            }
        }

        return caseStatusList;
    }

    private ArrayOfPartySvcDto searchParty(String organizationNumber) {
        SearchPartySvcDto searchPartySvcDto = new SearchPartySvcDto();
        searchPartySvcDto.setOrganizationIdentificationNumber(organizationNumber);
        return minutMiljoIntegrationService.searchParty(searchPartySvcDto);
    }

    private ArrayOfSearchCaseResultSvcDto searchCase(String partyId, String roleId) {
        SearchCaseSvcDto searchCaseSvcDto = new SearchCaseSvcDto();
        ArrayOfFilterSvcDto arrayOfFilterSvcDto = new ArrayOfFilterSvcDto();
        SinglePartyRoleFilterSvcDto filter = new SinglePartyRoleFilterSvcDto();

        filter.setPartyId(partyId);
        filter.setRoleId(roleId);
        arrayOfFilterSvcDto.getFilterSvcDto().add(filter);
        searchCaseSvcDto.setFilters(arrayOfFilterSvcDto);

        return minutMiljoIntegrationService.searchCase(searchCaseSvcDto);
    }
}
