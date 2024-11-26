package com.backend.confee.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ResourceUploadRequestDTO {
    private String title;
    private String description;
    private Long workshopId;
    private MultipartFile file;
}
