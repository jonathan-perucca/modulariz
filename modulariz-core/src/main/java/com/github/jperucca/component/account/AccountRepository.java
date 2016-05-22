package com.github.jperucca.component.account;

import com.github.jperucca.component.account.model.Account;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

interface AccountRepository {

    Account createUser(Account account);

    List<Account> findAll();

    Optional<Account> findOne(UUID accountUuid);
}
