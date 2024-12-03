package com.backend.confee.service;

import com.backend.confee.entity.AllUsers;
import com.backend.confee.entity.UserProfile;
import com.backend.confee.repo.AllUsersRepo;
import com.backend.confee.repo.UserProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    @Autowired
    private UserProfileRepo userProfileRepo;
    @Autowired
    private AllUsersRepo allUsersRepo;

    public UserProfile createOrUpdateProfile(Integer userId, UserProfile userProfile) {
        // Fetch the existing user
        AllUsers user = allUsersRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Set the user object in UserProfile
        userProfile.setUser(user);

        // Save the user profile
        return userProfileRepo.save(userProfile);
    }

}
