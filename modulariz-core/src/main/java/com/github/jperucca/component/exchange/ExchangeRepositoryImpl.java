package com.github.jperucca.component.exchange;

import com.github.jperucca.component.exchange.model.Exchange;
import org.springframework.stereotype.Repository;

import java.util.*;

import static java.util.stream.Collectors.toList;

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
        return exchanges.entrySet().stream()
                .filter(exchangeEntry -> exchangeUuid.equals(exchangeEntry.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();
    }

    @Override
    public List<Exchange> findAll() {
        return exchanges.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(toList());
    }
}
