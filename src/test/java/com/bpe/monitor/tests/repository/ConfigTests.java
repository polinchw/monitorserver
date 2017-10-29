package com.bpe.monitor.tests.repository;

import com.bpe.monitor.config.DockerSecretsConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DockerSecretsTestConfig.class})
public class ConfigTests {

    @Autowired
    @Qualifier("secrets")
    Map<String,String> secrets;

    @Test
    public void testSecrets() throws Exception {
        String password = secrets.get("JASYPT_ENCRYPTOR_PASSWORD");
        assertThat(password).isEqualTo("password");
    }
}
