package com.jandiehendriks.kwetterbilling.repository;

import com.jandiehendriks.kwetterbilling.domain.BillingUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingUserRepository extends JpaRepository<BillingUser, Long> {
    BillingUser findByBillingId(String billingId);
}
