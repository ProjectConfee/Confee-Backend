package com.backend.confee.service;

import com.backend.confee.dto.DateGroupedScheduleDTO;
import com.backend.confee.dto.ScheduleDTO;
import com.backend.confee.entity.Schedule;
import com.backend.confee.entity.WorkshopDay;
import com.backend.confee.repo.ScheduleRepo;
import com.backend.confee.repo.WorkshopDayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

//    public List<DateGroupedScheduleDTO> getGroupedSchedulesByWorkshopId(Long workshopId) {
//        // Fetch schedules from the repository
//        List<ScheduleDTO> schedules = scheduleRepository.findSchedulesByWorkshopId(workshopId)
//                .stream()
//                .map(schedule -> new ScheduleDTO(
//                        schedule.getId(),
//                        schedule.getEvent(),
//                        schedule.getStartTime(),
//                        schedule.getStatus(),
//                        schedule.getWorkshopDay().getId()
//                ))
//                .collect(Collectors.toList());
//
//        if (schedules.isEmpty()) {
//            return null; // Return null if no schedules are found
//        }
//
//        // Group schedules by date
//        Map<Integer, Map<String, List<ScheduleDTO>>> groupedByWorkshopDayIdAndDate = schedules.stream()
//                .collect(Collectors.groupingBy(
//                        ScheduleDTO::getWorkshopDayId, // Group by WorkshopDay ID
//                        Collectors.groupingBy(dto -> {
//                            WorkshopDay workshopDay = scheduleRepository.findWorkshopDayById(dto.getWorkshopDayId());
//                            return workshopDay.getDate().toString(); // Group by Date
//                        })
//                ));
//
//        // Map to grouped DTO
//        List<DateGroupedScheduleDTO> response = new ArrayList<>();
//        groupedByWorkshopDayIdAndDate.forEach((workshopDayId, groupedByDate) -> {
//            groupedByDate.forEach((date, events) -> {
//                response.add(new DateGroupedScheduleDTO(workshopDayId, date, events));
//            });
//        });
//
//        return response;
//    }

    public List<DateGroupedScheduleDTO> getGroupedSchedulesByWorkshopId(Long workshopId) {
    // Fetch all WorkshopDays for the workshop
    List<WorkshopDay> workshopDays = workshopDayRepository.findWorkshopDaysByWorkshopId(workshopId);
    if (workshopDays.isEmpty()) {
        return Collections.emptyList(); // Return an empty list if no WorkshopDays are found
    }

    // Fetch schedules for the given Workshop ID
    List<ScheduleDTO> schedules = scheduleRepository.findSchedulesByWorkshopId(workshopId)
            .stream()
            .map(schedule -> new ScheduleDTO(
                    schedule.getId(),
                    schedule.getEvent(),
                    schedule.getStartTime(),
                    schedule.getStatus(),
                    schedule.getWorkshopDay().getId()
            ))
            .collect(Collectors.toList());

    // Group schedules by WorkshopDay ID and Date
    Map<Integer, Map<String, List<ScheduleDTO>>> groupedByWorkshopDayIdAndDate = schedules.stream()
            .collect(Collectors.groupingBy(
                    ScheduleDTO::getWorkshopDayId, // Group by WorkshopDay ID
                    Collectors.groupingBy(dto -> {
                        WorkshopDay workshopDay = scheduleRepository.findWorkshopDayById(dto.getWorkshopDayId());
                        return workshopDay.getDate().toString(); // Group by Date
                    })
            ));

    // Add missing WorkshopDays with empty schedule lists
    List<DateGroupedScheduleDTO> response = new ArrayList<>();
    for (WorkshopDay workshopDay : workshopDays) {
        String workshopDate = workshopDay.getDate().toString();
        int workshopDayId = workshopDay.getId();

        // Check if the workshopDayId is already present
        if (!groupedByWorkshopDayIdAndDate.containsKey(workshopDayId)) {
            // Add a new DateGroupedScheduleDTO with an empty list of events
            response.add(new DateGroupedScheduleDTO(workshopDayId, workshopDate, Collections.emptyList()));
        } else {
            // Map the existing grouped schedules
            Map<String, List<ScheduleDTO>> groupedByDate = groupedByWorkshopDayIdAndDate.get(workshopDayId);
            groupedByDate.forEach((date, events) -> {
                response.add(new DateGroupedScheduleDTO(workshopDayId, date, events));
            });
        }
    }

    return response;
}

}
