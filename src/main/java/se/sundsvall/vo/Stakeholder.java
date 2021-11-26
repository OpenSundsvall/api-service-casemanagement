package se.sundsvall.vo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import se.sundsvall.validators.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import java.util.List;

@Schema(oneOf = {Person.class, Organization.class})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true)
@JsonSubTypes({@Type(value = Person.class, name = StakeholderType.Constants.PERSON_VALUE),
        @Type(value = Organization.class, name = StakeholderType.Constants.ORGANIZATION_VALUE)})
@JsonPropertyOrder({"type", "roles", "organizationName", "organizationNumber", "firstName", "lastName", "personId",
        "phoneNumber", "emailAddress", "address", "billingAddress"})
@Getter
@Setter
public abstract class Stakeholder {
    @NotNull
    private StakeholderType type;
    @NotNull
    @Schema(description = "En intressent kan ha en eller flera roller.")
    @EnvironmentStakeholderRole(groups = EnvironmentalConstraints.class)
    @PlanningStakeholderRole(groups = PlanningConstraints.class)
    private List<StakeholderRole> roles;
    @Schema(example = "060121212")
    private String phoneNumber;
    @Schema(example = "0701231212")
    private String cellphoneNumber;
    @Email
    @Schema(example = "test.testorsson@test.se")
    private String emailAddress;
    @Valid
    @ConvertGroup(from = PlanningConstraints.class, to = DefaultConstraints.class)
    @ConvertGroup(from = EnvironmentalConstraints.class, to = DefaultConstraints.class)
    @Schema(description = "En intressent kan ha en eller flera adresser. T.ex. en adress av typen POSTAL_ADDRESS och en annan av typen INVOICE_ADDRESS.")
    private List<Address> addresses;

}
