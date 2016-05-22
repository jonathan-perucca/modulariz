package com.github.jperucca.component.account;

import com.github.jperucca.component.account.model.Account;

import java.util.List;

interface AccountRepository {

    Account createUser(Account account);

    List<Account> findAll();
}
