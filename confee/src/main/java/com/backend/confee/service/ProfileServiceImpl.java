//package com.backend.confee.service;
//import com.backend.confee.dto.PlayGamesAddedDTO;
//import com.backend.confee.dto.SocialMediaLinkDto;
//import com.backend.confee.dto.ProfileDto;
//import com.backend.confee.entity.Profile;
//import com.backend.confee.entity.SocialMediaLink;
//import com.backend.confee.repo.ProfileRepository;
//import com.backend.confee.service.ProfileService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ProfileServiceImpl implements ProfileService {
//
//    @Autowired
//    private ProfileRepository profileRepository;
//
//    @Override
//    public ProfileDto createProfile(ProfileDto profileDto) {
//        Profile profile = mapToEntity(profileDto);
//        Profile newProfile = profileRepository.save(profile);
//        return mapToDto(newProfile);
//    }
//
//    @Override
//    public ProfileDto updateProfile(Long id, ProfileDto profileDto) {
//        Profile profile = profileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//
//        profile.setCompanyName(profileDto.getCompanyName());
//        profile.setCompanyAddress(profileDto.getCompanyAddress());
//        profile.setContactNumber(profileDto.getContactNumber());
//        profile.setCompanyEmail(profileDto.getCompanyEmail());
//        profile.setBiography(profileDto.getBiography());
//        profile.setPlayGamesAdded(profileDto.getPlayGamesAdded());
//        profile.setCompanyLogo(profileDto.getCompanyLogo());
//        profile.setSocialMediaLinks(profileDto.getSocialMediaLinks()
//                .stream()
//                .map(linkDto -> {
//                    SocialMediaLink link = new SocialMediaLink();
//                    link.setPlatform(linkDto.getPlatform());
//                    link.setUrl(linkDto.getUrl());
//                    return link;
//                })
//                .collect(Collectors.toList()));
//
//        Profile updatedProfile = profileRepository.save(profile);
//        return mapToDto(updatedProfile);
//    }
//
//    @Override
//    public ProfileDto getProfileById(Long id) {
//        Profile profile = profileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//        return mapToDto(profile);
//    }
//
//    @Override
//    public List<ProfileDto> getAllProfiles() {
//        List<Profile> profiles = profileRepository.findAll();
//        return profiles.stream().map(this::mapToDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteProfile(Long id) {
//        Profile profile = profileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//        profileRepository.delete(profile);
//    }
//
//    private Profile mapToEntity(ProfileDto profileDto) {
//        Profile profile = new Profile();
//        profile.setCompanyName(profileDto.getCompanyName());
//        profile.setCompanyAddress(profileDto.getCompanyAddress());
//        profile.setContactNumber(profileDto.getContactNumber());
//        profile.setCompanyEmail(profileDto.getCompanyEmail());
//        profile.setBiography(profileDto.getBiography());
//        profile.setPlayGamesAdded(profileDto.getPlayGamesAdded());
//        profile.setCompanyLogo(profileDto.getCompanyLogo());
//        profile.setSocialMediaLinks(profileDto.getSocialMediaLinks()
//                .stream()
//                .map(linkDto -> {
//                    SocialMediaLink link = new SocialMediaLink();
//                    link.setPlatform(linkDto.getPlatform());
//                    link.setUrl(linkDto.getUrl());
//                    return link;
//                })
//                .collect(Collectors.toList()));
//        return profile;
//    }
//
//    private ProfileDto mapToDto(Profile profile) {
//        ProfileDto profileDto = new ProfileDto();
//        profileDto.setId(profile.getId());
//        profileDto.setCompanyName(profile.getCompanyName());
//        profileDto.setCompanyAddress(profile.getCompanyAddress());
//        profileDto.setContactNumber(profile.getContactNumber());
//        profileDto.setCompanyEmail(profile.getCompanyEmail());
//        profileDto.setBiography(profile.getBiography());
//        profileDto.setPlayGamesAdded(profile.getPlayGamesAdded()
//                .stream()
//                .map(link -> {
//                    PlayGamesAddedDTO linkDto = new PlayGamesAddedDTO();
//                    linkDto.setPlayGamesAdded(linkDto.getPlayGamesAdded());
//                    return linkDto;
//                })
//                .collect(Collectors.toList()));
//        profileDto.setCompanyLogo(profile.getCompanyLogo());
//        profileDto.setSocialMediaLinks(profile.getSocialMediaLinks()
//                .stream()
//                .map(link -> {
//                    SocialMediaLinkDto linkDto = new SocialMediaLinkDto();
//                    linkDto.setPlatform(link.getPlatform());
//                    linkDto.setUrl(link.getUrl());
//                    return linkDto;
//                })
//                .collect(Collectors.toList()));
//        return profileDto;
//    }
//}

//package com.backend.confee.service;
//
//import com.backend.confee.dto.PlayGamesAddedDTO;
//import com.backend.confee.dto.SocialMediaLinkDto;
//import com.backend.confee.dto.ProfileDto;
//import com.backend.confee.entity.Profile;
//import com.backend.confee.entity.SocialMediaLink;
//import com.backend.confee.repo.ProfileRepository;
//import com.backend.confee.entity.PlayGamesAdded; // Assuming there's a corresponding entity
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ProfileServiceImpl implements ProfileService {
//
//    @Autowired
//    private ProfileRepository profileRepository;
//
//    @Override
//    public ProfileDto createProfile(ProfileDto profileDto) {
//        Profile profile = mapToEntity(profileDto);
//        Profile newProfile = profileRepository.save(profile);
//        return mapToDto(newProfile);
//    }
//
//    @Override
//    public ProfileDto updateProfile(Long id, ProfileDto profileDto) {
//        Profile profile = profileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//
//        profile.setCompanyName(profileDto.getCompanyName());
//        profile.setCompanyAddress(profileDto.getCompanyAddress());
//        profile.setContactNumber(profileDto.getContactNumber());
//        profile.setCompanyEmail(profileDto.getCompanyEmail());
//        profile.setBiography(profileDto.getBiography());
////        profile.setPlayGamesAdded(profileDto.getPlayGamesAdded()
////                .stream()
////                .map(dto -> {
////                    PlayGamesAdded playGame = new PlayGamesAdded();
////                    playGame.setPlayGamesAdded(dto.getPlayGamesAdded()); // Assuming there's a setter
////                    return playGame;
////                })
////                .collect(Collectors.toList()));
//        profile.setCompanyLogo(profileDto.getCompanyLogo());
//        profile.setSocialMediaLinks(profileDto.getSocialMediaLinks()
//                .stream()
//                .map(linkDto -> {
//                    SocialMediaLink link = new SocialMediaLink();
//                    link.setPlatform(linkDto.getPlatform());
//                    link.setUrl(linkDto.getUrl());
//                    return link;
//                })
//                .collect(Collectors.toList()));
//
//        Profile updatedProfile = profileRepository.save(profile);
//        return mapToDto(updatedProfile);
//    }
//
//    @Override
//    public ProfileDto getProfileById(Long id) {
//        Profile profile = profileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//        return mapToDto(profile);
//    }
//
//    @Override
//    public List<ProfileDto> getAllProfiles() {
//        List<Profile> profiles = profileRepository.findAll();
//        return profiles.stream().map(this::mapToDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteProfile(Long id) {
//        Profile profile = profileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//        profileRepository.delete(profile);
//    }
//
//    private Profile mapToEntity(ProfileDto profileDto) {
//        Profile profile = new Profile();
//        profile.setCompanyName(profileDto.getCompanyName());
//        profile.setCompanyAddress(profileDto.getCompanyAddress());
//        profile.setContactNumber(profileDto.getContactNumber());
//        profile.setCompanyEmail(profileDto.getCompanyEmail());
//        profile.setBiography(profileDto.getBiography());
//        profile.setPlayGamesAdded(profileDto.getPlayGamesAdded()
//                .stream()
//                .map(dto -> {
//                    PlayGamesAdded playGame = new PlayGamesAdded();
//                    playGame.setPlayGamesAdded(dto.getlayGamesAdded()); // Ensure this method exists in PlayGamesAdded
//                    return playGame;
//                })
//                .collect(Collectors.toList()));
//        profile.setCompanyLogo(profileDto.getCompanyLogo());
//        profile.setSocialMediaLinks(profileDto.getSocialMediaLinks()
//                .stream()
//                .map(linkDto -> {
//                    SocialMediaLink link = new SocialMediaLink();
//                    link.setPlatform(linkDto.getPlatform());
//                    link.setUrl(linkDto.getUrl());
//                    return link;
//                })
//                .collect(Collectors.toList()));
//        return profile;
//    }
//
//
//    private ProfileDto mapToDto(Profile profile) {
//        ProfileDto profileDto = new ProfileDto();
//        profileDto.setId(profile.getId());
//        profileDto.setCompanyName(profile.getCompanyName());
//        profileDto.setCompanyAddress(profile.getCompanyAddress());
//        profileDto.setContactNumber(profile.getContactNumber());
//        profileDto.setCompanyEmail(profile.getCompanyEmail());
//        profileDto.setBiography(profile.getBiography());
//        profileDto.setPlayGamesAdded(profile.getPlayGamesAdded()
//                .stream()
//                .map(playGame -> {
//                    PlayGamesAddedDTO playGameDto = new PlayGamesAddedDTO();
//                    playGameDto.setPlayGamesAdded(playGame.getPlayGamesAdded()); // Ensure this method exists in PlayGamesAdded
//                    return playGameDto;
//                })
//                .collect(Collectors.toList()));
//        profileDto.setCompanyLogo(profile.getCompanyLogo());
//        profileDto.setSocialMediaLinks(profile.getSocialMediaLinks()
//                .stream()
//                .map(link -> {
//                    SocialMediaLinkDto linkDto = new SocialMediaLinkDto();
//                    linkDto.setPlatform(link.getPlatform());
//                    linkDto.setUrl(link.getUrl());
//                    return linkDto;
//                })
//                .collect(Collectors.toList()));
//        return profileDto;
////    }
////
////}
package com.backend.confee.service;


import com.backend.confee.dto.ProfileDTO;
import com.backend.confee.dto.SocialMediaLinkDto;
import com.backend.confee.entity.Profile;


//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class ProfileServiceImpl implements ProfileService {
//
//    @Autowired
//    private ProfileRepository profileRepository;
//
//    @Override
//    public ProfileDto createProfile(ProfileDto profileDto) {
//        Profile profile = mapToEntity(profileDto);
//        Profile newProfile = profileRepository.save(profile);
//        return mapToDto(newProfile);
//    }
//
//    @Override
//    public ProfileDto updateProfile(Long id, ProfileDto profileDto) {
//        Profile profile = profileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//
//        profile.setCompanyName(profileDto.getCompanyName());
//        profile.setCompanyAddress(profileDto.getCompanyAddress());
//        profile.setContactNumber(profileDto.getContactNumber());
//        profile.setCompanyEmail(profileDto.getCompanyEmail());
//        profile.setBiography(profileDto.getBiography());
//
////        // Handle PlayGamesAdded field
////        profile.setPlayGamesAdded(profileDto.getPlayGamesAdded()
////                .stream()
////                .map(link -> {
////                    PlayGamesAddedDTO playGameDto = new PlayGamesAddedDTO();
////                    playGameDto.setPlayGamesAdded(link.getPlayGamesAdded());
////                    return playGameDto;
////                })
////                .collect(Collectors.toList()));
//
//        profile.setCompanyLogo(profileDto.getCompanyLogo());
//        profile.setSocialMediaLinks(profileDto.getSocialMediaLinks()
//                .stream()
//                .map(linkDto -> {
//                    SocialMediaLink link = new SocialMediaLink();
//                    link.setPlatform(linkDto.getPlatform());
//                    link.setUrl(linkDto.getUrl());
//                    return link;
//                })
//                .collect(Collectors.toList()));
//
//        Profile updatedProfile = profileRepository.save(profile);
//        return mapToDto(updatedProfile);
//    }
//
//    @Override
//    public ProfileDto getProfileById(Long id) {
//        Profile profile = profileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//        return mapToDto(profile);
//    }
//
//    @Override
//    public List<ProfileDto> getAllProfiles() {
//        List<Profile> profiles = profileRepository.findAll();
//        return profiles.stream().map(this::mapToDto).collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteProfile(Long id) {
//        Profile profile = profileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//        profileRepository.delete(profile);
//    }
//
//    private Profile mapToEntity(ProfileDto profileDto) {
//        Profile profile = new Profile();
//        profile.setCompanyName(profileDto.getCompanyName());
//        profile.setCompanyAddress(profileDto.getCompanyAddress());
//        profile.setContactNumber(profileDto.getContactNumber());
//        profile.setCompanyEmail(profileDto.getCompanyEmail());
//        profile.setBiography(profileDto.getBiography());
//
//        // Map PlayGamesAddedDTO to PlayGamesAdded entity
//        profile.setPlayGamesAdded(profileDto.getPlayGamesAdded()
//                .stream()
//                .map(link -> {
//                    PlayGamesAddedDTO playGameDto = new PlayGamesAddedDTO();
//                    playGameDto.setPlayGamesAdded(link.getPlayGamesAdded());
//                    return playGameDto;
//                })
//                .collect(Collectors.toList()));
//
//        profile.setCompanyLogo(profileDto.getCompanyLogo());
//        profile.setSocialMediaLinks(profileDto.getSocialMediaLinks()
//                .stream()
//                .map(linkDto -> {
//                    SocialMediaLink link = new SocialMediaLink();
//                    link.setPlatform(linkDto.getPlatform());
//                    link.setUrl(linkDto.getUrl());
//                    return link;
//                })
//                .collect(Collectors.toList()));
//        return profile;
//    }
//
//    private ProfileDto mapToDto(Profile profile) {
//        ProfileDto profileDto = new ProfileDto();
//        profileDto.setId(profile.getId());
//        profileDto.setCompanyName(profile.getCompanyName());
//        profileDto.setCompanyAddress(profile.getCompanyAddress());
//        profileDto.setContactNumber(profile.getContactNumber());
//        profileDto.setCompanyEmail(profile.getCompanyEmail());
//        profileDto.setBiography(profile.getBiography());
//
//        // Map PlayGamesAdded entity to PlayGamesAddedDTO
//        profileDto.setPlayGamesAdded(profile.getPlayGamesAdded()
//                .stream()
//                .map(link -> {
//                    PlayGamesAddedDTO playGameDto = new PlayGamesAddedDTO();
//                    playGameDto.setPlayGamesAdded(link.getPlayGamesAdded());
//                    return playGameDto;
//                })
//                .collect(Collectors.toList()));
//
//        profileDto.setCompanyLogo(profile.getCompanyLogo());
//        profileDto.setSocialMediaLinks(profile.getSocialMediaLinks()
//                .stream()
//                .map(link -> {
//                    SocialMediaLinkDto linkDto = new SocialMediaLinkDto();
//                    linkDto.setPlatform(link.getPlatform());
//                    linkDto.setUrl(link.getUrl());
//                    return linkDto;
//                })
//                .collect(Collectors.toList()));
//        return profileDto;
//    }
//}


//
//import com.backend.confee.dto.ProfileDto;
//import com.backend.confee.dto.SocialMediaLinkDto;
//import com.backend.confee.entity.Profile;
//
//import com.backend.confee.repo.ProfileRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ProfileServiceImpl implements ProfileService {
//
//    @Autowired
//    private ProfileRepository profileRepository;
//
//    @Override
//    public Profile addProfile(ProfileDto profileDto) {
//        Profile profile = new Profile();
//        profile.setCompanyName(profileDto.getCompanyName());
//        profile.setCompanyAddress(profileDto.getCompanyAddress());
//        profile.setContactNumber(profileDto.getContactNumber());
//        profile.setCompanyEmail(profileDto.getCompanyEmail());
//        profile.setBiography(profileDto.getBiography());
//        profile.setPlayGames(profileDto.getPlayGames());
//        profile.setCompanyLogo(profileDto.getCompanyLogo());
//
//        List<Profile.SocialMediaLink> socialMediaLinks = new ArrayList<>();
//        for (SocialMediaLinkDto linkDto : profileDto.getSocialMediaLinks()) {
//            Profile.SocialMediaLink link = new Profile.SocialMediaLink();
//            link.setPlatform(linkDto.getPlatform());
//            link.setUrl(linkDto.getUrl());
//            socialMediaLinks.add(link);
//        }
//        profile.setSocialMediaLinks(socialMediaLinks);
//
//        return profileRepository.save(profile);
//    }
//
//    @Override
//    public List<Profile> getAllProfiles() {
//        return profileRepository.findAll();
//    }
//}


import com.backend.confee.entity.SocialMediaLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private com.backend.confee.repository.ProfileRepository profileRepository;

    @Override
    public ProfileDTO saveProfile(ProfileDTO profileDTO) {
        Profile profile = convertToEntity(profileDTO);
        Profile savedProfile = profileRepository.save(profile);
        return convertToDTO(savedProfile);
    }

    @Override
    public List<ProfileDTO> getAllProfiles() {
        return profileRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private Profile convertToEntity(ProfileDTO profileDTO) {
        Profile profile = new Profile();
        profile.setCompanyName(profileDTO.getCompanyName());
        profile.setCompanyAddress(profileDTO.getCompanyAddress());
        profile.setContactNumber(profileDTO.getContactNumber());
        profile.setCompanyEmail(profileDTO.getCompanyEmail());
        profile.setBiography(profileDTO.getBiography());
        profile.setPlayGames(profileDTO.getPlayGames());
        profile.setCompanyLogo(profileDTO.getCompanyLogo());
        profile.setSocialMediaLinks(profileDTO.getSocialMediaLinks()
                .stream()
                .map(link -> {
                    SocialMediaLink socialMediaLink = new SocialMediaLink();
                    socialMediaLink.setPlatform(link.getPlatform());
                    socialMediaLink.setUrl(link.getUrl());
                    return socialMediaLink;
                })
                .collect(Collectors.toList()));
        return profile;
    }

    private ProfileDTO convertToDTO(Profile profile) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setCompanyName(profile.getCompanyName());
        profileDTO.setCompanyAddress(profile.getCompanyAddress());
        profileDTO.setContactNumber(profile.getContactNumber());
        profileDTO.setCompanyEmail(profile.getCompanyEmail());
        profileDTO.setBiography(profile.getBiography());
        profileDTO.setPlayGames(profile.getPlayGames());
        profileDTO.setCompanyLogo(profile.getCompanyLogo());
        profileDTO.setSocialMediaLinks(profile.getSocialMediaLinks()
                .stream()
                .map(link -> {
                    SocialMediaLinkDto linkDTO = new SocialMediaLinkDto();
                    linkDTO.setPlatform(link.getPlatform());
                    linkDTO.setUrl(link.getUrl());
                    return linkDTO;
                })
                .collect(Collectors.toList()));
        return profileDTO;
    }
}
