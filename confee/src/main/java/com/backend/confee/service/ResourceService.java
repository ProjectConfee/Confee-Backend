package com.backend.confee.service;

import com.backend.confee.dto.ResourceResponseDTO;
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
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepo fileMetadataRepository;

    public ResourceService(ResourceRepo resourceRepository) {
        this.fileMetadataRepository = resourceRepository;
    }

    public String storeFile(MultipartFile file) throws IOException {

        String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
        System.out.println(fileName);
        Path targetLocation = Paths.get("src/main/java/com/backend/confee/uploads", fileName);
        Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
        return "uploads/" + fileName;// Or the URL to the cloud file
    }

    public void saveFileMetadata(ResourceUploadRequestDTO fileMetadataDTO) throws IOException {

        String fileUrl = storeFile(fileMetadataDTO.getFile());
        Resource fileMetadata = new Resource();
        fileMetadata.setTitle(fileMetadataDTO.getTitle());
        fileMetadata.setDescription(fileMetadataDTO.getDescription());
        fileMetadata.setFileUrl(fileUrl);
        fileMetadata.setWorkshopId(fileMetadataDTO.getWorkshopId());

        fileMetadataRepository.save(fileMetadata);
    }

    public List<ResourceResponseDTO> getResourcesByWorkshopId(Long workshopId) {
        List<Resource> resources = fileMetadataRepository.findByWorkshopId(workshopId);
        return resources.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private ResourceResponseDTO convertToDTO(Resource resource) {
        ResourceResponseDTO dto = new ResourceResponseDTO();
        dto.setId(resource.getId());
        dto.setTitle(resource.getTitle());
        dto.setDescription(resource.getDescription());
        dto.setFileUrl(resource.getFileUrl());
        dto.setCreatedAt(resource.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        return dto;
    }

}
