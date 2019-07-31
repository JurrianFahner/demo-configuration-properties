package nl.ensignprojects.configurationpropertiesvalidation.role;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class RolePropertiesValidator implements ConstraintValidator<ValidRole, RoleProperties> {

    @Override
    public boolean isValid(RoleProperties properties, ConstraintValidatorContext context) {
        if (properties.getRoles() == null) {
            log.debug("roles are not allowed to be null and should contain at least 2");
            context.buildConstraintViolationWithTemplate("Roles not allowed to be null").addConstraintViolation();
            return false;
        } else if (properties.getRoles().size() < 2) {
            context.buildConstraintViolationWithTemplate("Roles must contain at least 2").addConstraintViolation();
            log.debug("the roles must contain at least 2");
            return false;
        }
        return true;
    }
}
