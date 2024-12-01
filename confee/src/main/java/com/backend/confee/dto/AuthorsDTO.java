package com.backend.confee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class AuthorsDTO {
    private int author_id;
    private String author_name;
    private String nic;
    private String email;
    private String phone;
    private String code;
    private String topic;
    private String status;
}
