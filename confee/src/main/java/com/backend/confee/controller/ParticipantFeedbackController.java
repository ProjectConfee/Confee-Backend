package com.backend.confee.controller;

import com.backend.confee.dto.ParticipantFeedbackDTO;
import com.backend.confee.service.ParticipantFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/participantFeedback")
@CrossOrigin

public class ParticipantFeedbackController {
    @Autowired
    private ParticipantFeedbackService participantFeedbackService;

    @GetMapping("/getParticipantFeedback")
    public List<ParticipantFeedbackDTO> getParticipantFeedback() {
        return participantFeedbackService.getAllParticipantFeedback();
    }

    @PostMapping("/saveParticipantFeedback")
    public ParticipantFeedbackDTO saveParticipantFeedback(@RequestBody ParticipantFeedbackDTO participantFeedbackDTO) {
        return participantFeedbackService.saveParticipantFeedback(participantFeedbackDTO);
    }
}
