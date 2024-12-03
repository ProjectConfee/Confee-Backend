package com.backend.confee.controller;

import com.backend.confee.dto.*;
import com.backend.confee.entity.ConferenceDay;
import com.backend.confee.repo.ConferenceDayRepo;
import com.backend.confee.service.ConferenceDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/admin/conference")
@CrossOrigin
@RequiredArgsConstructor()
public class ConferenceDayController {

    private final ConferenceDayService conferenceDayService;
    private ConferenceDayRepo conferenceDayRepo;

    private final ResponseDTO responseDTO;

    @PostMapping("/saveConferenceDay")
    public ResponseEntity<ConferenceDay> createConference(
            @RequestParam("title") String title,
            @RequestParam("investment") Double investment,
            @RequestParam("date") LocalDate date,
            @RequestParam("startTime") LocalTime startTime,
            @RequestParam("endTime") LocalTime endTime,
            @RequestParam("location") String location,
            @RequestParam("mapLink") String mapLink,
            @RequestParam("lunch") Boolean lunch,
            @RequestParam("post") MultipartFile post,
            @RequestParam("coverPhoto") MultipartFile coverPhoto
            ) throws IOException {

            ConferenceDayDTO conferenceDayDTO = new ConferenceDayDTO();
            conferenceDayDTO.setTitle(title);
            conferenceDayDTO.setInvestment(investment);
            conferenceDayDTO.setDate(date);
            conferenceDayDTO.setStartTime(startTime);
            conferenceDayDTO.setEndTime(endTime);
            conferenceDayDTO.setLocation(location);
            conferenceDayDTO.setMapLink(mapLink);
            conferenceDayDTO.setLunch(lunch);
            conferenceDayDTO.setPost(post);
            conferenceDayDTO.setCoverPhoto(coverPhoto);

            ConferenceDay created = conferenceDayService.saveConferenceDay(conferenceDayDTO);
            return ResponseEntity.ok(created);

    }

    @GetMapping("/all")
    public ResponseEntity<List<ConferenceDay>> getAllConferencesDays() {
        List<ConferenceDay> conferences = conferenceDayService.getAllConferencesDays();
        return ResponseEntity.ok(conferences);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<ConferenceDay> getConferenceDayById(@PathVariable Long id) {
        ConferenceDay conferenceDay = conferenceDayService.getConferenceDayById(id);
        return ResponseEntity.ok(conferenceDay);
    }
}



