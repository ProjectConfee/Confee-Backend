package com.backend.confee.repo;


import com.backend.confee.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Long> {
    Payment findByOrderId(String orderId);
}