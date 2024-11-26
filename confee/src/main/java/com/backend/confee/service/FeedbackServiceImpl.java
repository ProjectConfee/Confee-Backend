package com.backend.confee.service;




import com.backend.confee.dto.Feedback_spDTO;
import com.backend.confee.entity.Feedback_sp;
import com.backend.confee.repo.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements Feedback_spService {

    @Autowired
    private FeedbackRepo feedbackRepository;

    @Override
    public Feedback_sp addFeedback(Feedback_spDTO feedbackDTO) {
        Feedback_sp feedback = new Feedback_sp();
        feedback.setParticipantId(feedbackDTO.getParticipantId());
        feedback.setSponsorId(feedbackDTO.getSponsorId());
        feedback.setRate(feedbackDTO.getRate());
        feedback.setFeedback(feedbackDTO.getFeedback());
        return feedbackRepository.save(feedback);
    }

//    @Override
//    public Feedback_sp addFeedback(Feedback_spDTO feedbackDTO) {
//        return null;
//    }

    @Override
    public List<Feedback_sp> getFeedbackBySponsorId(Long sponsorId) {
        return feedbackRepository.findBySponsorId(sponsorId);
    }
}

