package com.backend.confee.service;

import com.backend.confee.dto.ConferenceDTO;
import com.backend.confee.entity.Conference;
import com.backend.confee.repo.ConferenceRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Service
public class ConferenceService {

    private final ConferenceRepo conferenceRepo;
    private final ResourceService resourceService;
    private final ModelMapper modelMapper;

    public ConferenceService(ConferenceRepo conferenceRepo, ResourceService resourceService, ModelMapper modelMapper) {
        this.conferenceRepo = conferenceRepo;
        this.resourceService = resourceService;
        this.modelMapper = modelMapper;
    }
    public Conference saveConference(ConferenceDTO conferenceDTO) throws IOException {


            Conference conference = new Conference();
            conference.setStartDate(conferenceDTO.getStartDate());
            conference.setEndDate(conferenceDTO.getEndDate());
            MultipartFile logo = conferenceDTO.getLogo();
            if (logo != null && !logo.isEmpty()) {
                String filePath = resourceService.storeFile(logo);
                conference.setLogo(filePath); // Save the file path
            }
            return conferenceRepo.save(conference);
    }

    public List<Conference> getAllConferences() {
        return conferenceRepo.findAll();
    }




//    private ConferenceDTO convertToDTO(Conference conference) {
//        ConferenceDTO dto = new ConferenceDTO();
//        dto.setId(conference.getId());
//        dto.setStartDate(conference.getStartDate());
//        dto.setEndDate(conference.getEndDate());
//        dto.setLogo(conference.getLogo()); // Assuming `logo` is a String path in the Conference entity
//        return dto;
//    }
}
