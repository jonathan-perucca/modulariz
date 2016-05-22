package com.github.jperucca.component.account;

import com.github.jperucca.component.account.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(String name) {
        return accountRepository.createUser(
                Account.builder().name(name).build()
        );
    }

    @Override
    public List<Account> fetchAccounts() {
        return accountRepository.findAll();
    }
}
