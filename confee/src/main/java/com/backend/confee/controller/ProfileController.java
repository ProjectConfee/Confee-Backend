package com.backend.confee.controller;


import com.backend.confee.dto.ProfileDto;
import com.backend.confee.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/add")
    public ProfileDto createProfile(@RequestBody ProfileDto profileDto) {
        return profileService.createProfile(profileDto);
    }

    @PutMapping("/{id}")
    public ProfileDto updateProfile(@PathVariable Long id, @RequestBody ProfileDto profileDto) {
        return profileService.updateProfile(id, profileDto);
    }

    @GetMapping("/{id}")
    public ProfileDto getProfileById(@PathVariable Long id) {
        return profileService.getProfileById(id);
    }

    @GetMapping("/getAll")
    public List<ProfileDto> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
    }
}

