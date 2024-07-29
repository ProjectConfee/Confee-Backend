package com.backend.confee.controller;



import com.backend.confee.dto.Stall_spDto;
import com.backend.confee.entity.Stall_sp;
import com.backend.confee.service.StallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stall")
public class StallController {

    private final StallService stallService;

    @Autowired
    public StallController(StallService stallService) {
        this.stallService = stallService;
    }

    @PostMapping("/add")
    public String addStall(@RequestBody Stall_sp stall) {
        stallService.saveStall(stall);
        return "New stall is added";
    }

//    @GetMapping("/getBySponsorId/{sponsorId}")
//    public List<Stall_spDto> getStallsBySponsorId(@PathVariable String sponsorId) {
//        return stallService.getStallsBySponsorId(sponsorId);
//    }
@GetMapping("/getBySponsorId/{sponsorId}")
public List<Stall_spDto> getStallsBySponsorId(@PathVariable String sponsorId) {
    System.out.println("Received request to get stalls by sponsorId: " + sponsorId);
    return stallService.getStallsBySponsorId(sponsorId);
}
}

