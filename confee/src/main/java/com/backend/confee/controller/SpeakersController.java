package com.backend.confee.controller;

import com.backend.confee.dto.SpeakersDTO;
import com.backend.confee.service.SpeakersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/speakers")
@CrossOrigin

public class SpeakersController {

    @Autowired
    private SpeakersService speakersService;

    @PostMapping("/saveSpeakers")
    public SpeakersDTO saveSpeakers(@RequestBody SpeakersDTO speakersDTO) {
        return speakersService.saveSpeakers(speakersDTO);
    }

    @GetMapping("/getSpeakers")
    public List<SpeakersDTO> getSpeakers() {
        return speakersService.getAllSpeakers();
    }

    @PutMapping("/updateSpeakers")
    public SpeakersDTO updateSpeakers(@RequestBody SpeakersDTO speakersDTO) {
        return speakersService.updateSpeakers(speakersDTO);
    }

    @DeleteMapping("/deleteSpeakers")
    public boolean deleteSpeakers(@RequestBody SpeakersDTO speakersDTO) {
        return speakersService.deleteSpeakers(speakersDTO);
    }
}
