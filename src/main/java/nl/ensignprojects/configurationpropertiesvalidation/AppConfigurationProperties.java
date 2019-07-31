package nl.ensignprojects.configurationpropertiesvalidation;

import lombok.Data;
import nl.ensignprojects.configurationpropertiesvalidation.role.RoleProperties;
import nl.ensignprojects.configurationpropertiesvalidation.role.ValidRole;
import nl.ensignprojects.configurationpropertiesvalidation.server.ServerProperties;
import nl.ensignprojects.configurationpropertiesvalidation.server.ValidServer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Component
@Validated
@ValidRole
@ValidServer
@ConfigurationProperties(prefix="demo-app")
public class AppConfigurationProperties implements ServerProperties, RoleProperties {

    private String proto;
    private String host;
    private Integer port;

    private List<String> roles;

}
