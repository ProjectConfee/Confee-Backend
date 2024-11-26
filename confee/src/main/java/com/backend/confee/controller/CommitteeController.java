package com.backend.confee.controller;

import com.backend.confee.dto.CommitteeDTO;
import com.backend.confee.service.CommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/committee")
@CrossOrigin

public class CommitteeController {

    @Autowired
    private CommitteeService committeeService;

    @PostMapping("/saveCommittee")
    public CommitteeDTO saveCommittee(@RequestBody CommitteeDTO committeeDTO) {
        return committeeService.saveCommittee(committeeDTO);
    }
}
