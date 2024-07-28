package com.backend.confee.service;




import com.backend.confee.dto.Feedback_spDTO;
import com.backend.confee.entity.Feedback_sp;

import java.util.List;

public interface Feedback_spService {
    Feedback_sp addFeedback(Feedback_spDTO feedbackDTO);
    List<Feedback_sp> getFeedbackBySponsorId(Long sponsorId);
}

