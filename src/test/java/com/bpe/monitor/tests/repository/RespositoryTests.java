package com.bpe.monitor.tests.repository;

import com.bpe.monitor.entity.Account;
import com.bpe.monitor.entity.rest.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by polinchw on 6/10/17.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RespositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void testAccountInsert() throws Exception {
        Account account = new Account();
        account.setEmail("polinchw@gmail.com");
        account.setPassword("password");
        account.setFirstName("William");
        account.setLastName("Polinchak");
        entityManager.persist(account);
        Account accountFound = this.accountRepository.findByLastName("Polinchak");
        assertThat(accountFound.getLastName()).isEqualTo("Polinchak");
    }

}
