package se.sundsvall.validators;

import se.sundsvall.vo.StakeholderRole;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class EnvironmentStakeholderRoleConstraintValidator
        implements ConstraintValidator<EnvironmentStakeholderRole, List<StakeholderRole>> {

    @Override
    public boolean isValid(List<StakeholderRole> value, ConstraintValidatorContext context) {
        for (StakeholderRole role : value) {
            switch (role) {
                case CONTACT_PERSON:
                case INVOICE_RECIPENT:
                case OPERATOR:
                    break;
                default:
                    return false;
            }
        }

        return true;

    }

}
