package nl.ensignprojects.configurationpropertiesvalidation;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "demo-app", validators = {RolePropertiesValidator.class, ServerPropertiesValidator.class})
public class AppConfigurationProperties implements ServerProperties, RoleProperties {

    private String proto;
    private String host;
    private Integer port;

    private List<String> roles;

}
