package com.backend.confee.controller;



import com.backend.confee.entity.Profile;
import com.backend.confee.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@CrossOrigin(origins = "http://localhost:5174")
//@RestController
//@RequestMapping("/profiles")
//public class ProfileController {
//
//    @Autowired
//    private ProfileService profileService;
//
//    @PostMapping("/add")
//    public ProfileDto createProfile(@RequestBody ProfileDto profileDto) {
//        return profileService.createProfile(profileDto);
//    }
//
//    @PutMapping("/{id}")
//    public ProfileDto updateProfile(@PathVariable Long id, @RequestBody ProfileDto profileDto) {
//        return profileService.updateProfile(id, profileDto);
//    }
//
//    @GetMapping("/{id}")
//    public ProfileDto getProfileById(@PathVariable Long id) {
//        return profileService.getProfileById(id);
//    }
//
//    @GetMapping("/getAll")
//    public List<ProfileDto> getAllProfiles() {
//        return profileService.getAllProfiles();
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteProfile(@PathVariable Long id) {
//        profileService.deleteProfile(id);
//    }
//}
//


import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/profiles")
//@CrossOrigin(origins = "http://localhost:3000")
//public class ProfileController {
//
//    @Autowired
//    private ProfileService profileService;
//
//    @PostMapping("/add")
//    public Profile addProfile(@RequestBody ProfileDto profileDto) {
//        return profileService.addProfile(profileDto);
//    }
//
//    @GetMapping("/all")
//    public List<Profile> getAllProfiles() {
//        return profileService.getAllProfiles();
//    }
//}


import com.backend.confee.dto.ProfileDTO;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/api/profiles")
//@CrossOrigin
//public class ProfileController {
//
//    @Autowired
//    private ProfileService profileService;
//
//    @PostMapping("/add")
//    public ProfileDTO addProfile(@RequestBody ProfileDTO profileDTO) {
//        return profileService.addProfile(profileDTO);
//    }
//
//    @GetMapping("/getAll")
//    public List<ProfileDTO> getAllProfiles() {
//        return profileService.getAllProfiles();
//    }
//}


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @PostMapping("/add")
    public ResponseEntity<ProfileDTO> addProfile(@RequestBody ProfileDTO profileDTO) {
        ProfileDTO createdProfile = profileService.addProfile(profileDTO);
        return ResponseEntity.ok(createdProfile);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ProfileDTO>> getAllProfiles() {
        List<ProfileDTO> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDTO> getProfileById(@PathVariable Long id) {
        ProfileDTO profile = profileService.getProfileById(id);
        return ResponseEntity.ok(profile);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return ResponseEntity.noContent().build();
    }
}
