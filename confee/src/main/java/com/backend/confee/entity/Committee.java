package com.backend.confee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Committee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int committee_id;
    private String committee_name;
    private String nic;
    private String email;
    private String phone;
    private String role;
    private String status;
}
