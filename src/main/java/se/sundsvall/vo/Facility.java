package se.sundsvall.vo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import se.sundsvall.validators.PlanningConstraints;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Schema(oneOf = {PlanningPermissionFacility.class, EnvironmentalFacility.class})
@JsonPropertyOrder({"facilityType", "description", "address"})
@Getter
@Setter
public abstract class Facility {

    @Schema(example = "En fritextbeskrivning av facility.")
    private String description;

    @NotNull(groups = PlanningConstraints.class)
    @Valid
    private Address address;

}
