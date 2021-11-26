package se.sundsvall.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Schema(oneOf = {PlanningPermissionCase.class, EnvironmentalCase.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "caseType", visible = true)
@JsonSubTypes({
        @Type(value = PlanningPermissionCase.class, name = CaseType.Constants.NYBYGGNAD_ANSOKAN_OM_BYGGLOV_VALUE),
        @Type(value = EnvironmentalCase.class, name = CaseType.Constants.LIVSMEDELSVERKSAMHET_ANMALAN_OM_REGISTRERING_VALUE)})
@JsonPropertyOrder({"id", "status", "externalCaseId", "caseType", "description", "stakeholders", "attachments"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Case {

    @Schema(readOnly = true)
    @Getter
    private Long id;
    @NotNull
    @Schema(description = "ÄrendeId från Open-E", example = "1")
    @Getter
    @Setter
    private String externalCaseId;
    @NotNull
    @Getter
    @Setter
    private CaseType caseType;
    @Schema(description = "Beskriv kort vad du vill bygga", example = "En fritextbeskrivning av case.")
    @Getter
    @Setter
    private String description;
    @NotEmpty
    @Valid
    @Getter
    @Setter
    private List<Stakeholder> stakeholders;
    @NotEmpty
    @Valid
    @Getter
    @Setter
    private List<Attachment> attachments;
}
