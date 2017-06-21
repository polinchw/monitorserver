package com.bpe.monitor.entity.rest.repository;

import com.bpe.monitor.entity.Account;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.*;

/**
 * Created by polinchw on 6/4/17.
 */
@RepositoryRestResource(collectionResourceRel = "account", path = "account")
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

    Account findByLastName(@Param("lastName") String lastName);

    Account findByEmail(@Param("email") String email);
}
