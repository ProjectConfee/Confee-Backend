package com.backend.confee.service;

import com.backend.confee.dto.PaymentRequestDTO;
import com.backend.confee.entity.Payment;
import com.backend.confee.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    private final String merchantId = "1225745";
    private final String merchantSecret = "MTI5NTAzNzQyOTI0NDczMzQzNzAyNjc2NjQ1NTIzMzg3MzkyNDM5MQ==";

    public String generateHash(String orderId, double amount, String currency) {
        try {
            DecimalFormat df = new DecimalFormat("0.00");
            String amountFormatted = df.format(amount);
            String input = merchantId + orderId + amountFormatted + currency + getMd5(merchantSecret);
            return getMd5(input);
        } catch (Exception e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }

    private String getMd5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext.toUpperCase();
    }
}
