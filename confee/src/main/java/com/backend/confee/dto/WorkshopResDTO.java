package com.backend.confee.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkshopResDTO {
    private Integer id;
    private String title;
    private String description;
    private String location;
    private String mapLink;
    private String type;
    private Integer noOfSeat;
    private String certificateFrom;
    private boolean lunch;
    private String post;
    private String coverPhoto;

    @OneToMany(mappedBy = "workshop", cascade = CascadeType.ALL)
    private List<WorkshopDayDTO> workshopDays;

    public WorkshopResDTO(Integer id,String type, String title, Integer noOfSeat,String coverPhoto) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.noOfSeat = noOfSeat;
        this.coverPhoto = coverPhoto;
    }
}
