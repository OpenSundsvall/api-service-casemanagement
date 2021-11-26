package se.sundsvall.vo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "<h3>Generella-roller:</h3><li>CONTACT_PERSON(Kontaktperson)</li>"
        + "<br><br><h3>Bygglovsärende-roller:</h3><li>CONTROL_OFFICIAL(Kontrollansvarig)</li><li>APPLICANT(Sökande)<li>PROPERTY_OWNER(Fastighetsägare)</li><li>PAYMENT_PERSON(Betalningsansvarig)</li>"
        + "<br><br><h3>Miljökontorärende-roller:</h3><li>INVOICE_RECIPENT(Fakturamottagare)</li><li>OPERATOR(Verksamhetsutövare)</li>")
public enum StakeholderRole {

    // ByggR

    // Kontrollansvarig
    CONTROL_OFFICIAL("KOA"),
    // Sökande
    APPLICANT("SOK"),
    // Fastighetsägare
    PROPERTY_OWNER("FAG"),
    // Betalningsansvarig
    PAYMENT_PERSON("BETA"),

    // Gemensamma

    // Kontaktperson
    CONTACT_PERSON("KPER"),

    // Ecos

    INVOICE_RECIPENT("Fakturamottagare"), OPERATOR("Verksamhetsutövare");

    private final String text;

    StakeholderRole(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
