package nl.ensignprojects.configurationpropertiesvalidation.server;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ServerPropertiesValidator implements ConstraintValidator<ValidServer, ServerProperties> {

    @Override
    public boolean isValid(ServerProperties properties, ConstraintValidatorContext context) {
        Integer port = properties.getPort();
        String proto = properties.getProto();
        if (port == null && !"http".equals(proto)) {
            context.buildConstraintViolationWithTemplate("Only when proto is http, the port may be unspecified")
                    .addConstraintViolation();
            return false;
        }
        else if (port == 443 && !"https".equals(proto)) {
            context.buildConstraintViolationWithTemplate("When port equals 443, proto must be https")
                    .addConstraintViolation();
            return false;
        }
        else if (port == 80 && !"http".equals(proto)) {
            context.buildConstraintViolationWithTemplate("When port equals 80, proto must be http")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
