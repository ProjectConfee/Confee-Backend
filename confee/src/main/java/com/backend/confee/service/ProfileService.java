package com.backend.confee.service;
import com.backend.confee.dto.ProfileDTO;
import com.backend.confee.entity.Profile;

import java.util.List;

//public interface ProfileService {
//    ProfileDto createProfile(ProfileDto profileDto);
//    ProfileDto updateProfile(Long id, ProfileDto profileDto);
//    ProfileDto getProfileById(Long id);
//    List<ProfileDto> getAllProfiles();
//    void deleteProfile(Long id);
//}


import java.util.List;
//
//public interface ProfileService {
//    Profile addProfile(ProfileDto profileDto);
//    List<Profile> getAllProfiles();
//}


import com.backend.confee.dto.ProfileDTO;
import java.util.List;

public interface ProfileService {
    ProfileDTO saveProfile(ProfileDTO profileDTO);
    List<ProfileDTO> getAllProfiles();
}
