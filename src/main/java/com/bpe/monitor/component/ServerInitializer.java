package com.bpe.monitor.component;

import com.bpe.monitor.config.DockerSecretsConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ServerInitializer implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(ServerInitializer.class);

    @Autowired
    @Qualifier("secrets")
    Map<String, String> secrets;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        log.info("Setting spring.datasource.password to : "+secrets.get("JASYPT_ENCRYPTOR_PASSWORD"));
        System.setProperty("spring.datasource.password",secrets.get("JASYPT_ENCRYPTOR_PASSWORD"));

    }
}
