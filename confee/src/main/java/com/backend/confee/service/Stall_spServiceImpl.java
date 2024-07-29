package com.backend.confee.service;



import com.backend.confee.dto.Stall_spDto;
import com.backend.confee.entity.Stall_sp;
import com.backend.confee.repo.StallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Stall_spServiceImpl implements StallService {

    private StallRepo stallRepository;

    @Autowired
    public void StallServiceImpl(StallRepo stallRepository) {
        this.stallRepository = stallRepository;
    }

    public Stall_spServiceImpl(StallRepo stallRepository) {
        this.stallRepository = stallRepository;
    }

    @Override
    public void saveStall(Stall_sp stall) {
        stallRepository.save(stall);
    }



    @Override
    public List<Stall_spDto> getStallsBySponsorId(String sponsorId) {
        return stallRepository.findBySponsorId(sponsorId)
                .stream()
                .map(stall -> {
                    Stall_spDto stallDto = new Stall_spDto();
                    stallDto.setStallId(stall.getStallId());
                    stallDto.setStallName(stall.getStallName());
                    return stallDto;
                })
                .collect(Collectors.toList());
    }
}

