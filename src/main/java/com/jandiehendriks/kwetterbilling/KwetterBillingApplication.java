package com.jandiehendriks.kwetterbilling;

import com.jandiehendriks.kwetterbilling.messaging.BillingUpdateSender;
import com.jandiehendriks.kwetterbilling.messaging.UserRegistrationReceiver;
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

	@Bean
	public UserRegistrationReceiver userRegistrationReceiver() {
	    return new UserRegistrationReceiver();
    }

    @Bean
    public BillingUpdateSender billingUpdateSender() {
	    return new BillingUpdateSender();
    }
}
