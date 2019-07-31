package nl.ensignprojects.configurationpropertiesvalidation.server;

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
@Constraint(validatedBy = { ServerPropertiesValidator.class })
public @interface ValidServer {
    String message() default "ServerProperties not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
