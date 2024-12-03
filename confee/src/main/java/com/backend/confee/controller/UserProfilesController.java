package com.backend.confee.controller;

import com.backend.confee.entity.UserProfile;
import com.backend.confee.service.AllUserDetailsService;
import com.backend.confee.service.JWTUtils;
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
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private AllUserDetailsService allUserDetailsService;


    // Create or update a user profile

    @PostMapping()
    public ResponseEntity<UserProfile> createOrUpdateProfile( @RequestHeader("Authorization") String authorizationHeader, @RequestBody UserProfile userProfile) {

        String token = authorizationHeader.substring(7);
        String userName= jwtUtils.extractUsername(token);

        Integer userId=allUserDetailsService.getUserIdByEmail(userName);

        userProfile.setIsComplete(false);
        UserProfile savedProfile = userProfileService.createOrUpdateProfile(userId, userProfile);
        return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
    }
}
