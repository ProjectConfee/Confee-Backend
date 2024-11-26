package com.backend.confee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Speakers {
    @Id
    private int speaker_id;
    private String speaker_name;
    private String nic;
    private String email;
    private String phone;
}
