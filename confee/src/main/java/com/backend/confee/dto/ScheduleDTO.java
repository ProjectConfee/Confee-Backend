package com.backend.confee.dto;

import com.backend.confee.entity.WorkshopDay;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ScheduleDTO {
    private Long id;
    private String event;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;
    private String status;

//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name = "workshop_day_id")
//    private WorkshopDay workshopDay;
//
//    public Integer getWorkshopDayId() {
//        return workshopDay.getId();
//    }
private Integer workshopDayId;
}
