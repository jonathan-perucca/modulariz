package com.github.jperucca.component.account;

import com.github.jperucca.component.account.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
class AccountRepositoryImpl implements AccountRepository {

    private List<User> users = new ArrayList<>();

    @Override
    public User createUser(User user) {
        user.setUuid(UUID.randomUUID());
        users.add(user);
        return user;
    }
}
