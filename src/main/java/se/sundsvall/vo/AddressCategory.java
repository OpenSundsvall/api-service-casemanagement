package se.sundsvall.vo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Kategorisering av adresser. " + "<li>POSTAL_ADDRESS(Postadress)</li>"
        + "<li>INVOICE_ADDRESS(Fakturaadress)</li>" + "<li>VISITING_ADDRESS(Besöksadress)</li>")
public enum AddressCategory {
    POSTAL_ADDRESS("Postadress"), INVOICE_ADDRESS("Fakturaadress"), VISITING_ADDRESS("Besöksadress");

    private final String text;

    AddressCategory(String text) {
        this.text = text;
    }
}
