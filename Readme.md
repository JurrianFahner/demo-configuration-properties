# Extra validators in configurationproperties

When working with spring-boot 2.1.x I discovered that the validation is little bit limited as with spring-boot 1.5.x.
This is due to the fact that for spring-boot 2.x.x the whole binder implementation is rewritten.

The current implementation doesn't allow to have more than one validator implemented. 
In case you might want to have that functionality, the spring-boot team implemented JSR303 for that purpose. 

This project demonstrates the possibilities by using JSR303 to apply multiple validators on one configuration properties bean.

The example contains a [configuration properties bean][3];

## demo in this repo
You can run the demo by:
```shell script
mvn clean spring-boot:run
```

When nothing is configured you'll get the following output:
```
***************************
APPLICATION FAILED TO START
***************************

Description:

Binding to target org.springframework.boot.context.properties.bind.BindException: Failed to bind properties under 'demo-app' to nl.ensignprojects.configurationpropertiesvalidation.AppConfigurationProperties failed:

    Reason: ServerProperties not valid

    Reason: Role is not valid

    Reason: Only when proto is http, the port may be unspecified

    Reason: Roles must contain at least 2


Action:

Update your application's configuration


```

[3]: ./src/main/java/nl/ensignprojects/configurationpropertiesvalidation/AppConfigurationProperties.java
