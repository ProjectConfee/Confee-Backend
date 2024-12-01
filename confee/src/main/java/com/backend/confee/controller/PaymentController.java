package com.backend.confee.controller;

import com.backend.confee.dto.PaymentRequestDTO;
import com.backend.confee.dto.ResponseDTO;
import com.backend.confee.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/payments")
@CrossOrigin
@RequiredArgsConstructor()
public class PaymentController {

    private final PaymentService paymentService;
    private ResponseDTO responseDTO;

    @PostMapping("/initiate")
    public ResponseEntity<Map<String, String>> initiatePayment(@RequestBody PaymentRequestDTO paymentRequestDto) {
//        System.out.println("Received payment request: {}"+ paymentRequestDto);
//        return ResponseEntity.ok(paymentService.initiatePayment(paymentRequestDto));
        String redirectUrl = paymentService.initiatePayment(paymentRequestDto);

        // Return the redirect URL in a Map as a JSON response
        return ResponseEntity.ok(Map.of("redirectUrl", redirectUrl));
    }

    @PostMapping("/notify")
    public ResponseEntity<String> paymentNotification(@RequestParam String order_id,
                                                      @RequestParam String status_code,
                                                      @RequestParam String status_message) {
        paymentService.updatePaymentStatus(order_id, status_code, status_message);
        return ResponseEntity.ok("Payment status updated");
    }
}
