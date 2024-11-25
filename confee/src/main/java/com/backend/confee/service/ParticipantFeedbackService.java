package com.backend.confee.service;

import com.backend.confee.dto.ParticipantFeedbackDTO;
import com.backend.confee.entity.ParticipantFeedback;
import com.backend.confee.repo.ParticipantFeedbackRepo;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<ParticipantFeedbackDTO> getAllParticipantFeedback() {
        List<ParticipantFeedback> participantFeedbackList = participantFeedbackRepo.findAll();
        return modelMapper.map(participantFeedbackList, new TypeToken<List<ParticipantFeedbackDTO>>() {}.getType());
    }

    public ParticipantFeedbackDTO updateParticipantFeedback(ParticipantFeedbackDTO participantFeedbackDTO) {
        participantFeedbackRepo.save(modelMapper.map(participantFeedbackDTO, ParticipantFeedback.class));
        return participantFeedbackDTO;
    }

    public boolean deleteParticipantFeedback(ParticipantFeedbackDTO participantFeedbackDTO) {
        participantFeedbackRepo.delete(modelMapper.map(participantFeedbackDTO, ParticipantFeedback.class));
        return true;
    }
}
