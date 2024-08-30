//package com.backend.confee.controller;
//
//
//
//
//import com.backend.confee.dto.Announcement_spDTO;
//import com.backend.confee.entity.Announcement_sp;
//import com.backend.confee.service.AnnouncementService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/announcements")
//public class Announcement_spController {
//
//    @Autowired
//    private AnnouncementService announcementService;
//
//    @PostMapping("/add")
//    public String addAnnouncement(@RequestBody Announcement_spDTO announcementDTO) {
//        announcementService.addAnnouncement(announcementDTO);
//        return "added sucessfully";
//    }
//
//    @GetMapping("/all")
//    public List<Announcement_sp> getAllAnnouncements() {
//        return announcementService.getAllAnnouncements();
//    }
//}
//package com.backend.confee.controller;
//
//import com.backend.confee.dto.Announcement_spDTO;
//import com.backend.confee.entity.Announcement_sp;
//import com.backend.confee.service.AnnouncementService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//@CrossOrigin(origins = "http://localhost:5173")
//@RestController
//@RequestMapping("api/announcements")
//public class Announcement_spController {
//
//    @Autowired
//    private AnnouncementService announcementService;

//    @PostMapping("/add")
//    public String addAnnouncement(@RequestBody Announcement_spDTO announcementDTO) {
//        announcementService.addAnnouncement(announcementDTO);
//        announcementDTO.setTimestamp(LocalDateTime.now());
//        return "Added successfully";
//    }
//@PostMapping("/add")
//public String addAnnouncement(@RequestBody Announcement_spDTO announcementDTO) {
//    Announcement_sp announcement = new Announcement_sp();
//    announcement.setAnnouncement(announcementDTO.getAnnouncement());
//    announcement.setTimestamp(String.valueOf(LocalDateTime.now())); // Sets the current time
//    announcementService.addAnnouncement(announcementDTO);
//    return "Added successfully";
//}
//
//
//    @GetMapping("/getAll")
//    public List<Announcement_sp> getAllAnnouncements() {
//        return announcementService.getAllAnnouncements();
//    }
//}


//    public class Announcement_spController {
//
//        @Autowired
//        private AnnouncementService announcementService;
//
//        @PostMapping("/add")
//        public ResponseEntity<String> addAnnouncement(@RequestBody Announcement_spDTO announcementDTO) {
//            try {
//                // Set the timestamp to the current time
//                Announcement_sp announcement = new Announcement_sp();
//                announcement.setAnnouncement(announcementDTO.getAnnouncement());
//                announcement.setTimestamp(String.valueOf(LocalDateTime.now()));
//
//                announcementService.addAnnouncement(announcementDTO);
//                return ResponseEntity.ok("Added successfully");
//            } catch (Exception e) {
//                e.printStackTrace();
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add announcement");
//            }
//        }
//
//        @GetMapping("/getAll")
//        public ResponseEntity<?> getAllAnnouncements() {
//            try {
//                List<Announcement_sp> announcements = announcementService.getAllAnnouncements();
//                return ResponseEntity.ok(announcements);
//            } catch (Exception e) {
//                e.printStackTrace();
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching announcements");
//            }
//        }
//    }
//
package com.backend.confee.controller;

import com.backend.confee.dto.Announcement_spDTO;
import com.backend.confee.entity.Announcement_sp;
import com.backend.confee.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/announcements")
public class Announcement_spController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("/add")
    public ResponseEntity<String> addAnnouncement(@RequestBody Announcement_spDTO announcementDTO) {
        try {
            announcementService.addAnnouncement(announcementDTO);
            return ResponseEntity.ok("Added successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add announcement");
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllAnnouncements() {
        try {
            List<Announcement_sp> announcements = announcementService.getAllAnnouncements();
            return ResponseEntity.ok(announcements);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching announcements");
        }
    }
}
