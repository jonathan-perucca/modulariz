package com.github.jperucca.web.controller.account;

import com.github.jperucca.component.account.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
class TestConfig {

    @Bean
    public AccountService accountService() {
        return mock(AccountService.class);
    }
}