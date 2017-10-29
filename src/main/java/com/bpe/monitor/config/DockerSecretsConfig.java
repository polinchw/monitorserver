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

    // This bean will be used in non-local or no profiles
    @Bean("secrets")
    public Map<String, String> secrets() {
        log.info("Loading secrets.");
        try {
            Map<String,String> map = DockerSecrets.load();
            return map;
        } catch (DockerSecretLoadException e) {
            log.warn("Secrets Load failed : " + e.getMessage(),e);
            throw new RuntimeException(e);
        }

    }



//    @PostConstruct
//    public void init() {
//        log.info("JASYPT_ENCRYPTOR_PASSWORD: "+secrets().get("JASYPT_ENCRYPTOR_PASSWORD"));
//        System.setProperty("JASYPT_ENCRYPTOR_PASSWORD",secrets().get("JASYPT_ENCRYPTOR_PASSWORD"));
//    }

}
