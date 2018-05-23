package com.jandiehendriks.kwetterbilling.domain;

import java.util.List;

public class BillingUser {
    private Long id;
    private String username;
    private String billingId;
    private List<Payment> payments;

    public BillingUser(String username, String billingId, List<Payment> payments) {
        this.username = username;
        this.billingId = billingId;
        this.payments = payments;
    }

    public BillingUser() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
