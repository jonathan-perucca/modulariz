package com.github.jperucca.component.account;

import com.github.jperucca.component.account.model.User;

interface AccountRepository {

    User createUser(User user);
}
