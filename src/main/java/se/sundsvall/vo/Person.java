package se.sundsvall.vo;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import se.sundsvall.validators.PlanningConstraints;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Person extends Stakeholder {

    @NotBlank
    @Schema(example = "Test")
    private String firstName;
    @NotBlank
    @Schema(example = "Testorsson")
    private String lastName;
    @NotBlank(groups = PlanningConstraints.class)
    @Pattern(regexp = "^[{]?[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}[}]?$", message = "personId must be a valid GUID")
    @Schema(example = "3ed5bc30-6308-4fd5-a5a7-78d7f96f4438")
    private String personId;

}
