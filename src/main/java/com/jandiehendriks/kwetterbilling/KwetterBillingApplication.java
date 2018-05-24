package com.jandiehendriks.kwetterbilling;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KwetterBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(KwetterBillingApplication.class, args);
	}

	@Bean
	public Queue registrationQueue() {
		return new Queue("NEW_REGISTRATION_QUEUE");
	}

	@Bean
	public Queue billingUpdateQueue() {
		return new Queue("BILLING_USER_UPDATE");
	}
}
