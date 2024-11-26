package com.backend.confee.controller;


import com.backend.confee.dto.Announcement_spDTO;
import com.backend.confee.entity.Announcement_sp;
import com.backend.confee.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/userProfiles")

public class UserProfileController {
    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("/add")
    public ResponseEntity<String> addUserProfile(@RequestBody Announcement_spDTO announcementDTO) {
        try {
            announcementService.addAnnouncement(announcementDTO);
            return ResponseEntity.ok("Added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add announcement");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getProfileDetails() {
        try {
            List<Announcement_sp> announcements = announcementService.getAllAnnouncements();
            return ResponseEntity.ok(announcements);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching announcements");
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAnnouncement(@PathVariable("id") Long id, @RequestBody Announcement_spDTO announcementDTO) {
        try {
            boolean updated = announcementService.updateAnnouncement(id, announcementDTO);
            if (updated) {
                return ResponseEntity.ok("Updated successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Announcement not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update announcement");
        }
    }


}
