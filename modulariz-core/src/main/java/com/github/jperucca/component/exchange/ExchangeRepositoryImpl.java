package com.github.jperucca.component.exchange;

import com.github.jperucca.component.exchange.model.Exchange;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
class ExchangeRepositoryImpl implements ExchangeRepository {

    private Map<UUID, Exchange> exchanges = new HashMap<>();

    @Override
    public Exchange save(Exchange exchange) {
        if (exchange.getUuid() == null) {
            exchange.setUuid(UUID.randomUUID());
        }

        exchanges.put(exchange.getUuid(), exchange);

        return exchange;
    }

    @Override
    public Optional<Exchange> find(UUID exchangeUuid) {
        final Exchange exchange = exchanges.get(exchangeUuid);

        return Optional.ofNullable(exchange);
    }
}
