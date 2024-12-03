package com.backend.confee.controller;

import com.backend.confee.dto.PaymentDetailDTO;
import com.backend.confee.entity.PaymentDetail;
import com.backend.confee.service.AllUserDetailsService;
import com.backend.confee.service.JWTUtils;
import com.backend.confee.service.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/payments")
public class PaymentDetailController {
    @Autowired
    private PaymentDetailsService paymentDetailService;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AllUserDetailsService allUserDetailsService;

    // Endpoint to save payment detail
    @PostMapping("/save")
    public ResponseEntity<PaymentDetail> savePaymentDetail(@RequestHeader("Authorization") String authorizationHeader, @RequestBody PaymentDetailDTO paymentDetailDTO) {
        String token = authorizationHeader.substring(7);
        String userName= jwtUtils.extractUsername(token);

        Integer userId=allUserDetailsService.getUserIdByEmail(userName);
        paymentDetailDTO.setUserId(userId);
        PaymentDetail savedPaymentDetail = paymentDetailService.savePaymentDetail(paymentDetailDTO);
        return ResponseEntity.ok(savedPaymentDetail); // Return the saved payment detail
    }
}
