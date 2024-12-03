package com.backend.confee.controller;

import com.backend.confee.dto.DateGroupedScheduleDTO;
import com.backend.confee.dto.ScheduleDTO;
import com.backend.confee.entity.ConferenceDay;
import com.backend.confee.entity.WorkshopDay;
import com.backend.confee.service.ScheduleService;
import com.backend.confee.service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    private WorkshopService workshopDayService;

    @PostMapping
    public ResponseEntity<ScheduleDTO> addSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        ScheduleDTO savedSchedule = scheduleService.addSchedule(scheduleDTO);
        return ResponseEntity.ok(savedSchedule);
    }

    @GetMapping("/{workshopId}")
    public ResponseEntity<List<DateGroupedScheduleDTO>> getSchedulesGroupedByDate(@PathVariable Long workshopId) {
        List<DateGroupedScheduleDTO> response = scheduleService.getGroupedSchedulesByWorkshopId(workshopId);
        return ResponseEntity.ok(response);
    }



}
