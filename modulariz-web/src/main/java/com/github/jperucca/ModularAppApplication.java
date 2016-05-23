package com.github.jperucca;

import com.github.jperucca.component.account.AccountService;
import com.github.jperucca.component.account.model.Account;
import com.github.jperucca.component.exchange.ExchangeService;
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
			final Account john = accountService.createAccount("John Snow");
			final Account mark = accountService.createAccount("Mark so");

			exchangeService.startExchange(john.getUuid(), mark.getUuid());
		};
	}
}
