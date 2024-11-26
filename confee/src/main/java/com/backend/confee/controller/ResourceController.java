package com.backend.confee.controller;

import com.backend.confee.dto.ResourceUploadRequestDTO;
import com.backend.confee.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/admin/files")
public class ResourceController {

    @Autowired
    private ResourceService fileMetadataService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("title")String title,
            @RequestParam("description") String description,
//            @RequestParam("workshopId") Long workshopId,
            @RequestParam("file") MultipartFile file
            ) {
        try {
            Long workshopId= 1L;
            ResourceUploadRequestDTO fileMetadataDTO  = new ResourceUploadRequestDTO();
            fileMetadataDTO.setTitle(title);
            fileMetadataDTO.setDescription(description);
            fileMetadataDTO.setWorkshopId(workshopId);
            fileMetadataDTO.setFile(file);

            fileMetadataService.saveFileMetadata(fileMetadataDTO);

            System.out.println(fileMetadataDTO);

            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
        }
    }
}
