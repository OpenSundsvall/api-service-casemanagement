package se.sundsvall.vo;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.constraints.NotBlank;

public class EnvironmentalFacility extends Facility {

    @NotBlank
    @Schema(description = "Skyltnamn", example = "Sundsvalls testfabrik")
    @Getter
    @Setter
    private String facilityCollectionName;

}
