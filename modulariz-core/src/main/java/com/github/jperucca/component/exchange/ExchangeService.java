package com.github.jperucca.component.exchange;

import com.github.jperucca.component.exchange.model.Exchange;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ExchangeService {

    Exchange startExchange(UUID owner, UUID receiver);

    Exchange pushState(UUID exchangeUuid);

    List<Exchange> fetchExchanges();
}
