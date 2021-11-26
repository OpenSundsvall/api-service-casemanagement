package se.sundsvall.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import se.sundsvall.validators.EnvironmentalConstraints;
import se.sundsvall.validators.PlanningConstraints;

@JsonPropertyOrder({ "addressCategories", "street", "houseNumber", "postalCode", "city", "country", "careOf",
        "attention", "propertyDesignation", "appartmentNumber", "location", "isZoningPlanArea" })
@Data
public class Address {

    @NotEmpty
    @Schema(description = "En adress kan ha en eller flera adresskategorier. Det kan exempelvis vara samma adress som ska användas för post och fakturor.")
    private List<AddressCategory> addressCategories;

    @Schema(example = "Testvägen")
    private String street;

    @Schema(example = "18")
    private String houseNumber;

    @Schema(example = "123 45")
    private String postalCode;

    @Schema(example = "Sundsvall")
    private String city;

    @Schema(example = "Sverige")
    private String country;

    @Schema(description = "c/o", example = "Test Testorsson")
    private String careOf;

    @Schema(example = "Test Testorsson")
    private String attention;

    @NotBlank(groups = { EnvironmentalConstraints.class, PlanningConstraints.class })
    @Schema(description = "Fastighetsbeteckning", example = "SUNDSVALL LJUSTA 7:2")
    private String propertyDesignation;

    @Schema(example = "LGH 1001")
    private String appartmentNumber;

    private Coordinates location;

    @Schema(description = "Ligger inom detaljplanerat område")
    private Boolean isZoningPlanArea;

    @Schema(description = "Märkning av faktura (anges endast i samband med addressCategory INVOICE_ADDRESS)")
    private String invoiceMarking;

}
