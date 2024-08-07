package com.backend.confee.service;




import com.backend.confee.dto.Stall_spDto;
import com.backend.confee.entity.Stall_sp;
import com.backend.confee.repo.StallRepo;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import java.util.List;
//
//public interface StallService {
//    void saveStall(Stall_sp stall);
//    List<Stall_spDto> getStallsBySponsorId(String sponsorId);
//}
//@Autowired
//private StallRepository stallRepository;
//
//public List<Stall_spDto> getAllStalls() {
//    return stallRepository.findAll(); // Fetch all stalls from the repository
//}
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public abstract class StallService {
//
//    @Autowired
//    private StallRepo stallRepository;
//
//    public abstract void saveStall(Stall_sp stall);
//
//    public List<Stall_spDto> getAllStalls() {
//        return stallRepository.findAll().stream()
//                .map(this::convertToDto)
//                .collect(Collectors.toList());
//    }
//
//    private Stall_spDto convertToDto(Stall_sp stall) {
//        Stall_spDto dto = new Stall_spDto();
//        dto.setStallId(stall.getStallId()); // Use the correct getter method
//        dto.setStallName(stall.getStallName()); // Use the correct getter method
//        dto.setSponsorId(stall.getSponsorId()); // Use the correct getter method
//        return dto;
//    }
//}

public interface StallService {

    void saveStall(Stall_sp stall);

    List<Stall_spDto> getStallsBySponsorId(String sponsorId);

    List<Stall_spDto> getAllStalls();
}
