package com.backend.confee.controller;


import com.backend.confee.dto.ResponseDTO;
import com.backend.confee.dto.WorkshopDTO;
import com.backend.confee.dto.WorkshopResDTO;
import com.backend.confee.service.WorkshopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/workshop")
@CrossOrigin
@RequiredArgsConstructor()
public class WorkshopController {
    private final WorkshopService workshopService;
    private ResponseDTO responseDTO;

    @PostMapping("/saveWorkshop")
    public ResponseEntity saveWorkshop(
            @RequestParam String type,
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam int noOfSeat,
            @RequestParam int noOfDate,
            @RequestParam String certificateFrom,
            @RequestParam String mapLink,
            @RequestParam String location,
            @RequestParam boolean lunch,
            @RequestParam MultipartFile post,
            @RequestParam MultipartFile coverPhoto
            ){
        System.out.println(232);

        WorkshopDTO workshopDTO=new WorkshopDTO();
        workshopDTO.setLunch(lunch);
        workshopDTO.setType(type);
        workshopDTO.setTitle(title);
        workshopDTO.setDescription(description);
        workshopDTO.setNoOfSeat(noOfSeat);
        workshopDTO.setNoOfDate(noOfDate);
        workshopDTO.setCertificateFrom(certificateFrom);
        workshopDTO.setMapLink(mapLink);
        workshopDTO.setLocation(location);
        workshopDTO.setPost(post);
        workshopDTO.setCoverPhoto(coverPhoto);

        responseDTO = workshopService.saveWorkshop(workshopDTO);
        return new ResponseEntity(responseDTO.getMessage(), responseDTO.getStatusCode());
    }

    @GetMapping("/{id}")
    public WorkshopResDTO getWorkshopById(@PathVariable Integer id) {
        return workshopService.getWorkshopById(id);
    }

    @GetMapping
    public ResponseEntity<List<WorkshopResDTO>> getWorkshopSummary() {
        return ResponseEntity.ok(workshopService.getWorkshopSummary());
    }
}
