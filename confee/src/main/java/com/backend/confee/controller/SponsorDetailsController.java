package com.backend.confee.controller;

import com.backend.confee.dto.SponsorDetailsDTO;
import com.backend.confee.service.SponsorDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/sponsorDetails")
@CrossOrigin

public class SponsorDetailsController {

    @Autowired
    private SponsorDetailsService sponsorDetailsService;

    @GetMapping("/getSponsorDetails")
    public List<SponsorDetailsDTO> getSponsorDetails() {
        return sponsorDetailsService.getAllSponsorDetails();
    }

    @PostMapping("/saveSponsorDetails")
    public SponsorDetailsDTO saveSponsorDetails(@RequestBody SponsorDetailsDTO sponsorDetailsDTO) {
        return sponsorDetailsService.saveSponsorDetails(sponsorDetailsDTO);
    }

    @PutMapping("updateSponsorDetails")
    public SponsorDetailsDTO updateSponsorDetails(@RequestBody SponsorDetailsDTO sponsorDetailsDTO) {
        return sponsorDetailsService.updateSponsorDetails(sponsorDetailsDTO);
    }

    @DeleteMapping("/deleteSponsorDetails")
    public boolean deleteSponsorDetails(@RequestBody SponsorDetailsDTO sponsorDetailsDTO) {
        return sponsorDetailsService.deleteSponsorDetails(sponsorDetailsDTO);
    }

}
