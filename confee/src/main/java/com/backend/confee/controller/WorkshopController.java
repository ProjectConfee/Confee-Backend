package com.backend.confee.controller;


import com.backend.confee.dto.ResponseDTO;
import com.backend.confee.dto.WorkshopDTO;
import com.backend.confee.service.WorkshopService;
import com.backend.confee.util.VarList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
@RequiredArgsConstructor()
public class WorkshopController {
    private final WorkshopService workshopService;
    private ResponseDTO responseDTO;

    @PostMapping("/saveWorkshop")
    public ResponseEntity saveWorkshop(@RequestBody WorkshopDTO workshopDTO){

        System.out.println(workshopDTO.toString());
        responseDTO = workshopService.saveWorkshop(workshopDTO);
        System.out.println(workshopDTO);
        return new ResponseEntity(responseDTO.getMessage(), responseDTO.getStatusCode());
    }
}
