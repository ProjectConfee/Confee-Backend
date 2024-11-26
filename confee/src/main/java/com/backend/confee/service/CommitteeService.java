package com.backend.confee.service;

import com.backend.confee.dto.CommitteeDTO;
import com.backend.confee.entity.Committee;
import com.backend.confee.repo.CommitteeRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class CommitteeService {

    @Autowired
    private CommitteeRepo committeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public CommitteeDTO saveCommittee(CommitteeDTO committeeDTO) {
        committeeRepo.save(modelMapper.map(committeeDTO, Committee.class));
        return committeeDTO;
    }
}
