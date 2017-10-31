package com.bpe.monitor.config;

import com.cars.framework.secrets.DockerSecretLoadException;
import com.cars.framework.secrets.DockerSecrets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.Map;

/**
 * Loads the docker secrets into a map.
 */
@Configuration
public class DockerSecretsConfig {

    private static final Logger log = LoggerFactory.getLogger(DockerSecretsConfig.class);

    @Bean("secrets")
    public Map<String, String> secrets() {
        log.info("Loading secrets.");
        try {
            Map<String,String> secrets = DockerSecrets.load();
            log.info("Setting DB_PASSWORD to : "+secrets.get("DB_PASSWORD"));
            System.setProperty("spring.datasource.password",secrets.get("DB_PASSWORD"));
            return secrets;
        } catch (DockerSecretLoadException e) {
            log.warn("Secrets Load failed : " + e.getMessage(),e);
            throw new RuntimeException(e);
        }

    }

}
