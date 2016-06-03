package com.github.jperucca.web.controller;

import com.github.jperucca.ModularAppApplication;
import com.github.jperucca.component.account.AccountService;
import com.github.jperucca.component.exchange.ExchangeService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.mock;

@ActiveProfiles("integration")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ModularAppApplication.class)
@WebIntegrationTest
public abstract class ApiTest {

    @Bean
    public ExchangeService exchangeService() {
        return mock(ExchangeService.class);
    }

    @Bean
    public AccountService accountService() {
        return mock(AccountService.class);
    }
}
