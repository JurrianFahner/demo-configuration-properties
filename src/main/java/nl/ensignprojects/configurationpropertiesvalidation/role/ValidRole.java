package nl.ensignprojects.configurationpropertiesvalidation.role;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = { RolePropertiesValidator.class })
public @interface ValidRole {

    String message() default "Role is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
