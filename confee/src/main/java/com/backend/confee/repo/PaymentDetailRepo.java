package com.backend.confee.repo;

import com.backend.confee.entity.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailRepo extends JpaRepository<PaymentDetail, Long> {
}
