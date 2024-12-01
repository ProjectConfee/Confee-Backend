package com.backend.confee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class SpeakersDTO {
    private int speaker_id;
    private String speaker_name;
    private String nic;
    private String email;
    private String phone;
    private String status;
}
