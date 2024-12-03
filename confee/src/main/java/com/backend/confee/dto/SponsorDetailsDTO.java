package com.backend.confee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class SponsorDetailsDTO {
    private int sponsor_id;
    private String company_name;
    private String email;
    private String phone;
    private String level;
}
