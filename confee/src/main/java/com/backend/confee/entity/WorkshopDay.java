package com.backend.confee.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @JsonManagedReference
    @OneToMany(mappedBy = "workshopDay", cascade = CascadeType.ALL)
    private List<SubTopic> subTopics;

    @JsonManagedReference
    @OneToMany(mappedBy = "workshopDay", cascade = CascadeType.ALL)
    private List<Schedule> schedules;
}
