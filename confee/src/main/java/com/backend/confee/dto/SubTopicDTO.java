package com.backend.confee.dto;

import com.backend.confee.entity.WorkshopDay;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubTopicDTO {
    private Integer id;
    private String subTopic;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "workshop_day_id")
    private WorkshopDay workshopDay;
}
