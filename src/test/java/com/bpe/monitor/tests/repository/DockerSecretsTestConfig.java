package com.bpe.monitor.tests.repository;

import com.bpe.monitor.config.DockerSecretsConfig;
import com.cars.framework.secrets.DockerSecretLoadException;
import com.cars.framework.secrets.DockerSecrets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.net.URL;
import java.util.Map;

@Configuration
public class DockerSecretsTestConfig {


    private static final Logger log = LoggerFactory.getLogger(DockerSecretsTestConfig.class);

    //File under src/main/resources/config/
    private final String DEFAULT_SECRETS_FILE = "config/secrets-file";

    // This bean will be used for 'test' profile
    @Bean("secrets")
    public Map<String, String> localSecrets() {
        log.info("Loading test secrets.");
        try {
            URL url = ClassLoader.getSystemResource(DEFAULT_SECRETS_FILE);
            if (url != null) {
                return DockerSecrets.loadFromFile(new File(url.getPath()));
            } else {
                throw new DockerSecretLoadException("Docker secrets loaded fail: ");
            }
        } catch (DockerSecretLoadException e) {
            log.warn("Secrets Load failed : " + e.getMessage(),e);
            throw new RuntimeException(e);
        }
    }
}
