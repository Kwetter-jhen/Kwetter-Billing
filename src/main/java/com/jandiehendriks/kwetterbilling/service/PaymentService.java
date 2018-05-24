package com.jandiehendriks.kwetterbilling.service;

import com.jandiehendriks.kwetterbilling.domain.BillingUser;
import com.jandiehendriks.kwetterbilling.domain.Payment;
import com.jandiehendriks.kwetterbilling.repository.BillingUserRepository;
import com.jandiehendriks.kwetterbilling.repository.PaymentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentService {
    private static final Logger log =
            LoggerFactory.getLogger(PaymentService.class);

    private PaymentRepository paymentRepository;
    private BillingUserRepository billingUserRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository,
                          BillingUserRepository billingUserRepository) {
        this.paymentRepository = paymentRepository;
        this.billingUserRepository = billingUserRepository;
    }

    public Payment addPayment(String billingId, double amount) {
        BillingUser user = billingUserRepository.findByBillingId(billingId);

        Payment payment =
                new Payment(
                        new Date(),
                        amount,
                        user);

        paymentRepository.save(payment);
        billingUserRepository.save(user);

        return payment;
    }
}
