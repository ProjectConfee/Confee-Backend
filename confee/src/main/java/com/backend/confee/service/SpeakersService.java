package com.backend.confee.service;

import com.backend.confee.dto.SpeakersDTO;
import com.backend.confee.entity.Speakers;
import com.backend.confee.repo.SpeakersRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class SpeakersService {

    @Autowired
    private SpeakersRepo speakersRepo;

    @Autowired
    private ModelMapper modelMapper;

    public SpeakersDTO saveSpeakers(SpeakersDTO speakersDTO) {
        speakersRepo.save(modelMapper.map(speakersDTO, Speakers.class));
        return speakersDTO;
    }
}
