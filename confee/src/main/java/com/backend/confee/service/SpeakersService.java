package com.backend.confee.service;

import com.backend.confee.dto.SpeakersDTO;
import com.backend.confee.entity.Speakers;
import com.backend.confee.repo.SpeakersRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<SpeakersDTO> getAllSpeakers() {
        List<Speakers> speakersList = speakersRepo.findAll();
        return modelMapper.map(speakersList, new TypeToken<List<SpeakersDTO>>() {}.getType());
    }

    public SpeakersDTO updateSpeakers(SpeakersDTO speakersDTO) {
        speakersRepo.save(modelMapper.map(speakersDTO, Speakers.class));
        return speakersDTO;
    }

    public boolean deleteSpeakers(SpeakersDTO speakersDTO) {
        speakersRepo.delete(modelMapper.map(speakersDTO, Speakers.class));
        return true;
    }

}
