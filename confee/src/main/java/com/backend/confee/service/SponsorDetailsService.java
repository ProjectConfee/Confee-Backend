package com.backend.confee.service;

import com.backend.confee.dto.SpeakersDTO;
import com.backend.confee.dto.SponsorDetailsDTO;
import com.backend.confee.entity.AllUsers;
import com.backend.confee.entity.Speakers;
import com.backend.confee.entity.SponsorDetails;
import com.backend.confee.repo.AllUsersRepo;
import com.backend.confee.repo.SponsorDetailsRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class SponsorDetailsService {

    @Autowired
    private SponsorDetailsRepo sponsorDetailsRepo;

    @Autowired
    private AllUsersRepo allUsersRepo;

    @Autowired
    private ModelMapper modelMapper;

//    public SponsorDetailsDTO saveSponsorDetails(SponsorDetailsDTO sponsorDetailsDTO) {
//        sponsorDetailsRepo.save(modelMapper.map(sponsorDetailsDTO, SponsorDetails.class));
//        return sponsorDetailsDTO;
//    }

    public SponsorDetailsDTO saveSponsorDetails(SponsorDetailsDTO sponsorDetailsDTO) {
        // Check if the user already exists in the AllUsers table by email
        Optional<AllUsers> existingUserOptional = allUsersRepo.findByEmail(sponsorDetailsDTO.getEmail());

        if (existingUserOptional.isPresent()) {
            // If the user exists, update their role to "speaker"
            AllUsers existingUser = existingUserOptional.get();
            existingUser.setRole("SPONSOR");
            allUsersRepo.save(existingUser); // Save the updated user
        } else {
            // If the user doesn't exist, optionally add them to the AllUsers table
            AllUsers newUser = new AllUsers();
            newUser.setEmail(sponsorDetailsDTO.getEmail());
            newUser.setRole("SPONSOR");
            allUsersRepo.save(newUser); // Save the new user
        }

        // Save the committee member in the Committee table
        sponsorDetailsRepo.save(modelMapper.map(sponsorDetailsDTO, SponsorDetails.class));
        return sponsorDetailsDTO;
    }

    public List<SponsorDetailsDTO> getAllSponsorDetails() {
        List<SponsorDetails> sponsorDetailsList = sponsorDetailsRepo.findAll();
        return modelMapper.map(sponsorDetailsList, new TypeToken<List<SponsorDetailsDTO>>() {}.getType());
    }

    public SponsorDetailsDTO updateSponsorDetails(SponsorDetailsDTO sponsorDetailsDTO) {
        sponsorDetailsRepo.save(modelMapper.map(sponsorDetailsDTO, SponsorDetails.class));
        return sponsorDetailsDTO;
    }

    public boolean deleteSponsorDetails(SponsorDetailsDTO sponsorDetailsDTO) {
        sponsorDetailsRepo.delete(modelMapper.map(sponsorDetailsDTO, SponsorDetails.class));
        return true;
    }

}
