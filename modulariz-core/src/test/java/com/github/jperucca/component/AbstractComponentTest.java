package com.github.jperucca.component;

import com.github.jperucca.component.account.AccountService;
import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class AbstractComponentTest {

    protected static AnnotationConfigApplicationContext context;

    @BeforeClass
    public static void loadApplicationContext() {
        context = new AnnotationConfigApplicationContext();
        context.scan(AbstractComponentTest.class.getPackage().getName());

        context.refresh();
    }

    protected AccountService getAccountComponent() {
        return context.getBean(AccountService.class);
    }
}
