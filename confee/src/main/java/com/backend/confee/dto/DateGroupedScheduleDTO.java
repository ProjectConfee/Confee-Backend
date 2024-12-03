package com.backend.confee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateGroupedScheduleDTO {
    private Integer workshopDayId;
    private String date;
    private List<ScheduleDTO> events;

}
