package com.backend.confee.controller;

import com.backend.confee.dto.PaymentRequestDTO;
import com.backend.confee.dto.ResponseDTO;
import com.backend.confee.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/payments")
@CrossOrigin
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/initiate")
    public PaymentRequestDTO initiatePayment(@RequestBody PaymentRequestDTO paymentRequest) {
        String hash = paymentService.generateHash(paymentRequest.getOrderId(), paymentRequest.getAmount(), paymentRequest.getCurrency());
        paymentRequest.setHash(hash);
        return paymentRequest;
    }
}
