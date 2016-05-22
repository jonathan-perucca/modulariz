package com.github.jperucca.component.account;

import com.github.jperucca.component.account.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public User createUser(String name) {
        return accountRepository.createUser(
                User.builder().name(name).build()
        );
    }
}
