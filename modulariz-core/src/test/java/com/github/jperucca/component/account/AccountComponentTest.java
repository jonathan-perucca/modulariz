package com.github.jperucca.component.account;

import com.github.jperucca.component.AbstractComponentTest;
import com.github.jperucca.component.account.model.Account;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountComponentTest extends AbstractComponentTest{

    @Test
    public void should_create_account() {
        AccountService accountService = getAccountComponent();

        Account firstAccount = accountService.createAccount("first account");

        assertThat(firstAccount)
            .isNotNull()
            .hasFieldOrPropertyWithValue("name", "first account")
        .extracting(Account::getUuid)
            .isNotNull();
    }
}
