package com.github.jperucca.web.controller.exchange;

import com.github.jperucca.component.exchange.ExchangeService;

import static org.mockito.Mockito.mock;

class TestConfig {

    public ExchangeService exchangeService() {
        return mock(ExchangeService.class);
    }
}