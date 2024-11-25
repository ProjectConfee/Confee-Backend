package com.backend.confee.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "WorkshopDay")
public class WorkshopDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String day;
    private String date;
    private String startTime;
    private String endTime;
    private String mainTopic;
    private Double investment;

    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @OneToMany(mappedBy = "workshopDay", cascade = CascadeType.ALL)
    private List<SubTopic> subTopics;
}
