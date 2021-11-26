package se.sundsvall.vo;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import se.sundsvall.validators.OnlyOneMainFacility;

import javax.validation.Valid;
import java.util.List;

@Schema(description = "Bygglovsärende (ByggR)")
@Getter
@Setter
public class PlanningPermissionCase extends Case {

//    TODO Can't use this validation before "facility" is removed
//    @NotEmpty
    @OnlyOneMainFacility
    @Valid
    private List<PlanningPermissionFacility> facilities;

    // TODO Deprecated, remove when API version 1.1 is not used anymore
    @Schema(hidden = true)
    @Valid
    private PlanningPermissionFacility facility;

    @Schema(description = "Diarienummer")
    private String diaryNumber;

}
