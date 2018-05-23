package com.jandiehendriks.kwetterbilling.domain;

import java.util.Date;

public class Payment {
    private Long id;
    private Date creationDate;
    private double amount;

    public Payment(Date creationDate, double amount) {
        this.creationDate = creationDate;
        this.amount = amount;
    }

    public Payment() {}

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
}
