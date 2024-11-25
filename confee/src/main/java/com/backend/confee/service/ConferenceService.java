package com.backend.confee.service;

import com.backend.confee.dto.ConferenceDTO;
import com.backend.confee.entity.Conference;
import com.backend.confee.repo.ConferenceRepo;
import com.backend.confee.util.VarList;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ConferenceService {

    private final ConferenceRepo conferenceRepo;

    private final ModelMapper modelMapper;

    public String saveConference(ConferenceDTO conferenceDTO){
        if (conferenceRepo.existsById(conferenceDTO.getId())){
            return VarList.RSP_DUPLICATED;
        }else {
            conferenceRepo.save(modelMapper.map(conferenceDTO, Conference.class));
            return VarList.RSP_SUCCESS;
        }

    }
}
