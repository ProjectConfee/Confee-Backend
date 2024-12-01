package com.backend.confee.dto;

import com.backend.confee.entity.SubTopic;
import com.backend.confee.entity.Workshop;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkshopDayDTO {
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
