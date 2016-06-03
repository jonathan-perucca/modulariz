package com.github.jperucca.component.exchange;

import com.github.jperucca.component.exchange.model.Exchange;

import java.util.List;
import java.util.UUID;

public interface ExchangeService {

    Exchange startExchange(UUID owner, UUID receiver);

    Exchange pushState(UUID exchangeUuid);

    List<Exchange> fetchExchanges();
}
