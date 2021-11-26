package se.sundsvall.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaseStatus {

    private SystemType system;
    private String externalCaseId;
    private String caseId;
    @Schema(description = "Status på ärendet", example = "Pågående")
    private String status;
}
