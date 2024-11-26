package com.backend.confee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CommitteeDTO {
    private int committee_id;
    private String committee_name;
    private String nic;
    private String email;
    private String phone;
    private String role;
    private String status;
}
