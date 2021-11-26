package se.sundsvall.vo;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "Typ av byggnad."
        + "<br><br>Typer:"
        + "<li>ONE_FAMILY_HOUSE(enbostadshus)</li>"
        + "<li>APARTMENT_BLOCK(flerbostadshus)</li>"
        + "<li>WEEKEND_COTTAGE(fritidshus)</li>"
        + "<li>OFFICE_BUILDING(kontorsbyggnad)</li>"
        + "<li>INDUSTRIAL_BUILDING(industribyggnad)</li>"
        + "<li>GARAGE(garage)</li>"
        + "<li>CARPORT(carport)</li>"
        + "<li>STOREHOUSE(förråd)</li>"
        + "<li>GREENHOUSE(växthus)</li>"
        + "<li>GUEST_HOUSE(gäststuga)</li>"
        + "<li>WAREHOUSE(lagerbyggnad)</li>"
        + "<li>WORKSHOP_BUILDING(Verkstadsbyggnad)</li>"
        + "<li>RESTAURANT(Restaurang)</li>"
        + "<li>SCHOOL(Skola)</li>"
        + "<li>PRESCHOOL(Förskola)</li>"
        + "<li>PARKING(Parkering, Cykelparkering)</li>"
        + "<li>DEPOT(Upplag)</li>"
        + "<li>MARINA(Småbåtshamn)</li>"
        + "<li>WALL(Mur)</li>"
        + "<li>PALING(Plank)</li>"
        + "<li>OTHER(övrigt)</li>")
public enum FacilityType {

    // ByggR

    // enbostadshus
    ONE_FAMILY_HOUSE("EB", "enbostadshus"),
    // flerbostadshus
    APARTMENT_BLOCK("FB", "flerbostadshus"),
    // fritidshus
    WEEKEND_COTTAGE("FRI", "fritidshus"),
    // kontorsbyggnad
    OFFICE_BUILDING("KB", "kontorsbyggnad"),
    // industribyggnad
    INDUSTRIAL_BUILDING("IND", "industribyggnad"),
    // garage
    GARAGE("GA", "garage"),
    // carport
    CARPORT("CP", "carport"),
    // förråd
    STOREHOUSE("FÖRR", "förråd"),
    // växthus
    GREENHOUSE("VX", "växthus"),
    // gäststuga
    GUEST_HOUSE("GÄST", "gäststuga"),
    // lagerbyggnad
    WAREHOUSE("LB", "lagerbyggnad"),
    // Verkstadsbyggnad
    WORKSHOP_BUILDING("VERK", "verkstadsbyggnad"),
    // Restaurang
    RESTAURANT("REST", "restaurang"),
    // Skola
    SCHOOL("SKOL", "skola"),
    // Förskola
    PRESCHOOL("FÖRS", "förskola"),
    // Parkering
    // Cykelparkering
    PARKING("PAR", "parkering"),
    // Upplag
    DEPOT("UPP", "upplag"),
    // Småbåtshamn
    MARINA("SMÅBH", "småbåtshamn"),
    // Mur
    WALL("MUR", "mur"),
    // Plank
    PALING("PL", "plank"),
    // övrigt
    OTHER("ÖVRI", "övrigt");

    private final String value;
    private final String description;

    FacilityType(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
