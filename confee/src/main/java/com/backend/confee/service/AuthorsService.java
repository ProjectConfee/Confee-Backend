package com.backend.confee.service;

import com.backend.confee.dto.AuthorsDTO;
import com.backend.confee.entity.Authors;
import com.backend.confee.repo.AuthorsRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class AuthorsService {

    @Autowired
    private AuthorsRepo authorsRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AuthorsDTO saveAuthors(AuthorsDTO authorsDTO) {
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
