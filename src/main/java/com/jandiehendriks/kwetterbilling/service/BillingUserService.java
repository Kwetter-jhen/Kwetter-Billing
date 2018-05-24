package com.jandiehendriks.kwetterbilling.service;

import com.jandiehendriks.kwetterbilling.domain.BillingUser;
import com.jandiehendriks.kwetterbilling.repository.BillingUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingUserService {
    private static final Logger log =
            LoggerFactory.getLogger(BillingUserService.class);

    private final BillingUserRepository billingUserRepository;

    @Autowired
    public BillingUserService(BillingUserRepository billingUserRepository) {
        this.billingUserRepository = billingUserRepository;
    }

    public BillingUser register(String username) {
        BillingUser user = new BillingUser(username);

        return billingUserRepository.save(user);
    }
}
