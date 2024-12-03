package com.backend.confee.service;

import com.backend.confee.dto.AuthorsDTO;
import com.backend.confee.entity.AllUsers;
import com.backend.confee.entity.Authors;
import com.backend.confee.repo.AllUsersRepo;
import com.backend.confee.repo.AuthorsRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class AuthorsService {

    @Autowired
    private AuthorsRepo authorsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AllUsersRepo allUsersRepo;

//    public AuthorsDTO saveAuthors(AuthorsDTO authorsDTO) {
//        authorsRepo.save(modelMapper.map(authorsDTO, Authors.class));
//        return authorsDTO;
//    }

    public AuthorsDTO saveAuthors(AuthorsDTO authorsDTO) {
        // Check if the user already exists in the AllUsers table by email
        Optional<AllUsers> existingUserOptional = allUsersRepo.findByEmail(authorsDTO.getEmail());

        if (existingUserOptional.isPresent()) {
            // If the user exists, update their role to "author"
            AllUsers existingUser = existingUserOptional.get();
            existingUser.setRole("AUTHOR");
            allUsersRepo.save(existingUser); // Save the updated user
        } else {
            // If the user doesn't exist, optionally add them to the AllUsers table
            AllUsers newUser = new AllUsers();
            newUser.setEmail(authorsDTO.getEmail());
            newUser.setRole("AUTHOR");
            allUsersRepo.save(newUser); // Save the new user
        }

        // Save the author in the Authors table
        authorsRepo.save(modelMapper.map(authorsDTO, Authors.class));
        return authorsDTO;
    }

    public List<AuthorsDTO> getAllAuthors() {
        List<Authors> authorsList = authorsRepo.findAll();
        return modelMapper.map(authorsList, new TypeToken<List<AuthorsDTO>>() {}.getType());
    }

    public AuthorsDTO updateAuthors(AuthorsDTO authorsDTO) {
        authorsRepo.save(modelMapper.map(authorsDTO, Authors.class));
        return authorsDTO;
    }

    public boolean deleteAuthors(AuthorsDTO authorsDTO) {
        authorsRepo.delete(modelMapper.map(authorsDTO, Authors.class));
        return true;
    }

}
