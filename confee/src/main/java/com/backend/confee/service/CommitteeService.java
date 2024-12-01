package com.backend.confee.service;

import com.backend.confee.dto.CommitteeDTO;
import com.backend.confee.entity.AllUsers;
import com.backend.confee.entity.Committee;
import com.backend.confee.repo.AllUsersRepo;
import com.backend.confee.repo.CommitteeRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class CommitteeService {

    @Autowired
    private CommitteeRepo committeeRepo;

    @Autowired
    private AllUsersRepo allUsersRepo;

    @Autowired
    private ModelMapper modelMapper;

//    public CommitteeDTO saveCommittee(CommitteeDTO committeeDTO) {
//        committeeRepo.save(modelMapper.map(committeeDTO, Committee.class));
//        return committeeDTO;
//    }

    public CommitteeDTO saveCommittee(CommitteeDTO committeeDTO) {
        // Check if the user already exists in the AllUsers table by email
        Optional<AllUsers> existingUserOptional = allUsersRepo.findByEmail(committeeDTO.getEmail());

        if (existingUserOptional.isPresent()) {
            // If the user exists, update their role to "committee"
            AllUsers existingUser = existingUserOptional.get();
            existingUser.setRole("COMMITTEE");
            allUsersRepo.save(existingUser); // Save the updated user
        } else {
            // If the user doesn't exist, optionally add them to the AllUsers table
            AllUsers newUser = new AllUsers();
            newUser.setEmail(committeeDTO.getEmail());
            newUser.setRole("COMMITTEE");
            allUsersRepo.save(newUser); // Save the new user
        }

        // Save the committee member in the Committee table
        committeeRepo.save(modelMapper.map(committeeDTO, Committee.class));
        return committeeDTO;
    }

    public List<CommitteeDTO> getAllCommittee() {
        List<Committee> committeeList = committeeRepo.findAll();
        return modelMapper.map(committeeList, new TypeToken<List<CommitteeDTO>>() {}.getType());
    }

    public CommitteeDTO updateCommittee(CommitteeDTO committeeDTO) {
        committeeRepo.save(modelMapper.map(committeeDTO, Committee.class));
        return committeeDTO;
    }

    public boolean deleteCommittee(CommitteeDTO committeeDTO) {
        committeeRepo.delete(modelMapper.map(committeeDTO, Committee.class));
        return true;
    }
}
