package com.jandiehendriks.kwetterbilling.messaging;

import com.jandiehendriks.kwetterbilling.domain.BillingUser;
import com.jandiehendriks.kwetterbilling.dto.UserDto;
import com.jandiehendriks.kwetterbilling.service.BillingUserService;
import com.jandiehendriks.kwetterbilling.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

@RabbitListener(queues = "NEW_REGISTRATION_QUEUE")
public class UserRegistrationReceiver {
    private static final Logger log =
            LoggerFactory.getLogger(UserRegistrationReceiver.class);
    private JsonUtil jsonUtil = new JsonUtil();

    @Autowired
    private BillingUserService billingUserService;

    @Autowired
    private BillingUpdateSender billingUpdateSender;

    @RabbitHandler
    public void receive(String message) {
        UserDto userDto = jsonUtil.decode(message, UserDto.class);
        log.info("Received message: " + message);

        BillingUser billingUser =
                billingUserService.register(userDto.getUsername());

        userDto.setBillingId(billingUser.getBillingId());

        billingUpdateSender.send(userDto);
    }
}
