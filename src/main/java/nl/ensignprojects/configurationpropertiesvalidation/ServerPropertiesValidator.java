package nl.ensignprojects.configurationpropertiesvalidation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ServerPropertiesValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ServerProperties.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServerProperties properties = (ServerProperties) target;

        if (properties.getHost() == null) {
            errors.reject("server-properties", "Host value should not be null");
        }
        if (properties.getProto() == null) {
            errors.reject("server-properties", "Proto value should not be null");
            return;
        }

        validate(errors, properties.getPort(), properties.getProto());
    }

    private void validate(Errors errors, Integer port, String proto) {
        if (port == null && !port.equals("http")) {
            errors.reject("server-properties", "Only when proto is http, the port may be unspecified");
        }
        else if (port == 443 && !"https".equals(proto)) {
            errors.reject("server-properties", "When port equals 443, proto must be https");
        }
        else if (port == 80 && !"http".equals(proto)) {
            errors.reject("server-properties", "When port equals 80, proto must be http");
        }
    }
}
