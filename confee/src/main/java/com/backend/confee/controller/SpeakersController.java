package com.backend.confee.controller;

import com.backend.confee.dto.SpeakersDTO;
import com.backend.confee.service.SpeakersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
