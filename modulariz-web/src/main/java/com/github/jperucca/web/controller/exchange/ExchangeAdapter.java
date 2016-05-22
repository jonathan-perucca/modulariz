package com.github.jperucca.web.controller.exchange;

import com.github.jperucca.component.account.AccountService;
import com.github.jperucca.component.exchange.model.Exchange;
import com.github.jperucca.web.controller.DTOAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ExchangeAdapter implements DTOAdapter<Exchange, ExchangeDTO> {

    private final AccountService accountService;

    @Autowired
    ExchangeAdapter(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ExchangeDTO apply(Exchange exchange) {
        return ExchangeDTO.builder()
                .uuid(exchange.getUuid())
                .owner(accountService.getAccount(exchange.getOwner()))
                .receiver(accountService.getAccount(exchange.getReceiver()))
                .state(exchange.getState())
                .build();
    }
}