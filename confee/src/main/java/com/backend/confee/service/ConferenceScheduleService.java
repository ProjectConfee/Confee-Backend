package com.backend.confee.service;

import com.backend.confee.dto.ConferenceScheduleDTO;
import com.backend.confee.dto.ScheduleDTO;
import com.backend.confee.entity.ConferenceSchedule;
import com.backend.confee.entity.Schedule;
import com.backend.confee.entity.WorkshopDay;
import com.backend.confee.repo.ConferenceScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceScheduleService {
    @Autowired
    private ConferenceScheduleRepo scheduleRepository;


    public ConferenceSchedule addConferenceSchedule(ConferenceScheduleDTO dto) {
        ConferenceSchedule conferenceSchedule = new ConferenceSchedule();
        conferenceSchedule.setEvent(dto.getEvent());
        conferenceSchedule.setStartTime(dto.getStartTime());
        conferenceSchedule.setStatus("Pending");
        conferenceSchedule.setConferenceId(dto.getConferenceId());
        return scheduleRepository.save(conferenceSchedule);
    }


    public List<ConferenceSchedule> getConferenceSchedulesByConferenceId(Long conferenceId) {
        return scheduleRepository.findByConferenceId(conferenceId);
    }
}
