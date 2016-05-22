package com.github.jperucca.web.controller.exchange;

import com.github.jperucca.component.account.model.Account;
import com.github.jperucca.component.exchange.model.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
class ExchangeDTO {
    private UUID uuid;
    private State state;
    private Account owner;
    private Account receiver;
}