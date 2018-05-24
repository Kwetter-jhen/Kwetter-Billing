package com.jandiehendriks.kwetterbilling.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;
    private double amount;
    @JsonIgnore
    @ManyToOne
    private BillingUser billingUser;

    public Payment(Date creationDate, double amount, BillingUser billingUser) {
        this.creationDate = creationDate;
        this.amount = amount;
        this.billingUser = billingUser;

        this.billingUser.getPayments().add(this);
    }

    public Payment() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BillingUser getBillingUser() {
        return billingUser;
    }

    public void setBillingUser(BillingUser billingUser) {
        this.billingUser = billingUser;
    }
}
