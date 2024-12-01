package com.backend.confee.dto;

import com.backend.confee.entity.WorkshopDay;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkshopDTO {
    private Integer id;
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
