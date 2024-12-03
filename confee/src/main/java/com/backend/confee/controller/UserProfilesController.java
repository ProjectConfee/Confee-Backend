package com.backend.confee.controller;

import com.backend.confee.entity.UserProfile;
import com.backend.confee.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/profile")
public class UserProfilesController {
    @Autowired
    private UserProfileService userProfileService;

    // Create or update a user profile

    @PostMapping()
    public ResponseEntity<UserProfile> createOrUpdateProfile( @RequestBody UserProfile userProfile) {
        Integer userId=2;
        userProfile.setIsComplete(false);
        UserProfile savedProfile = userProfileService.createOrUpdateProfile(userId, userProfile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }
}
