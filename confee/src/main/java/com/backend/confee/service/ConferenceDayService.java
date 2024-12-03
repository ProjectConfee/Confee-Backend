package com.backend.confee.service;

import com.backend.confee.dto.*;
import com.backend.confee.entity.AllUsers;
import com.backend.confee.entity.ConferenceDay;
import com.backend.confee.repo.ConferenceDayRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ConferenceDayService {

    private final ConferenceDayRepo conferenceDayRepo;
    private final ResourceService resourceService;
    private final ModelMapper modelMapper;

    public ConferenceDayService(ConferenceDayRepo conferenceDayRepo, ResourceService resourceService, ModelMapper modelMapper) {
        this.conferenceDayRepo = conferenceDayRepo;
        this.resourceService = resourceService;
        this.modelMapper = modelMapper;
    }
    public ConferenceDay saveConferenceDay(ConferenceDayDTO conferenceDTO) throws IOException {

        ConferenceDay conference = new ConferenceDay();

        conference.setTitle(conferenceDTO.getTitle());
        conference.setDate(conferenceDTO.getDate());
        conference.setInvestment(conferenceDTO.getInvestment());
        conference.setLunch(conferenceDTO.isLunch());
        conference.setLocation(conferenceDTO.getLocation());
        conference.setMapLink(conferenceDTO.getMapLink());
        conference.setStartTime(conferenceDTO.getStartTime());
        conference.setEndTime(conferenceDTO.getEndTime());
        MultipartFile post= conferenceDTO.getPost();
        MultipartFile coverPhoto = conferenceDTO.getCoverPhoto();


        if (post != null && !post.isEmpty()) {
            String filePath = resourceService.storeFile(post);
            conference.setPost(filePath); // Save the file path
        }

        if (coverPhoto != null && !coverPhoto.isEmpty()) {
            String filePath = resourceService.storeFile(coverPhoto);
            conference.setCoverPhoto(filePath); // Save the file path
        }
        System.out.println(conference);
        return conferenceDayRepo.save(conference);
    }

    public List<ConferenceDayResDTO> getWorkshopSummary() {
        System.out.println(conferenceDayRepo.findWorkshopSummary());
        return conferenceDayRepo.findWorkshopSummary();
    }
    public List<ConferenceDay> getAllConferencesDays() {
        return conferenceDayRepo.findAll();
    }


    public ConferenceDay getConferenceDayById(Long id) {
        return conferenceDayRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference Day not found for ID: " + id));
    }

}
