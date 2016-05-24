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

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
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
    UUID uuidFirst = UUID.randomUUID();
    UUID uuidSecond = UUID.randomUUID();

    @Test
    public void should_fetch_accounts() {
        List<Account> accounts = Arrays.asList(
                Account.builder().uuid(uuidFirst).name("first").build(),
                Account.builder().uuid(uuidSecond).name("second").build()
        );
        when(accountService.fetchAccounts()).thenReturn(accounts);

        get("/accounts").then().log().all().statusCode(200).body("$", hasSize(2));
    }
}