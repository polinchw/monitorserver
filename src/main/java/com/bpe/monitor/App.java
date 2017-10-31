package com.bpe.monitor;

import com.cars.framework.secrets.DockerSecretLoadException;
import com.cars.framework.secrets.DockerSecrets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class App {

    private static Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        loadDockerSecrets();
        SpringApplication.run(App.class, args);
    }

    private static void loadDockerSecrets() {
        try {
            Map<String,String> secrets = DockerSecrets.load();
            log.info("Setting DB_PASSWORD to : "+secrets.get("DB_PASSWORD"));
            System.setProperty("spring.datasource.password",secrets.get("DB_PASSWORD"));
        } catch (DockerSecretLoadException e) {
            log.warn(e.getMessage());
        }
    }
}