package com.backend.confee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConferenceDayResDTO {
    private Long id;
    private String title;
    private Double investment;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime endTime;
    private String location;
    private String mapLink;
    private boolean lunch;
    private String post;
    private String coverPhoto;

    ConferenceDayResDTO(Long id,  String title,LocalDate date, String coverPhoto){
        this.id=id;
        this.title=title;
        this.date=date;
        this.coverPhoto=coverPhoto;
    }
}
