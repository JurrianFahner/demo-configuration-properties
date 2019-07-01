package nl.ensignprojects.configurationpropertiesvalidation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class ResolveConfigPropsService {

    private final AppConfigurationProperties appConfigurationProperties;

    @PostConstruct
    void init() {
        log.debug("The resolved properties: {}", appConfigurationProperties);
    }
}
