package com.github.jperucca.component.account;

import com.github.jperucca.component.account.model.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(String name);

    List<Account> fetchAccounts();
}
