package com.backend.confee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class ConferenceScheduleDTO {
    private Long id;
    private String event;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;
    private String status;
    private Long conferenceId;
}
