package se.sundsvall.validators;

import se.sundsvall.vo.EnvironmentalCase;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnvironmentalCaseDateOrderValidator implements ConstraintValidator<EnvironmentalCaseDateOrder, EnvironmentalCase> {
    @Override
    public boolean isValid(EnvironmentalCase environmentalCase, ConstraintValidatorContext context) {
        if (environmentalCase.getStartDate() != null && environmentalCase.getEndDate() != null) {
            return environmentalCase.getStartDate().isBefore(environmentalCase.getEndDate());
        } else {
            return true;
        }
    }
}
