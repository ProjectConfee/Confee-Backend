////
////package com.backend.confee.controller;
////
////import com.backend.confee.dto.Announcement_spDTO;
////import com.backend.confee.entity.Announcement_sp;
////import com.backend.confee.service.AnnouncementService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.web.bind.annotation.*;
////
////import java.util.List;
////
////@CrossOrigin(origins = "http://localhost:5173")
////@RestController
////@RequestMapping("api/announcements")
////public class Announcement_spController {
////
////    @Autowired
////    private AnnouncementService announcementService;
////
////    @PostMapping("/add")
////    public ResponseEntity<String> addAnnouncement(@RequestBody Announcement_spDTO announcementDTO) {
////        try {
////            announcementService.addAnnouncement(announcementDTO);
////            return ResponseEntity.ok("Added successfully");
////        } catch (Exception e) {
////            e.printStackTrace();
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add announcement");
////        }
////    }
////
////    @GetMapping("/getAll")
////    public ResponseEntity<?> getAllAnnouncements() {
////        try {
////            List<Announcement_sp> announcements = announcementService.getAllAnnouncements();
////            return ResponseEntity.ok(announcements);
////        } catch (Exception e) {
////            e.printStackTrace();
////            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching announcements");
////        }
////    }
////}
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
//import java.util.List;
//
//@CrossOrigin(origins = "*")
//@RestController
//@RequestMapping("api/announcements")
//public class Announcement_spController {
//
//    @Autowired
//    private AnnouncementService announcementService;
//
//    @PostMapping("/add")
//    public ResponseEntity<String> addAnnouncement(@RequestBody Announcement_spDTO announcementDTO) {
//        try {
//            announcementService.addAnnouncement(announcementDTO);
//            return ResponseEntity.ok("Added successfully");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add announcement");
//        }
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<?> getAllAnnouncements() {
//        try {
//            List<Announcement_sp> announcements = announcementService.getAllAnnouncements();
//            return ResponseEntity.ok(announcements);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching announcements");
//        }
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> updateAnnouncement(@PathVariable("id") Long id, @RequestBody Announcement_spDTO announcementDTO) {
//        try {
//            boolean updated = announcementService.updateAnnouncement(id, announcementDTO);
//            if (updated) {
//                return ResponseEntity.ok("Updated successfully");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Announcement not found");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update announcement");
//        }
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteAnnouncement(@PathVariable("id") Long id) {
//        try {
//            boolean deleted = announcementService.deleteAnnouncement(id);
//            if (deleted) {
//                return ResponseEntity.ok("Deleted successfully");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Announcement not found");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete announcement");
//        }
//    }
//}



package com.backend.confee.controller;

import com.backend.confee.dto.Announcement_spDTO;
import com.backend.confee.entity.Announcement_sp;
import com.backend.confee.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")  // Allow any origin to make API calls
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
    public ResponseEntity<List<Announcement_sp>> getAllAnnouncements() {
        try {
            List<Announcement_sp> announcements = announcementService.getAllAnnouncements();
            return ResponseEntity.ok(announcements);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

