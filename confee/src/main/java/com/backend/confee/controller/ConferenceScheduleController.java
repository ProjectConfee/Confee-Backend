package com.backend.confee.controller;

import com.backend.confee.dto.ConferenceScheduleDTO;
import com.backend.confee.dto.DateGroupedScheduleDTO;
import com.backend.confee.dto.ScheduleDTO;
import com.backend.confee.entity.ConferenceSchedule;
import com.backend.confee.service.ConferenceScheduleService;
import com.backend.confee.service.ScheduleService;
import com.backend.confee.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/conferenceSchedules")
public class ConferenceScheduleController {

    @Autowired
    private ConferenceScheduleService conferenceScheduleService;
    @PostMapping
    public ResponseEntity<ConferenceSchedule> addConferenceSchedule(@RequestBody ConferenceScheduleDTO dto) {
        ConferenceSchedule addedSchedule = conferenceScheduleService.addConferenceSchedule(dto);
        return new ResponseEntity<>(addedSchedule, HttpStatus.CREATED);
    }

    @GetMapping("/{conferenceId}")
    public ResponseEntity<List<ConferenceSchedule>> getConferenceSchedulesByConferenceId(@PathVariable Long conferenceId) {
        List<ConferenceSchedule> schedules = conferenceScheduleService.getConferenceSchedulesByConferenceId(conferenceId);
        return ResponseEntity.ok(schedules);
    }
}

//    @GetMapping("/{workshopId}")
//    public ResponseEntity<List<DateGroupedScheduleDTO>> getSchedulesGroupedByDate(@PathVariable Long workshopId) {
//        List<DateGroupedScheduleDTO> response = conferenceScheduleService.getGroupedSchedulesByWorkshopId(workshopId);
//        return ResponseEntity.ok(response);
//    }
//}
