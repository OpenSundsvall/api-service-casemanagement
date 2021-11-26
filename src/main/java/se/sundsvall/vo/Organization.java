package se.sundsvall.vo;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import se.sundsvall.util.Constants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class Organization extends Stakeholder {

    @NotBlank
    @Schema(example = "Sundsvalls testfabrik")
    private String organizationName;
    @NotBlank
    @Pattern(regexp = Constants.ORGNR_PATTERN_REGEX, message = Constants.ORGNR_PATTERN_MESSAGE)
    @Schema(description = "Organisationsnummer bestående av 10 eller 12 siffror.", example = "19901010-1234")
    private String organizationNumber;
    @Schema(description = "Firmatecknare", example = "Test Testorsson")
    private String authorizedSignatory;

}
