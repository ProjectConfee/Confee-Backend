package com.backend.confee.service;

import com.backend.confee.dto.CommitteeDTO;
import com.backend.confee.entity.Committee;
import com.backend.confee.repo.CommitteeRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
