package com.backend.confee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Workshop")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String title;
    private String description;
    private String location;
    private String type;
    private String certificateFrom;
    private boolean lunch;
    private String post;
    private String coverPhoto;

    @OneToMany(mappedBy = "workshop", cascade = CascadeType.ALL)
    private List<WorkshopDay> workshopDays;
}
