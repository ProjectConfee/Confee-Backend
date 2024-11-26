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

    @PostMapping("/saveSpeaker")
    public SpeakersDTO saveSpeaker(@RequestBody SpeakersDTO speakersDTO) {
        return speakersService.saveSpeakers(speakersDTO);
    }

    @GetMapping("/getSpeakers")
    public List<SpeakersDTO> getSpeakers() {
        return speakersService.getAllSpeakers();
    }

    @PutMapping("/updateSpeakers")
    public SpeakersDTO updateSpeaker(@RequestBody SpeakersDTO speakersDTO) {
        return speakersService.updateSpeakers(speakersDTO);
    }

    @DeleteMapping("/deleteSpeakers")
    public boolean deleteSpeaker(@RequestBody SpeakersDTO speakersDTO) {
        return speakersService.deleteSpeakers(speakersDTO);
    }
}
