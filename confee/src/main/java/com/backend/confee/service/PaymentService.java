package com.backend.confee.service;

import com.backend.confee.dto.PaymentRequestDTO;
import com.backend.confee.entity.Payment;
import com.backend.confee.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${payhere.merchantId}")
    private String merchantId;

    @Value("${payhere.url}")
    private String payhereUrl;

    private final PaymentRepo paymentRepository;

    public PaymentService(PaymentRepo paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public String initiatePayment(PaymentRequestDTO paymentRequestDto) {
        // Constructing the payload for the payment form
        Map<String, String> payload = new HashMap<>();
        payload.put("merchant_id", merchantId);
//        payload.put("order_id", paymentRequestDto.getOrderId());
//        payload.put("amount", String.valueOf(paymentRequestDto.getAmount()));
//        payload.put("currency", paymentRequestDto.getCurrency());
        payload.put("order_id", "1234");
        payload.put("amount", "10000.0");
        payload.put("currency", "LKR");
        payload.put("first_name", paymentRequestDto.getFirst_name());
        payload.put("last_name", paymentRequestDto.getLast_name());
        payload.put("email", paymentRequestDto.getEmail());
        payload.put("phone", paymentRequestDto.getPhone());
        payload.put("address", "Galle");  // Static value or retrieve from DTO if available
        payload.put("city", "Galle");     // Static value or retrieve from DTO if available
        payload.put("country", "Sri");  // Static value or retrieve from DTO if available
        payload.put("items", "1");  // Static or dynamic value as needed
        payload.put("return_url", paymentRequestDto.getReturn_url());
        payload.put("cancel_url", paymentRequestDto.getCancel_url());
        payload.put("notify_url", paymentRequestDto.getNotify_url());

        // You need to generate the hash for the request (this is an example of how you could generate it)

        payload.put("hash", "39D3C3F9B7E8C7F7B206D0A6E25CFE1B");

        // Create payment entity and save it to the database with status "PENDING"
        Payment payment = new Payment();
        payment.setOrderId(paymentRequestDto.getOrderId());
        payment.setAmount(paymentRequestDto.getAmount());
        payment.setStatus("PENDING");
        paymentRepository.save(payment);

        // Build the PayHere redirect URL
        StringBuilder payhereForm = new StringBuilder(payhereUrl + "?");
        payload.forEach((key, value) -> payhereForm.append(key).append("=").append(value).append("&"));

        // Return the constructed URL for the frontend to redirect to
        return payhereForm.toString();
    }
    public static String getMd5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toUpperCase();
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePaymentStatus(String orderId, String status, String response) {
        Payment payment = paymentRepository.findByOrderId(orderId);
        if (payment != null) {
            payment.setStatus(status);
            payment.setPayhereResponse(response);
            paymentRepository.save(payment);
        }
    }
}
