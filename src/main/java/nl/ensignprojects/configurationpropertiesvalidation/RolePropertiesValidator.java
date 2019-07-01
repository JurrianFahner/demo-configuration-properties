package nl.ensignprojects.configurationpropertiesvalidation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class RolePropertiesValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RoleProperties.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RoleProperties properties = (RoleProperties) target;

        if (properties.getRoles() == null) {
            errors.reject("roleProperties", "roles are not allowed to be null and should contain at least 2");
        } else if (properties.getRoles().size() < 2) {
            errors.reject("roleProperties", "the roles must contain at least 2");
        }
    }
}
