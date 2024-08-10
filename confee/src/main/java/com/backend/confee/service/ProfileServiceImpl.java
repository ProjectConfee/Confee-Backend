package com.backend.confee.service;
import com.backend.confee.dto.SocialMediaLinkDto;
import com.backend.confee.dto.ProfileDto;
import com.backend.confee.entity.Profile;
import com.backend.confee.entity.SocialMediaLink;
import com.backend.confee.repo.ProfileRepository;
import com.backend.confee.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public ProfileDto createProfile(ProfileDto profileDto) {
        Profile profile = mapToEntity(profileDto);
        Profile newProfile = profileRepository.save(profile);
        return mapToDto(newProfile);
    }

    @Override
    public ProfileDto updateProfile(Long id, ProfileDto profileDto) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        profile.setCompanyName(profileDto.getCompanyName());
        profile.setCompanyAddress(profileDto.getCompanyAddress());
        profile.setContactNumber(profileDto.getContactNumber());
        profile.setCompanyEmail(profileDto.getCompanyEmail());
        profile.setBiography(profileDto.getBiography());
        profile.setPlayGamesAdded(profileDto.getPlayGamesAdded());
        profile.setCompanyLogo(profileDto.getCompanyLogo());
        profile.setSocialMediaLinks(profileDto.getSocialMediaLinks()
                .stream()
                .map(linkDto -> {
                    SocialMediaLink link = new SocialMediaLink();
                    link.setPlatform(linkDto.getPlatform());
                    link.setUrl(linkDto.getUrl());
                    return link;
                })
                .collect(Collectors.toList()));

        Profile updatedProfile = profileRepository.save(profile);
        return mapToDto(updatedProfile);
    }

    @Override
    public ProfileDto getProfileById(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        return mapToDto(profile);
    }

    @Override
    public List<ProfileDto> getAllProfiles() {
        List<Profile> profiles = profileRepository.findAll();
        return profiles.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public void deleteProfile(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));
        profileRepository.delete(profile);
    }

    private Profile mapToEntity(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setCompanyName(profileDto.getCompanyName());
        profile.setCompanyAddress(profileDto.getCompanyAddress());
        profile.setContactNumber(profileDto.getContactNumber());
        profile.setCompanyEmail(profileDto.getCompanyEmail());
        profile.setBiography(profileDto.getBiography());
        profile.setPlayGamesAdded(profileDto.getPlayGamesAdded());
        profile.setCompanyLogo(profileDto.getCompanyLogo());
        profile.setSocialMediaLinks(profileDto.getSocialMediaLinks()
                .stream()
                .map(linkDto -> {
                    SocialMediaLink link = new SocialMediaLink();
                    link.setPlatform(linkDto.getPlatform());
                    link.setUrl(linkDto.getUrl());
                    return link;
                })
                .collect(Collectors.toList()));
        return profile;
    }

    private ProfileDto mapToDto(Profile profile) {
        ProfileDto profileDto = new ProfileDto();
        profileDto.setId(profile.getId());
        profileDto.setCompanyName(profile.getCompanyName());
        profileDto.setCompanyAddress(profile.getCompanyAddress());
        profileDto.setContactNumber(profile.getContactNumber());
        profileDto.setCompanyEmail(profile.getCompanyEmail());
        profileDto.setBiography(profile.getBiography());
        profileDto.setPlayGamesAdded(profile.getPlayGamesAdded());
        profileDto.setCompanyLogo(profile.getCompanyLogo());
        profileDto.setSocialMediaLinks(profile.getSocialMediaLinks()
                .stream()
                .map(link -> {
                    SocialMediaLinkDto linkDto = new SocialMediaLinkDto();
                    linkDto.setPlatform(link.getPlatform());
                    linkDto.setUrl(link.getUrl());
                    return linkDto;
                })
                .collect(Collectors.toList()));
        return profileDto;
    }
}


