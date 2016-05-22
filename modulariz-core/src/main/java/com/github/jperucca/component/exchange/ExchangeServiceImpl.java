package com.github.jperucca.component.exchange;

import com.github.jperucca.component.exchange.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static com.github.jperucca.component.exchange.model.State.PENDING;

@Service
class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRepository exchangeRepository;

    @Autowired
    ExchangeServiceImpl(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public Exchange startExchange(UUID owner, UUID receiver) {
        final Exchange exchange = Exchange.builder()
        .state(PENDING).owner(owner).receiver(receiver).build();

        return exchangeRepository.save(exchange);
    }

    @Override
    public Exchange pushState(UUID exchangeUuid) {
        final Optional<Exchange> exchange = exchangeRepository.find(exchangeUuid);

        exchange.ifPresent(Exchange::pushState);

        exchangeRepository.save(exchange.get());

        return exchange.get();
    }
}
