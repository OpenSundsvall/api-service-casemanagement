package se.sundsvall.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import se.sundsvall.validators.EnvironmentalCaseDateOrder;
import se.sundsvall.validators.TodayOrFuture;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Schema(description = "Miljökontorärende (Ecos2)")
@JsonPropertyOrder({"startDate", "endDate"})
@EnvironmentalCaseDateOrder
@Getter
@Setter
public class EnvironmentalCase extends Case {

    //    TODO Can't use this validation before "facility" is removed
    //    @NotEmpty
    @Size(min = 1, max = 1, message = "size must be 1")
    @Valid
    private List<EnvironmentalFacility> facilities;

    // TODO Deprecated, remove when API version 1.1 is not used anymore
    @Schema(hidden = true)
    @Valid
    private EnvironmentalFacility facility;

    @NotNull
    @Schema(description = "Startdatum på verksamheten.", format = "date", example = "2022-01-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;


    @TodayOrFuture
    @Schema(description = "Slutdatum på verksamheten vid det fall den är tidsbegränsad.", format = "date", example = "2022-06-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

}
