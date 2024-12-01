package com.backend.confee.controller;

import com.backend.confee.dto.ConferenceDTO;
import com.backend.confee.dto.ResponseDTO;
import com.backend.confee.entity.Conference;
import com.backend.confee.service.ConferenceService;
import com.backend.confee.util.VarList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/admin/conference")
@CrossOrigin
@RequiredArgsConstructor()
public class ConferenceController {

    private final ConferenceService conferenceService;

    private final ResponseDTO responseDTO;

    @PostMapping("/saveConference")
    public ResponseEntity<Conference> createConference(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate,
            @RequestParam("logo") MultipartFile logo
    ) throws IOException {
        ConferenceDTO conferenceDTO = new ConferenceDTO();
        conferenceDTO.setStartDate(startDate);
        conferenceDTO.setEndDate(endDate);
        conferenceDTO.setLogo(logo);
        Conference createdConference = conferenceService.saveConference(conferenceDTO);
        return ResponseEntity.ok(createdConference);
    }

    @GetMapping
    public ResponseEntity<List<Conference>> getAllConferences() {
        List<Conference> conferences = conferenceService.getAllConferences();
        return ResponseEntity.ok(conferences);
    }

}
