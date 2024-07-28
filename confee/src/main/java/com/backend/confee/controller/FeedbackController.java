package com.backend.confee.controller;



import com.backend.confee.dto.Feedback_spDTO;
import com.backend.confee.entity.Feedback_sp;
import com.backend.confee.service.Feedback_spService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private Feedback_spService feedbackService;

    @PostMapping("/add")
    public Feedback_sp addFeedback(@RequestBody Feedback_spDTO feedbackDTO) {
        return feedbackService.addFeedback(feedbackDTO);
    }

    @GetMapping("/sponsor/{sponsorId}")
    public List<Feedback_sp> getFeedbackBySponsorId(@PathVariable Long sponsorId) {
        return feedbackService.getFeedbackBySponsorId(sponsorId);
    }
}
