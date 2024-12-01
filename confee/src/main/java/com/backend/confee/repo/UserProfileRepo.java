package com.backend.confee.repo;

import com.backend.confee.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepo extends JpaRepository<UserProfile, Integer> {

}
