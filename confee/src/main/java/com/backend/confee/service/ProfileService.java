package com.backend.confee.service;





import com.backend.confee.dto.ProfileDto;
import java.util.List;

public interface ProfileService {
    ProfileDto createProfile(ProfileDto profileDto);
    ProfileDto updateProfile(Long id, ProfileDto profileDto);
    ProfileDto getProfileById(Long id);
    List<ProfileDto> getAllProfiles();
    void deleteProfile(Long id);
}
