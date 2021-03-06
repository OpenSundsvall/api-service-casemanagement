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
@Constraint(validatedBy = EnvironmentStakeholderRoleConstraintValidator.class)
public @interface EnvironmentStakeholderRole {

    String message() default Constants.ERR_MSG_WRONG_ROLE_ENV_CASE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}