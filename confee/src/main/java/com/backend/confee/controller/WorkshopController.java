package com.backend.confee.controller;


import com.backend.confee.dto.ResponseDTO;
import com.backend.confee.dto.WorkshopDTO;
import com.backend.confee.dto.WorkshopResDTO;
import com.backend.confee.service.WorkshopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin/workshop")
@CrossOrigin
@RequiredArgsConstructor()
public class WorkshopController {
    private final WorkshopService workshopService;
    private ResponseDTO responseDTO;

    @PostMapping("/saveWorkshop")
    public ResponseEntity saveWorkshop(@RequestBody WorkshopDTO workshopDTO){
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
