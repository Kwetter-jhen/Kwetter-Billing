package com.jandiehendriks.kwetterbilling.dto;

public class PaymentDto {
    private String billingId;
    private double amount;

    public PaymentDto() {}

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
