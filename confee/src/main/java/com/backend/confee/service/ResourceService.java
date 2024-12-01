package com.backend.confee.service;

import com.backend.confee.dto.ResourceUploadRequestDTO;
import com.backend.confee.entity.Resource;
import com.backend.confee.repo.ResourceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepo fileMetadataRepository;

    // Assuming you have a method to save the file to the file system or cloud storage
    public String storeFile(MultipartFile file) throws IOException {
        // Logic for storing file and returning the file URL
        // For example, storing on disk or uploading to a cloud bucket
        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        Path targetLocation = Paths.get("/Users/virajidewmini/Documents/Confee-Backend/confee/src/main/java/com/backend/confee/uploads", fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return targetLocation.toString(); // Or the URL to the cloud file
    }

    public void saveFileMetadata(ResourceUploadRequestDTO fileMetadataDTO) throws IOException {
        // Save the file to storage and get the file URL
        String fileUrl = storeFile(fileMetadataDTO.getFile());

        // Save the metadata into the database
        Resource fileMetadata = new Resource();
        fileMetadata.setTitle(fileMetadataDTO.getTitle());
        fileMetadata.setDescription(fileMetadataDTO.getDescription());
        fileMetadata.setFileUrl(fileUrl);

        // Assuming Workshop is already a valid entity and you can fetch it by ID
//        Optional<Workshop> workshop = workshopRepository.findById(fileMetadataDTO.getWorkshopId());
//        workshop.ifPresent(fileMetadata::setWorkshop);

        fileMetadataRepository.save(fileMetadata);
    }
}
