package com.backend.confee.service;

import com.backend.confee.dto.ScheduleDTO;
import com.backend.confee.entity.Schedule;
import com.backend.confee.entity.WorkshopDay;
import com.backend.confee.repo.ScheduleRepo;
import com.backend.confee.repo.WorkshopDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepository;

    @Autowired
    private WorkshopDayRepo workshopDayRepository;

    public ScheduleDTO addSchedule(ScheduleDTO scheduleDTO) {
        WorkshopDay workshopDay = workshopDayRepository.findById(scheduleDTO.getWorkshopDayId())
                .orElseThrow(() -> new RuntimeException("Workshop day not found"));

        Schedule schedule = new Schedule();
        schedule.setStartTime(scheduleDTO.getStartTime());
        schedule.setEvent(scheduleDTO.getEvent());
        schedule.setStatus("Pending");
        schedule.setWorkshopDay(workshopDay);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        scheduleDTO.setId(savedSchedule.getId()); // Return the saved ID
        return scheduleDTO;
    }
}
