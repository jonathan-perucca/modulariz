package com.github.jperucca.component.exchange;

import com.github.jperucca.component.exchange.model.Exchange;

import java.util.Optional;
import java.util.UUID;

interface ExchangeRepository {

    Exchange save(Exchange exchange);

    Optional<Exchange> find(UUID exchangeUuid);
}
