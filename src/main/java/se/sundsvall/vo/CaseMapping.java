package se.sundsvall.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Entity
@IdClass(IdPk.class)
@ToString
@NoArgsConstructor
public class CaseMapping {

    public CaseMapping(String externalCaseId, String caseId, SystemType system) {
        this.externalCaseId = externalCaseId;
        this.caseId = caseId;
        this.system = system;
    }

    @Getter
    @Setter
    @Id
    @Column(unique = true)
    private String externalCaseId;

    @Getter
    @Setter
    @Id
    private String caseId;

    @Getter
    @Setter
    @NotNull
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SystemType system;

    @Getter
    @Schema(readOnly = true)
    private LocalDateTime timestamp;

    @PrePersist
    @PreUpdate
    protected void onPersistAndUpdate() {
        timestamp = LocalDateTime.now().truncatedTo(ChronoUnit.MICROS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaseMapping that = (CaseMapping) o;
        return Objects.equals(externalCaseId, that.externalCaseId) && Objects.equals(caseId, that.caseId) && system == that.system && Objects.equals(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalCaseId, caseId, system, timestamp);
    }
}

@Embeddable
@Getter
@Setter
class IdPk implements Serializable {

    private String externalCaseId;
    private String caseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IdPk idPk = (IdPk) o;
        return Objects.equals(externalCaseId, idPk.externalCaseId) && Objects.equals(caseId, idPk.caseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalCaseId, caseId);
    }
}