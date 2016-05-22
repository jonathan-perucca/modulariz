package com.github.jperucca.component.account;

import com.github.jperucca.component.account.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
class AccountRepositoryImpl implements AccountRepository {

    private List<Account> accounts = new ArrayList<>();

    @Override
    public Account createUser(Account account) {
        account.setUuid(UUID.randomUUID());
        accounts.add(account);
        return account;
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(accounts);
    }

    @Override
    public Optional<Account> findOne(UUID accountUuid) {
        return accounts
                .stream()
                .filter(account -> accountUuid.equals(account.getUuid()))
                .findFirst();
    }
}
