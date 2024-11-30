package com.backend.confee.service;

import com.backend.confee.dto.SpeakersDTO;
import com.backend.confee.entity.AllUsers;
import com.backend.confee.entity.Speakers;
import com.backend.confee.repo.AllUsersRepo;
import com.backend.confee.repo.SpeakersRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class SpeakersService {

    @Autowired
    private SpeakersRepo speakersRepo;

    @Autowired
    private AllUsersRepo allUsersRepo;

    @Autowired
    private ModelMapper modelMapper;

//    public SpeakersDTO saveSpeakers(SpeakersDTO speakersDTO) {
//        speakersRepo.save(modelMapper.map(speakersDTO, Speakers.class));
//        return speakersDTO;
//    }

    public SpeakersDTO saveSpeakers(SpeakersDTO speakersDTO) {
        // Check if the user already exists in the AllUsers table by email
        Optional<AllUsers> existingUserOptional = allUsersRepo.findByEmail(speakersDTO.getEmail());

        if (existingUserOptional.isPresent()) {
            // If the user exists, update their role to "speaker"
            AllUsers existingUser = existingUserOptional.get();
            existingUser.setRole("SPEAKER");
            allUsersRepo.save(existingUser); // Save the updated user
        } else {
            // If the user doesn't exist, optionally add them to the AllUsers table
            AllUsers newUser = new AllUsers();
            newUser.setEmail(speakersDTO.getEmail());
            newUser.setRole("SPEAKER");
            allUsersRepo.save(newUser); // Save the new user
        }

        // Save the committee member in the Committee table
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
