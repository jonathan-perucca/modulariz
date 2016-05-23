package com.github.jperucca.web.controller.exchange;

import com.github.jperucca.component.exchange.ExchangeService;
import com.github.jperucca.component.exchange.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/exchanges")
@CrossOrigin
public class ExchangeController {

    private final ExchangeService exchangeService;
    private final ExchangeAdapter exchangeAdapter;

    @Autowired
    public ExchangeController(ExchangeService exchangeService,
                              ExchangeAdapter exchangeAdapter) {
        this.exchangeService = exchangeService;
        this.exchangeAdapter = exchangeAdapter;
    }

    @RequestMapping(method = GET)
    public List<ExchangeDTO> fetchExchanges() {

        return exchangeService
                .fetchExchanges()
                .stream()
                .map(exchangeAdapter::apply)
                .collect(toList());
    }

    @RequestMapping(method = POST)
    public ExchangeDTO pushState(@RequestBody ExchangeDTO exchangeDTO) {
        Exchange exchange = exchangeService.pushState(exchangeDTO.getUuid());

        return exchangeAdapter.apply(exchange);
    }
}
