package com.jandiehendriks.kwetterbilling.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class BillingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String billingId;
    @OneToMany(mappedBy = "billingUser")
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
