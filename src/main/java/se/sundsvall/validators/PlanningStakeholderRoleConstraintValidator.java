package se.sundsvall.validators;

import se.sundsvall.vo.StakeholderRole;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class PlanningStakeholderRoleConstraintValidator
        implements ConstraintValidator<PlanningStakeholderRole, List<StakeholderRole>> {

    @Override
    public boolean isValid(List<StakeholderRole> value, ConstraintValidatorContext context) {
        for (StakeholderRole role : value) {
            switch (role) {
                case CONTACT_PERSON:
                case PAYMENT_PERSON:
                case PROPERTY_OWNER:
                case APPLICANT:
                case CONTROL_OFFICIAL:
                    break;

                default:
                    return false;
            }
        }

        return true;
    }

}
