package com.backend.confee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String fileUrl;
    private String createdAt;
}
