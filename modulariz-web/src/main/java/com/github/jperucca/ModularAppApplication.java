package com.github.jperucca;

import com.github.jperucca.component.account.AccountService;
import com.github.jperucca.component.account.model.User;
import com.github.jperucca.component.exchange.ExchangeService;
import com.github.jperucca.component.exchange.model.Exchange;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ModularAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModularAppApplication.class, args);
	}

	@Autowired
	public AccountService accountService;

	@Autowired
	public ExchangeService exchangeService;

	@Bean
	public InitializingBean start() {
		return () -> {
			final User john = accountService.createUser("John");
			final User snow = accountService.createUser("Snow");

			Exchange exchange = exchangeService.startExchange(john.getUuid(), snow.getUuid());

			System.out.println(exchange);

			exchange = exchangeService.pushState(exchange.getUuid());

			System.out.println(exchange);
		};
	}
}
