package com.github.jperucca.web.controller.account;

import com.github.jperucca.ModularAppApplication;
import com.github.jperucca.component.account.AccountService;
import com.github.jperucca.component.account.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static com.jayway.restassured.RestAssured.get;
import static java.util.Arrays.asList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.when;

@ActiveProfiles("integration")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        ModularAppApplication.class,
        TestConfig.class
})
@WebIntegrationTest
public class AccountControllerTest {

    @Autowired
    AccountService accountService;

    @Test
    public void should_fetch_accounts() {
        Account first = Account.builder().uuid(UUID.randomUUID()).name("first").build();
        Account second = Account.builder().uuid(UUID.randomUUID()).name("second").build();
        when(accountService.fetchAccounts()).thenReturn(asList(first, second));

        get("/accounts")
            .then().statusCode(200)
            .body("$", hasSize(2))
            .body("[0]", notNullValue())
            .body("[0].uuid", is(first.getUuid().toString()))
            .body("[0].name", is(first.getName()))
            .body("[1]", notNullValue())
            .body("[1].uuid", is(second.getUuid().toString()))
            .body("[1].name", is(second.getName()));
    }
}