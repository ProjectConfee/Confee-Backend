package com.backend.confee.service;

import com.backend.confee.dto.Stall_spDto;
import com.backend.confee.entity.Stall_sp;
import com.backend.confee.repo.StallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class StallServiceImpl extends StallService {
//
//    private StallRepo stallRepository;
//
//    @Autowired
//    public void Stall_spServiceImpl(StallRepo stallRepository) {
//        this.stallRepository = stallRepository;
//    }
//
//    public StallServiceImpl(StallRepo stallRepository) {
//        this.stallRepository = stallRepository;
//    }
//
//    public void saveStall(Stall_sp stall) {
//        stallRepository.save(stall);
//    }
//
//    public List<Stall_spDto> getStallsBySponsorId(String sponsorId) {
//        return stallRepository.findBySponsorId(sponsorId)
//                .stream()
//                .map(stall -> {
//                    Stall_spDto stallDto = new Stall_spDto();
//                    stallDto.setStallId(stall.getStallId());
//                    stallDto.setStallName(stall.getStallName());
//                    stallDto.setSponsorId(stall.getSponsorId());
//                    return stallDto;
//                })
//                .collect(Collectors.toList());
//    }
//}


@Service
public class StallServiceImpl implements StallService {

    private final StallRepo stallRepository;

    @Autowired
    public StallServiceImpl(StallRepo stallRepository) {
        this.stallRepository = stallRepository;
    }

    @Override
    public void saveStall(Stall_sp stall) {
        stallRepository.save(stall);
    }


    public List<Stall_spDto> getStallsBySponsorId(String sponsorId) {
        return stallRepository.findBySponsorId(sponsorId)
                .stream()
                .map(stall -> {
                    Stall_spDto stallDto = new Stall_spDto();
                    stallDto.setStallId(stall.getStallId());
                    stallDto.setStallName(stall.getStallName());
                    stallDto.setSponsorId(stall.getSponsorId());
                    return stallDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Stall_spDto> getAllStalls() {
        return stallRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private Stall_spDto convertToDto(Stall_sp stall) {
        Stall_spDto dto = new Stall_spDto();
        dto.setStallId(stall.getStallId());
        dto.setStallName(stall.getStallName());
        dto.setSponsorId(stall.getSponsorId());
        return dto;
    }
}
