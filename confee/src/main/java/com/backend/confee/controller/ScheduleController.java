package com.backend.confee.controller;

import com.backend.confee.dto.ScheduleDTO;
import com.backend.confee.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleDTO> addSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        scheduleService.addSchedule(scheduleDTO);
        ScheduleDTO savedSchedule = scheduleService.addSchedule(scheduleDTO);
        return ResponseEntity.ok(savedSchedule);
    }
}
