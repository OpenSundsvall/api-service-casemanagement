package se.sundsvall.validators;

import se.sundsvall.util.Constants;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TodayOrFutureValidator.class)
public @interface TodayOrFuture {

    String message() default Constants.ERR_THIS_DATE_MUST_BE_TODAY_OR_FUTURE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}