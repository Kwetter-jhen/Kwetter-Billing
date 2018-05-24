package com.jandiehendriks.kwetterbilling.messaging;

import com.jandiehendriks.kwetterbilling.dto.UserDto;
import com.jandiehendriks.kwetterbilling.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BillingUpdateSender {
    private static final Logger log =
            LoggerFactory.getLogger(BillingUpdateSender.class);

    @Autowired
    private RabbitTemplate template;

    private JsonUtil jsonUtil = new JsonUtil();

    void send(UserDto userDto) {
        this.template.convertAndSend(
                "BILLING_USER_UPDATE",
                jsonUtil.encode(userDto));

        log.info("Billing update sent!");
    }
}
