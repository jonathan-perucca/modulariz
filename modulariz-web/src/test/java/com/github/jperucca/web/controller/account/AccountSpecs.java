package com.github.jperucca.web.controller.account;

import com.github.jperucca.web.controller.ApiTest;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.ResponseSpecification;
import org.junit.Before;

import java.util.UUID;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public abstract class AccountSpecs extends ApiTest {

    protected ResponseSpecification accountArraySpec;
    protected UUID uuidFirst;
    protected UUID uuidSecond;

    @Before
    public void prepare_dto_specifications() {
        uuidFirst = UUID.randomUUID();
        uuidSecond = UUID.randomUUID();
        accountArraySpec = new ResponseSpecBuilder()
                .expectBody("$", hasSize(2))
                .expectBody("[0]", notNullValue())
                .expectBody("[1]", notNullValue())
                .expectBody("[0].uuid", is(uuidFirst.toString()))
                .expectBody("[1].uuid", is(uuidSecond.toString()))
                .build();
    }

}
