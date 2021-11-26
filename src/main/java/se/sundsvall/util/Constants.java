package se.sundsvall.util;

public final class Constants {

    private Constants() {

    }

    ////////////////// ByggR
    public static final String BYGGR_ARENDEMENING_BYGGLOV_FOR_NYBYGGNAD_AV = "Bygglov för nybyggnad av";
    public static final String BYGGR_HANDELSE_RUBRIK_MANUELL_HANTERING = "Manuell hantering";
    public static final String BYGGR_HANDELSE_RUBRIK_BYGGLOV = "Bygglov";
    public static final String BYGGR_HANDELSE_RIKTNING_IN = "In";
    public static final String BYGGR_HANDELSETYP_STATUS = "STATUS";
    public static final String BYGGR_HANDELSETYP_ANSOKAN = "ANSÖKAN";
    public static final String BYGGR_HANDELSETYP_ANMALAN = "ANM";
    public static final String BYGGR_HANDELSETYP_BESLUT = "BESLUT";
    public static final String BYGGR_HANDELSETYP_HANDLING = "HANDLING";
    public static final String BYGGR_HANDELSETYP_ATOMHANDELSE = "Atom";
    public static final String BYGGR_HANDELSETYP_REMISS = "REMISS";
    public static final String BYGGR_HANDELSETYP_UNDERRATTELSE = "UNDER";
    public static final String BYGGR_HANDELSETYP_KOMPLETTERINGSFORELAGGANDE = "KOMP";
    public static final String BYGGR_HANDELSETYP_KOMPLETTERINGSFORELAGGANDE_PAMINNELSE = "KOMP1";

    public static final String BYGGR_HANDELSESLAG_BYGGLOV = "Bygglov";
    public static final String BYGGR_HANDELSESLAG_SLUTBESKED = "SLU";
    public static final String BYGGR_HANDELSESLAG_AVSKRIVNING = "UAB";
    public static final String BYGGR_HANDELSESLAG_MANUELL_HANTERING_KRAVS = "MANHANT";
    public static final String BYGGR_HANDELSESLAG_KOMPLETTERANDE_HANDLINGAR = "KOMPL";
    public static final String BYGGR_HANDELSESLAG_KOMPLETTERANDE_BYGGLOVHANDLINGAR = "KOMPBYGG";
    public static final String BYGGR_HANDELSESLAG_KOMPLETTERANDE_TEKNISKA_HANDLINGAR = "KOMPTEK";
    public static final String BYGGR_HANDELSESLAG_REVIDERADE_HANDLINGAR = "KOMPREV";
    public static final String BYGGR_HANDELSESLAG_ATOM_KVITTENS = "Kv";
    public static final String BYGGR_HANDELSESLAG_UTSKICK_AV_REMISS = "UTSKICK";
    public static final String BYGGR_HANDELSESLAG_MED_KRAV_PA_SVAR = "Med";
    public static final String BYGGR_HANDELSESLAG_UTAN_KRAV_PA_SVAR = "Utan";

    public static final String BYGGR_HANDELSEUTFALL_ATOM_KVITTENS_HL_BYTE = "Kv2";

    public static final String BYGGR_STATUS_AVSLUTAT = "Avslutat";

    public static final String BYGGR_HANDLING_STATUS_INKOMMEN = "Inkommen";
    public static final String BYGGR_HANDLAGGAR_SIGN = "SSA";
    public static final String BYGGR_NAMNDKOD_STADSBYGGNADSNAMNDEN = "SBN";
    public static final String BYGGR_KOMMUNKOD_SUNDSVALL_KOMMUN = "2281";
    public static final String BYGGR_ENHETKOD_STADSBYGGNADSKONTORET = "SBK";
    public static final String BYGGR_ARENDEGRUPP_LOV_ANMALNINGSARENDE = "LOV";
    public static final String BYGGR_ARENDETYP_BYGGLOV_FOR = "BL";
    public static final String BYGGR_ARENDESLAG_NYBYGGNAD_AV = "A";
    public static final String BYGGR_HANDELSE_ANTECKNING_INTRESSENT_KUNDE_INTE_REGISTRERAS = "Det finns intressenter som inte kunde registreras maskinellt. Dessa måste registreras manuellt. Dessa hittar du i handlingen \"Ansökan om bygglov\"."
            + "\n";
    public static final String BYGGR_HANDELSE_ANTECKNING_KONTROLLANSVARIG = "Det finns uppgifter om kontrollansvarig i handlingen \"Ansökan om bygglov\". Du måste registrera denna typ av intressenter manuellt."
            + "\n";
    public static final String BYGGR_KOMTYP_MOBIL = "MOB";
    public static final String BYGGR_KOMTYP_HEMTELEFON = "HEM";
    public static final String BYGGR_KOMTYP_EPOST = "Epost";


    ////////////////// Ecos
    public static final String ECOS_OCCURENCE_TYPE_ID_ANMALAN = "34BA125B-E9EE-4389-AEAE-9F66288C1B63";
    public static final String ECOS_PROCESS_TYPE_ID_REGISTRERING_AV_LIVSMEDELSANLAGGNING = "A764A86B-7327-445B-98C5-C26543D6F705";
    public static final String ECOS_HANDLING_OFFICER_GROUP_ID_EXPEDITIONEN = "58E6A5CE-C6EE-42B4-A96A-BD25D693420E";
    public static final String ECOS_DOCUMENT_TYPE_ID_ANMALAN_LIVSMEDELSANLAGGNING = "3AD42CEE-C09E-401B-ABE8-0CD5D03FE6B4";
    public static final String ECOS_FACILITY_ROLE_ID_FAKTURAMOTTAGARE = "480E2731-1F2F-4F35-8A37-FDDE957E9CD0";
    public static final String ECOS_FACILITY_ROLE_ID_VERKSAMHETSUTOVARE = "45A48C9F-9BAC-45DB-8D47-CDA790E17383";
    public static final String ECOS_FACILITY_ROLE_ID_KONTAKTPERSON = "EC77F83B-4C0F-412F-B145-8E4C18F1ACA0";
    public static final String ECOS_ADDRESS_TYPE_ID_FAKTURAADRESS = "EEF91381-7025-4FE7-B5FA-92FB2B77976B";
    public static final String ECOS_ADDRESS_TYPE_ID_POSTADRESS = "B1D7655C-D2D9-4D69-96A2-1267960C6102";
    public static final String ECOS_ADDRESS_TYPE_ID_BESOKSADRESS = "00CCE3B3-52C0-4B7E-AF68-A8204F595A48";
    public static final String ECOS_CONTACT_DETAIL_TYPE_ID_OVRIGT = "BF1F20E2-7687-4BE0-86CF-06A7F6B31303";
    public static final String ECOS_CONTACT_DETAIL_TYPE_ID_EPOST = "D34442AC-D8F7-419A-BE2B-2794674DE58E";
    public static final String ECOS_CONTACT_DETAIL_TYPE_ID_MOBIL = "9C26C006-76A9-4331-8B00-67984AC40885";
    public static final String ECOS_CONTACT_DETAIL_TYPE_ID_TELEFON = "2BB38776-54E4-405E-9E84-BD841C6BB2C3";
    public static final String ECOS_CONTACT_DETAIL_TYPE_ID_HUVUDNUMMER = "6DCBE753-81C5-4FA5-B0D4-0216411CB119";
    public static final String ECOS_OCCURRENCE_TYPE_ID_INFO_FRAN_ETJANST = "BF28124A-7C51-452C-8F72-16412364F8C2";
    public static final String ECOS_OCCURENCE_TEXT_MOBIL_ANLAGGNING = "Anläggningen kunde inte registreras automatiskt då anläggningen var av typen \"mobil\".\n" +
            "Denna anläggning och tillhörande part/-er måste registreras manuellt.\n" +
            "Informationen finns i handlingen \"Anmälan livsmedelsanläggning\".";


    ////////////////// RFC-url
    public static final String RFC_LINK_BAD_REQUEST = "https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.1";
    public static final String RFC_LINK_NOT_FOUND = "https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.4";
    public static final String RFC_LINK_NOT_ALLOWED = "https://datatracker.ietf.org/doc/html/rfc7231#section-6.5.5";
    public static final String RFC_LINK_INTERNAL_SERVER_ERROR = "https://datatracker.ietf.org/doc/html/rfc7231#section-6.6.1";

    ////////////////// Error messages
    public static final String ERR_MSG_ONLY_ONE_MAIN_FACILITY = "Number of mainFacilities must be <= 1";
    public static final String ERR_MSG_CASEMAPPINGS_NOT_FOUND = "CaseMappings not found";
    public static final String ERR_MSG_CASES_NOT_FOUND = "Case not found";
    public static final String ERR_MSG_STATUS_NOT_FOUND = "Status not found";
    public static final String ERR_MSG_UNHANDLED_EXCEPTION = "An unhandled exception occurred. Contact the person responsible for the application. More information is provided in the log.";
    public static final String ERR_MSG_PERSON_INVOICE_ADDRESS = "Stakeholders of type PERSON should not have an address with the addressCategory INVOICE_ADDRESS";
    public static final String ERR_MSG_EXTERNAL_SERVICE = "Something went wrong in the request to an external service.";
    public static final String ERR_MSG_WRONG_ROLE_ENV_CASE = "Stakeholder contains a role that may not be used with caseType: LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING. Check the OpenAPI-specification.";
    public static final String ERR_MSG_WRONG_ROLE_PLANNING_CASE = "Stakeholder contains a role that may not be used with caseType: NYBYGGNAD_ANSOKAN_OM_BYGGLOV. Check the OpenAPI-specification.";
    public static final String ERR_THIS_DATE_MUST_BE_TODAY_OR_FUTURE = "This date must be today or in the future";
    public static final String ERR_START_MUST_BE_BEFORE_END = "startDate must be before endDate";
    public static final String ORGNR_PATTERN_MESSAGE = "organizationNumber must consist of 10 or 12 digits. 10 digit orgnr must follow this format: \"XXXXXX-XXXX\". 12 digit orgnr must follow this format: \"(18|19|20)XXXXXX-XXXX\".";
    public static final String ORGNR_PATTERN_REGEX = "^((18|19|20|21)\\d{6}|\\d{6})-(\\d{4})$";

    public static String ERR_MSG_PERSONAL_NUMBER_NOT_FOUND_WITH_PERSON_ID(String personId) {
        return "No personalNumber was found in CitizenMapping with personId: " + personId;
    }

    public static String ERR_MSG_PROPERTY_DESIGNATION_NOT_FOUND(String propertyDesignation) {
        return "The specified propertyDesignation(" + propertyDesignation + ") could not be found";
    }


    ////////////////// Övrigt
    public static final String LANTMATERIET_REFERENS_STATUS_GALLANDE = "Gällande";
    public static final String FB_DATABASE = "Standard";
}

