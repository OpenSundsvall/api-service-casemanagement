package se.sundsvall.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class TodayOrFutureValidator implements ConstraintValidator<TodayOrFuture, LocalDate> {

    @Override
    public boolean isValid(LocalDate date, ConstraintValidatorContext context) {

        return date == null || !date.isBefore(LocalDate.now());
    }
}
