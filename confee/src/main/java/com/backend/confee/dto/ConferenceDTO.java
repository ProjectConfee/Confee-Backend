package com.backend.confee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ConferenceDTO {
    private int id;
    private Date startDate;
    private Date endDate;
    private String logo;
    private String coverPhoto;
    private String location;
}
