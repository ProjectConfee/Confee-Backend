package com.backend.confee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalTime;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Table(name = "Schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String event;
    private LocalTime startTime;
    private String status;



    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "workshop_day_id")
    private WorkshopDay workshopDay;
}
