package com.backend.confee.repo;

import com.backend.confee.entity.ParticipantFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantFeedbackRepo extends JpaRepository<ParticipantFeedback, Integer> {
//    List<ParticipantFeedback> findByParticipantId(Long participantId);
}
