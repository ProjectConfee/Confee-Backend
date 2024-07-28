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
package com.backend.confee.controller;

import com.backend.confee.dto.Announcement_spDTO;
import com.backend.confee.entity.Announcement_sp;
import com.backend.confee.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class Announcement_spController {

    @Autowired
    private AnnouncementService announcementService;

    @PostMapping("/add")
    public String addAnnouncement(@RequestBody Announcement_spDTO announcementDTO) {
        announcementService.addAnnouncement(announcementDTO);
        return "Added successfully";
    }

    @GetMapping("/all")
    public List<Announcement_sp> getAllAnnouncements() {
        return announcementService.getAllAnnouncements();
    }
}


