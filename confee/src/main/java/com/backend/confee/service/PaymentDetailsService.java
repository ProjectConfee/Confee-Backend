package com.backend.confee.service;

import com.backend.confee.dto.PaymentDetailDTO;
import com.backend.confee.entity.PaymentDetail;
import com.backend.confee.repo.PaymentDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentDetailsService {
    @Autowired
    private PaymentDetailRepo paymentDetailRepository;

    // Method to save payment detail
    public PaymentDetail savePaymentDetail(PaymentDetailDTO paymentDetailDTO) {
        PaymentDetail paymentDetail = mapToEntity(paymentDetailDTO);
        return paymentDetailRepository.save(paymentDetail);
    }

    // Helper method to map DTO to Entity
    private PaymentDetail mapToEntity(PaymentDetailDTO paymentDetailDTO) {
        PaymentDetail paymentDetail = new PaymentDetail();
        paymentDetail.setWorkshopId(paymentDetailDTO.getWorkshopId());
        paymentDetail.setOrderId(paymentDetailDTO.getOrderId());
        paymentDetail.setUserId(paymentDetailDTO.getUserId());
        paymentDetail.setAmount(paymentDetailDTO.getAmount());
        return paymentDetail;
    }
}
