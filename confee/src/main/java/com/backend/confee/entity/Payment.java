package com.backend.confee.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderId;
    private String status;
    private String paymentType;
    private Double amount;

    @Lob
    private String payhereResponse; // Store the full response if needed
}
