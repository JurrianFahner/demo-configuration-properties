# Extra validators in configurationproperties

When working with spring-boot 2.1.x I discovered that the validation is little bit limited as with spring-boot 1.5.x.
This is due to the fact that for spring-boot 2.x.x the whole binder implementation is rewritten.

Sometimes you want to be able to configure more validators on one configuration property; you might want to reuse some 
of your validators and not implement the Validator interface on each of your configuration properties. 

This project shows the benefits when we expand the [ConfigurationProperties][1] annotation, to a new definition, where 
multiple Validators can be implemented.  

An example implementation can be found [here][3].

## demos in this repo

Each demo has a specific configuration. The configuration for each profile can be found in the 
[application.yml](./application.yml).

```bash
# All properties are checked and each are valid
SPRING_PROFILES_ACTIVE=allPropertiesOk mvn spring-boot:run

# No configuration is given, also RoleProperties and ServerProperties give a validation error
SPRING_PROFILES_ACTIVE=noArgsDefined mvn spring-boot:run

# All configuration ok for RoleProperties, but not for ServerProperties
SPRING_PROFILES_ACTIVE=onlyRolePropertiesOk mvn spring-boot:run

# All configuration ok for ServerProperties, but not for RoleProperties
SPRING_PROFILES_ACTIVE=onlyServerPropertiesOk mvn spring-boot:run
```


[1]: https://github.com/spring-projects/spring-boot/blob/2.1.x/spring-boot-project/spring-boot/src/main/java/org/springframework/boot/context/properties/ConfigurationProperties.java
[3]: ./src/main/java/nl/ensignprojects/configurationpropertiesvalidation/AppConfigurationProperties.java
