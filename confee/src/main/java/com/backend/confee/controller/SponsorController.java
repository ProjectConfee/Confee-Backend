package com.backend.confee.controller;

import com.backend.confee.dto.SponsorDto;
import com.backend.confee.entity.Sponsor;
import com.backend.confee.service.SponsorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/sponsor")
public class SponsorController {

    @Autowired
    private SponsorService sponsorService;

    @PostMapping("/add")
    public String addSponsor(@RequestBody Sponsor sponsor) {
        if (sponsor.getSponsorId() == null || sponsor.getSponsorId().isEmpty()) {
            return "Sponsor ID is required";
        }
        sponsorService.saveSponsor(sponsor);
        return "New sponsor is added";
    }


    @GetMapping("/getSponsorUrl/{sponsorId}")
    public Optional<SponsorDto> getSponsorUrlBySponsorId(@PathVariable String sponsorId) {
        return sponsorService.getSponsorUrlBySponsorId(sponsorId);
    }
}


