package se.sundsvall.validators;

import se.sundsvall.vo.PlanningPermissionFacility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class OnlyOneMainFacilityValidator implements ConstraintValidator<OnlyOneMainFacility, List<PlanningPermissionFacility>> {

    @Override
    public boolean isValid(List<PlanningPermissionFacility> planningPermissionFacilityList, ConstraintValidatorContext context) {
        if (planningPermissionFacilityList == null) {
            // We can't do this validation if the list is null
            return true;
        }
        return planningPermissionFacilityList.stream().filter(PlanningPermissionFacility::isMainFacility).count() <= 1;
    }
}
