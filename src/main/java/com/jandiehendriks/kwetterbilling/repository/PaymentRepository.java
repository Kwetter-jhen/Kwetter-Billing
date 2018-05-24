package com.jandiehendriks.kwetterbilling.repository;

import com.jandiehendriks.kwetterbilling.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
