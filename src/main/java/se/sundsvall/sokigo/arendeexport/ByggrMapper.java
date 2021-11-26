package se.sundsvall.sokigo.arendeexport;

import com.fasterxml.jackson.core.JsonProcessingException;
import se.sundsvall.CaseDao;
import se.sundsvall.util.CaseUtil;
import se.sundsvall.util.Constants;
import se.sundsvall.validators.PlanningConstraints;
import se.sundsvall.vo.*;
import se.tekis.arende.*;
import se.tekis.servicecontract.Arende;
import se.tekis.servicecontract.ArrayOfArende1;
import se.tekis.servicecontract.ArrayOfHandling;
import se.tekis.servicecontract.SaveNewHandelseMessage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
public class ByggrMapper {

    @Inject
    CaseUtil caseUtil;

    @Inject
    CaseDao caseDao;

    @Inject
    ArendeExportIntegrationService arendeExportIntegrationService;

    public boolean containsControlOfficial(List<Stakeholder> stakeholderList) {
        for (Stakeholder s : stakeholderList) {

            if (s.getRoles().contains(StakeholderRole.CONTROL_OFFICIAL)) {
                return true;
            }
        }

        return false;
    }

    public boolean containsPersonDuplicates(List<Stakeholder> stakeholderList) {
        List<String> personIdList = stakeholderList.stream().filter(Person.class::isInstance)
                .map(Person.class::cast).map(Person::getPersonId).collect(Collectors.toList());

        for (Stakeholder s : stakeholderList) {

            if (s instanceof Person) {
                Person person = (Person) s;

                // If the request contains two person with the same personId, it must be handled manually
                if (personIdList.stream().filter(personId -> personId.equals(person.getPersonId())).count() > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public Handelse getByggrHandelse() {
        Handelse handelse = new Handelse();
        handelse.setRubrik(Constants.BYGGR_HANDELSE_RUBRIK_BYGGLOV);
        handelse.setRiktning(Constants.BYGGR_HANDELSE_RIKTNING_IN);
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_ANSOKAN);
        handelse.setHandelseslag(Constants.BYGGR_HANDELSESLAG_BYGGLOV);
        handelse.setStartDatum(LocalDateTime.now());

        return handelse;
    }

    public SaveNewHandelseMessage saveNewManuellHanteringHandelse(String dnr, String note) {
        SaveNewHandelseMessage saveNewHandelseMessage = new SaveNewHandelseMessage();
        saveNewHandelseMessage.setDnr(dnr);
        saveNewHandelseMessage.setHandlaggarSign(Constants.BYGGR_HANDLAGGAR_SIGN);

        Handelse handelse = new Handelse();
        handelse.setRubrik(Constants.BYGGR_HANDELSE_RUBRIK_MANUELL_HANTERING);
        handelse.setRiktning(Constants.BYGGR_HANDELSE_RIKTNING_IN);
        handelse.setHandelsetyp(Constants.BYGGR_HANDELSETYP_STATUS);
        handelse.setHandelseslag(Constants.BYGGR_HANDELSESLAG_MANUELL_HANTERING_KRAVS);
        handelse.setStartDatum(LocalDateTime.now());
        handelse.setAnteckning(note);

        saveNewHandelseMessage.setHandelse(handelse);
        return saveNewHandelseMessage;
    }

    public ArrayOfHandling getByggrHandlingar(PlanningPermissionCase pCase) {
        ArrayOfHandling arrayOfHandling = new ArrayOfHandling();

        for (Attachment file : pCase.getAttachments()) {
            HandelseHandling handling = new HandelseHandling();
            // The administrators in ByggR wants the name as a note to enable a quick overview of all documents.
            handling.setAnteckning(file.getName());

            Dokument doc = new Dokument();
            DokumentFil docFile = new DokumentFil();
            docFile.setFilBuffer(caseUtil.base64ToByteArray(file.getFile()));
            docFile.setFilAndelse(file.getExtension());
            doc.setFil(docFile);
            doc.setNamn(file.getName());

            handling.setDokument(doc);

            handling.setStatus(Constants.BYGGR_HANDLING_STATUS_INKOMMEN);
            handling.setTyp(file.getCategory().getText());

            arrayOfHandling.getHandling().add(handling);
        }
        return arrayOfHandling;
    }

    public Arende getByggrCase(PlanningPermissionCase pCase) throws JsonProcessingException {
        Arende arende = new Arende();

        // These are the same for all ByggR-cases right now because it only exists one CaseType right now.
        arende.setArendegrupp(Constants.BYGGR_ARENDEGRUPP_LOV_ANMALNINGSARENDE);
        arende.setArendetyp(Constants.BYGGR_ARENDETYP_BYGGLOV_FOR);
        arende.setArendeslag(Constants.BYGGR_ARENDESLAG_NYBYGGNAD_AV);
        arende.setNamndkod(Constants.BYGGR_NAMNDKOD_STADSBYGGNADSNAMNDEN);
        arende.setEnhetkod(Constants.BYGGR_ENHETKOD_STADSBYGGNADSKONTORET);
        arende.setKommun(Constants.BYGGR_KOMMUNKOD_SUNDSVALL_KOMMUN);

        arende.setArendeklass(getArendeKlass(pCase.getFacilities()));
        arende.setArInomplan(getInomPlan(pCase.getFacilities()));
        arende.setBeskrivning(getArendeBeskrivning(pCase));

        String propertyDesignation = getPropertyDesignation(pCase.getFacilities());
        if (propertyDesignation != null
                && propertyDesignation.startsWith("SUNDSVALL ")) {
            propertyDesignation = propertyDesignation.substring(propertyDesignation.indexOf(" ") + 1);
        }

        String invoiceMarking = getInvoiceMarking(pCase);

        // Projnr/Faktid in ByggR.
        arende.setProjektnr(invoiceMarking != null ? invoiceMarking : propertyDesignation);

        arende.setIntressentLista(getByggrIntressenter(pCase));
        arende.setObjektLista(getByggrArendeObjektLista(pCase));

        arende.setAnkomstDatum(LocalDate.now());

        return arende;
    }

    private String getInvoiceMarking(PlanningPermissionCase pCase) {
        String invoiceMarking = null;

        for (Stakeholder stakeholder : pCase.getStakeholders()) {
            if (stakeholder.getAddresses() != null) {
                for (Address address : stakeholder.getAddresses()) {
                    if (address.getAddressCategories().contains(AddressCategory.INVOICE_ADDRESS)
                            && address.getInvoiceMarking() != null && !address.getInvoiceMarking().isBlank()) {
                        invoiceMarking = address.getInvoiceMarking();
                    }
                }
            }
        }
        return invoiceMarking;
    }

    /**
     * "Ärendemening" - Is automatically set in ByggR based on "typ", "slag" and "klass",
     * but when it's multiple facilities, it must be set to contain all facilities.
     *
     * @param pCase PlanningPermissionCase
     * @return ärendemening or null
     */
    private String getArendeBeskrivning(PlanningPermissionCase pCase) {
        if (pCase.getCaseType().equals(CaseType.NYBYGGNAD_ANSOKAN_OM_BYGGLOV) && pCase.getFacilities().size() > 1) {
            StringBuilder arendeMening = new StringBuilder();
            arendeMening.append(Constants.BYGGR_ARENDEMENING_BYGGLOV_FOR_NYBYGGNAD_AV);

            List<PlanningPermissionFacility> facilityList = pCase.getFacilities().stream().sorted(Comparator.comparing(PlanningPermissionFacility::isMainFacility, Comparator.reverseOrder())).collect(Collectors.toList());

            for (int i = 0; i < facilityList.size(); i++) {
                if (i == facilityList.size() - 1) {
                    arendeMening.append(" &");
                } else if (i != 0) {
                    arendeMening.append(",");
                }
                arendeMening.append(" ").append(facilityList.get(i).getFacilityType().getDescription());
            }

            return arendeMening.toString();
        } else {
            return null;
        }
    }

    private String getPropertyDesignation(List<PlanningPermissionFacility> facilityList) {
        PlanningPermissionFacility facility = getMainOrTheOnlyFacility(facilityList);
        return facility != null ? facility.getAddress().getPropertyDesignation().trim().toUpperCase() : null;
    }

    private Boolean getInomPlan(List<PlanningPermissionFacility> facilityList) {
        PlanningPermissionFacility facility = getMainOrTheOnlyFacility(facilityList);
        return facility != null ? facility.getAddress().getIsZoningPlanArea() : null;
    }

    private PlanningPermissionFacility getMainOrTheOnlyFacility(List<PlanningPermissionFacility> facilityList) {
        if (facilityList.size() == 1) {
            // The list only contains one facility, return it.
            return facilityList.get(0);
        }

        // If the list contains more than one facility and mainFacility exists, return it.
        // If the list doesn't contain a mainFacility, return null.
        return facilityList.stream().anyMatch(PlanningPermissionFacility::isMainFacility) ?
                facilityList.stream().filter(PlanningPermissionFacility::isMainFacility).collect(Collectors.toList()).get(0) : null;
    }

    private String getArendeKlass(List<PlanningPermissionFacility> facilityList) {
        PlanningPermissionFacility facility = getMainOrTheOnlyFacility(facilityList);
        return facility != null ? facility.getFacilityType().getValue() : FacilityType.OTHER.getValue();
    }

    private ArrayOfAbstractArendeObjekt getByggrArendeObjektLista(PlanningPermissionCase pCase) {

        List<String> usedPropertyDesignations = new ArrayList<>();
        ArrayOfAbstractArendeObjekt arendeObjektLista = new ArrayOfAbstractArendeObjekt();

        pCase.getFacilities().forEach(f -> {
            if (usedPropertyDesignations.contains(f.getAddress().getPropertyDesignation())) {
                // If we already have created a "arendeFastighet" with the same propertyDesignation,
                // we should not create a duplicate. Skip this iteration.
                return;
            }

            ArendeFastighet arendeFastighet = new ArendeFastighet();

            arendeFastighet.setArHuvudObjekt(f.isMainFacility());

            Fastighet fastighet = new Fastighet();
            fastighet.setFnr(caseUtil.getPropertyInfo(f.getAddress().getPropertyDesignation()).getFnr());

            arendeFastighet.setFastighet(fastighet);

            arendeObjektLista.getAbstractArendeObjekt().add(arendeFastighet);
            usedPropertyDesignations.add(f.getAddress().getPropertyDesignation());
        });

        return arendeObjektLista;
    }

    ArrayOfArendeIntressent getByggrIntressenter(PlanningPermissionCase pCase) throws JsonProcessingException {

        ArrayOfArendeIntressent intressenter = new ArrayOfArendeIntressent();

        List<String> personIdList = pCase.getStakeholders().stream().filter(Person.class::isInstance)
                .map(Person.class::cast).map(Person::getPersonId).collect(Collectors.toList());

        for (Stakeholder s : pCase.getStakeholders()) {
            // We don't create stakeholders with the role "Kontrollansvarig", this must be handled manually.
            if (s.getRoles().contains(StakeholderRole.CONTROL_OFFICIAL)) {
                continue;
            }

            ArendeIntressent intressent = new ArendeIntressent();

            if (s instanceof Person) {
                Person person = (Person) s;

                // If the request contains two person with the same personId, it must be handled manually
                if (personIdList.stream().filter(personId -> personId.equals(person.getPersonId())).count() > 1) {
                    continue;
                } else {
                    setPersonFields(intressent, person);
                }

            } else if (s instanceof Organization) {
                Organization organization = (Organization) s;
                setOrganizationFields(intressent, organization);

            }

            if (s.getAddresses() != null) {
                for (Address address : s.getAddresses()) {
                    for (AddressCategory addressCategory : address.getAddressCategories()) {
                        if (addressCategory.equals(AddressCategory.POSTAL_ADDRESS)) {

                            setPostalAddressFields(intressent, address);

                            if (s instanceof Organization) {
                                IntressentAttention intressentAttention = new IntressentAttention();
                                intressentAttention.setAttention(address.getAttention());
                                intressent.setAttention(intressentAttention);
                            }

                        }
                        if (addressCategory.equals(AddressCategory.INVOICE_ADDRESS)) {
                            if (s instanceof Person) {
                                throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                                        .entity(new Information(Constants.RFC_LINK_BAD_REQUEST,
                                                Response.Status.BAD_REQUEST.getReasonPhrase(),
                                                Response.Status.BAD_REQUEST.getStatusCode(),
                                                Constants.ERR_MSG_PERSON_INVOICE_ADDRESS,
                                                "stakeholders"))
                                        .build());
                            }

                            intressent.setFakturaAdress(getByggrFakturaadress(address));
                        }
                    }

                }
            }

            intressent.setIntressentKommunikationLista(getByggrContactInfo(s, intressent.getAttention()));
            intressent.setRollLista(getByggrRoles(s));
            intressenter.getIntressent().add(intressent);
        }
        return intressenter;
    }

    void setPostalAddressFields(ArendeIntressent intressent, Address address) {
        intressent.setAdress(address.getHouseNumber() != null
                ? address.getStreet() + " " + address.getHouseNumber()
                : address.getStreet());
        intressent.setPostNr(address.getPostalCode());
        intressent.setOrt(address.getCity());
        intressent.setLand(address.getCountry());

        intressent.setCoAdress(address.getCareOf());
    }

    void setOrganizationFields(ArendeIntressent intressent, Organization organization) {
        intressent.setArForetag(true);
        intressent.setNamn(organization.getOrganizationName());
        intressent.setPersOrgNr(caseUtil.getCompletedOrganizationNumber(organization.getOrganizationNumber()));
    }

    void setPersonFields(ArendeIntressent intressent, Person person) throws JsonProcessingException {
        intressent.setArForetag(false);
        intressent.setFornamn(person.getFirstName());
        intressent.setEfternamn(person.getLastName());
        String pnr = caseUtil.getPersonalNumber(person.getPersonId());
        if (pnr != null && pnr.length() == 12) {
            pnr = pnr.substring(0, 8) + "-" + pnr.substring(8);
        }

        intressent.setPersOrgNr(pnr);
    }

    ArrayOfString getByggrRoles(Stakeholder s) {
        ArrayOfString roles = new ArrayOfString();
        for (StakeholderRole r : s.getRoles()) {

            roles.getRoll().add(r.getText());
        }
        return roles;
    }

    Fakturaadress getByggrFakturaadress(Address address) {
        Fakturaadress fakturaAdress = new Fakturaadress();
        fakturaAdress.setAdress(address.getHouseNumber() != null
                ? address.getStreet() + " " + address.getHouseNumber()
                : address.getStreet());
        fakturaAdress.setAttention(address.getAttention());
        fakturaAdress.setLand(address.getCountry());
        fakturaAdress.setOrt(address.getCity());
        fakturaAdress.setPostNr(address.getPostalCode());
        return fakturaAdress;
    }

    ArrayOfIntressentKommunikation getByggrContactInfo(Stakeholder s, IntressentAttention intressentAttention) {
        ArrayOfIntressentKommunikation arrayOfIntressentKommunikation = new ArrayOfIntressentKommunikation();
        if (s.getCellphoneNumber() != null) {
            IntressentKommunikation intressentKommunikation = new IntressentKommunikation();
            intressentKommunikation.setArAktiv(true);
            intressentKommunikation.setBeskrivning(s.getCellphoneNumber());
            intressentKommunikation.setKomtyp(Constants.BYGGR_KOMTYP_MOBIL);
            intressentKommunikation.setAttention(intressentAttention);
            arrayOfIntressentKommunikation.getIntressentKommunikation().add(intressentKommunikation);
        }
        if (s.getPhoneNumber() != null) {
            IntressentKommunikation intressentKommunikation = new IntressentKommunikation();
            intressentKommunikation.setArAktiv(true);
            intressentKommunikation.setBeskrivning(s.getPhoneNumber());
            intressentKommunikation.setKomtyp(Constants.BYGGR_KOMTYP_HEMTELEFON);
            intressentKommunikation.setAttention(intressentAttention);
            arrayOfIntressentKommunikation.getIntressentKommunikation().add(intressentKommunikation);
        }
        if (s.getEmailAddress() != null) {
            IntressentKommunikation intressentKommunikation = new IntressentKommunikation();
            intressentKommunikation.setArAktiv(true);
            intressentKommunikation.setBeskrivning(s.getEmailAddress());
            intressentKommunikation.setKomtyp(Constants.BYGGR_KOMTYP_EPOST);
            intressentKommunikation.setAttention(intressentAttention);
            arrayOfIntressentKommunikation.getIntressentKommunikation().add(intressentKommunikation);
        }
        return arrayOfIntressentKommunikation;
    }

    public void validate(PlanningPermissionCase pCase) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<PlanningPermissionCase>> violations = validator.validate(pCase,
                PlanningConstraints.class);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public String getByggrStatus(Arende arende) {
        String status = null;

        // OEP-status = Ärendet arkiveras
        if (arende.getStatus() != null && arende.getStatus().equals(Constants.BYGGR_STATUS_AVSLUTAT)) {
            // Avslutat
            status = arende.getStatus();
        }

        // If the case is closed, we don't need to check for any occurrence
        if (status == null
                && arende.getHandelseLista() != null
                && arende.getHandelseLista().getHandelse() != null) {
            List<Handelse> handelseLista = arende.getHandelseLista().getHandelse();

            handelseLista.sort(Comparator.comparing(Handelse::getStartDatum).reversed());

            for (Handelse h : handelseLista) {

                status = getHandelseStatus(h.getHandelsetyp(), h.getHandelseslag(), h.getHandelseutfall());

                if (status != null) {
                    break;
                }
            }
        }
        return status;
    }

    private String getHandelseStatus(String handelsetyp, String handelseslag, String handelseutfall) {

        // OEP-status = Inskickat
        if (Constants.BYGGR_HANDELSETYP_ANMALAN.equals(handelsetyp)
                || Constants.BYGGR_HANDELSETYP_ANSOKAN.equals(handelsetyp)) {
            // ANM, ANSÖKAN
            return handelsetyp;
        }

        // OEP-status = Klart
        else if (Constants.BYGGR_HANDELSETYP_BESLUT.equals(handelsetyp)
                && (Constants.BYGGR_HANDELSESLAG_SLUTBESKED.equals(handelseslag)
                || Constants.BYGGR_HANDELSESLAG_AVSKRIVNING.equals(handelseslag))) {
            // SLU, UAB
            return handelseslag;
        }

        // OEP-status = Kompletterad
        else if (Constants.BYGGR_HANDELSETYP_HANDLING.equals(handelsetyp)
                && Constants.BYGGR_HANDELSESLAG_KOMPLETTERANDE_HANDLINGAR.equals(handelseslag)
                || Constants.BYGGR_HANDELSESLAG_KOMPLETTERANDE_BYGGLOVHANDLINGAR.equals(handelseslag)
                || Constants.BYGGR_HANDELSESLAG_KOMPLETTERANDE_TEKNISKA_HANDLINGAR.equals(handelseslag)
                || Constants.BYGGR_HANDELSESLAG_REVIDERADE_HANDLINGAR.equals(handelseslag)) {
            // KOMPL, KOMPBYGG, KOMPTEK, KOMPREV
            return handelseslag;
        }

        // OEP-status = Under behandling
        else if (Constants.BYGGR_HANDELSETYP_ATOMHANDELSE.equals(handelsetyp)
                && Constants.BYGGR_HANDELSESLAG_ATOM_KVITTENS.equals(handelseslag)
                && Constants.BYGGR_HANDELSEUTFALL_ATOM_KVITTENS_HL_BYTE.equals(handelseutfall)) {
            // Kv2
            return handelseutfall;
        } else if (Constants.BYGGR_HANDELSETYP_REMISS.equals(handelsetyp)
                && Constants.BYGGR_HANDELSESLAG_UTSKICK_AV_REMISS.equals(handelseslag)) {
            // UTSKICK
            return handelseslag;
        } else if (Constants.BYGGR_HANDELSETYP_UNDERRATTELSE.equals(handelsetyp)
                && (Constants.BYGGR_HANDELSESLAG_MED_KRAV_PA_SVAR.equals(handelseslag) || Constants.BYGGR_HANDELSESLAG_UTAN_KRAV_PA_SVAR.equals(handelseslag))) {
            // UNDER
            return handelsetyp;
        }

        // OEP-status = Väntar på komplettering
        else if (Constants.BYGGR_HANDELSETYP_KOMPLETTERINGSFORELAGGANDE.equals(handelsetyp)
                || Constants.BYGGR_HANDELSETYP_KOMPLETTERINGSFORELAGGANDE_PAMINNELSE.equals(handelsetyp)) {
            // KOMP, KOMP1
            return handelsetyp;
        }

        return null;
    }

    public List<CaseStatus> getByggrStatusByOrgNr(String organizationNumber) {
        List<CaseStatus> caseStatusList = new ArrayList<>();
        se.tekis.servicecontract.ArrayOfString arendeIntressentRoller = new se.tekis.servicecontract.ArrayOfString();
        arendeIntressentRoller.getString().add(StakeholderRole.APPLICANT.getText());
        se.tekis.servicecontract.ArrayOfString handelseIntressentRoller = new se.tekis.servicecontract.ArrayOfString();
        handelseIntressentRoller.getString().add(StakeholderRole.APPLICANT.getText());
        ArrayOfArende1 arrayOfByggrArende = arendeExportIntegrationService.getRelateradeArendenByPersOrgNrAndRole(organizationNumber, arendeIntressentRoller, handelseIntressentRoller);

        if (arrayOfByggrArende != null) {
            if (arrayOfByggrArende.getArende().isEmpty()) {
                String modifiedOrgNr = caseUtil.getCompletedOrganizationNumber(organizationNumber);
                arrayOfByggrArende = arendeExportIntegrationService.getRelateradeArendenByPersOrgNrAndRole(modifiedOrgNr, arendeIntressentRoller, handelseIntressentRoller);
            }

            arrayOfByggrArende.getArende().forEach(byggrArende -> {
                List<CaseMapping> caseMappingList = caseDao.getCaseMapping(null, byggrArende.getDnr());
                String externalCaseId = caseMappingList.isEmpty() ? null : caseMappingList.get(0).getExternalCaseId();
                String status = getByggrStatus(byggrArende);

                if (status != null) {
                    caseStatusList.add(new CaseStatus(SystemType.BYGGR, externalCaseId, byggrArende.getDnr(), status));
                }

            });
        }

        return caseStatusList;
    }
}
