package com.backend.confee.service;

import com.backend.confee.dto.ParticipantFeedbackDTO;
import com.backend.confee.entity.ParticipantFeedback;
import com.backend.confee.repo.ParticipantFeedbackRepo;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class ParticipantFeedbackService {

    @Autowired
    private ParticipantFeedbackRepo participantFeedbackRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ParticipantFeedbackDTO saveParticipantFeedback(ParticipantFeedbackDTO participantFeedbackDTO) {
        participantFeedbackRepo.save(modelMapper.map(participantFeedbackDTO, ParticipantFeedback.class));
        return participantFeedbackDTO;
    }
}
