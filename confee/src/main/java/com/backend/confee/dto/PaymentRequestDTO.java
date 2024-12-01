package com.backend.confee.dto;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private String orderId;
    private double amount;
    private String currency;
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String items;
    private String return_url;
    private String cancel_url;
    private String notify_url;
}
