package com.github.jperucca.web.controller.exchange;

import com.github.jperucca.component.exchange.ExchangeService;
import com.github.jperucca.component.exchange.model.Exchange;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.jayway.restassured.RestAssured.get;
import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

// TODO : remove mock service when app will be stateless
// IntegrationTest on API should be seen as blackbox test
public class ExchangeControllerIntegrationTest extends ExchangeSpecs {

    @Autowired
    ExchangeService exchangeService;

    @Test
    public void should_fetch_exchanges() {
        Exchange first = Exchange.builder().uuid(uuidFirst).build();
        Exchange second = Exchange.builder().uuid(uuidSecond).build();
        when(exchangeService.fetchExchanges()).thenReturn(asList(first, second));

        get("/exchanges").then().statusCode(200).spec(exchangeArraySpec);
    }

    @Test
    public void testPushState() {

    }
}