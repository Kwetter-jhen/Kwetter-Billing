package com.jandiehendriks.kwetterbilling.controller;

import com.jandiehendriks.kwetterbilling.domain.Payment;
import com.jandiehendriks.kwetterbilling.dto.PaymentDto;
import com.jandiehendriks.kwetterbilling.service.BillingUserService;
import com.jandiehendriks.kwetterbilling.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {
    private static final Logger log =
            LoggerFactory.getLogger(PaymentController.class);

    private BillingUserService billingUserService;
    private PaymentService paymentService;


    @Autowired
    public PaymentController(BillingUserService billingUserService,
                             PaymentService paymentService) {
        this.billingUserService = billingUserService;
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/payments",
            method = RequestMethod.GET)
    public ResponseEntity getPaymentsByBillingId(
            @RequestParam String billingId) {
        List<Payment> payments =
                billingUserService.getByBillingId(billingId).getPayments();

        return new ResponseEntity<>(
                payments,
                HttpStatus.OK);
    }

    @RequestMapping(value = "/payments",
            method = RequestMethod.POST)
    public ResponseEntity addPayment(
            @RequestBody PaymentDto paymentDto) {
        Payment payment =
                paymentService.addPayment(
                        paymentDto.getBillingId(),
                        paymentDto.getAmount());

        return new ResponseEntity<>(payment, HttpStatus.OK);
    }
}
