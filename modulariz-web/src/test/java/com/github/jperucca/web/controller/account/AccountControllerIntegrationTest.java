package com.github.jperucca.web.controller.account;

import com.github.jperucca.component.account.AccountService;
import com.github.jperucca.component.account.model.Account;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.jayway.restassured.RestAssured.get;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;


// TODO : remove mock service when app will be stateless
// IntegrationTest on API should be seen as blackbox test
public class AccountControllerIntegrationTest extends AccountSpecs{

    @Autowired
    AccountService accountService;

    @Test
    public void should_fetch_accounts() {
        Account first = Account.builder().uuid(uuidFirst).build();
        Account second = Account.builder().uuid(uuidSecond).build();
        when(accountService.fetchAccounts()).thenReturn(asList(first, second));

        get("/accounts").then().statusCode(200).spec(accountArraySpec);
    }
}