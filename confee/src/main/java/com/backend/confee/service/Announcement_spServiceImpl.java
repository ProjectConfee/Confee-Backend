//////package com.backend.confee.service;
//////
//////
//////
//////
//////import com.backend.confee.dto.Announcement_spDTO;
//////import com.backend.confee.entity.Announcement_sp;
//////import com.backend.confee.repo.AnnouncementRepo;
//////import org.springframework.beans.factory.annotation.Autowired;
//////import org.springframework.stereotype.Service;
//////
//////import java.util.List;
//////
//////@Service
//////public class Announcement_spServiceImpl implements AnnouncementService {
//////
//////    @Autowired
//////    private AnnouncementRepo announcementRepository;
//////
//////    @Override
//////    public void addAnnouncement(Announcement_spDTO announcementDTO) {
//////        Announcement_sp announcement = new Announcement_sp();
//////        announcement.setAnnouncement(announcementDTO.getAnnouncement());
//////        announcementRepository.save(announcement);
//////    }
//////
////////    @Override
////////    public Announcement_sp addAnnouncement(Announcement_spDTO announcementDTO) {
////////        return null;
////////    }
//////
//////    @Override
//////    public List<Announcement_sp> getAllAnnouncements() {
//////        return announcementRepository.findAll();
//////    }
//////}
////
////package com.backend.confee.service;
////
////import com.backend.confee.dto.Announcement_spDTO;
////import com.backend.confee.entity.Announcement_sp;
////import com.backend.confee.repo.AnnouncementRepo;
////
////import com.backend.confee.service.AnnouncementService;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import java.util.List;
////
////@Service
////public class Announcement_spServiceImpl implements AnnouncementService {
////
////    @Autowired
////    private AnnouncementRepo announcementRepository;
////
////    @Override
////    public Announcement_sp addAnnouncement(Announcement_spDTO announcementDTO) {
////        Announcement_sp announcement = new Announcement_sp();
////        announcement.setAnnouncement(announcementDTO.getAnnouncement());
////        Announcement_sp savedAnnouncement = announcementRepository.save(announcement);
////        System.out.println("Saved Announcement: " + savedAnnouncement);
////        return savedAnnouncement;
////    }
////
////    @Override
////    public List<Announcement_sp> getAllAnnouncements() {
////        List<Announcement_sp> announcements = announcementRepository.findAll();
////        return announcements;
////    }
////}
//package com.backend.confee.service;
//
//import com.backend.confee.dto.Announcement_spDTO;
//import com.backend.confee.entity.Announcement_sp;
//import com.backend.confee.repo.AnnouncementRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class Announcement_spServiceImpl implements AnnouncementService {
//
//    @Autowired
//    private AnnouncementRepo announcementRepository;
//
//    @Override
//    public Announcement_sp addAnnouncement(Announcement_spDTO announcementDTO) {
//        Announcement_sp announcement = new Announcement_sp();
//        announcement.setAnnouncement(announcementDTO.getAnnouncement());
//        announcement.setTimestamp(LocalDateTime.now()); // Set the current timestamp
//        return announcementRepository.save(announcement);
//    }
//
//    @Override
//    public List<Announcement_sp> getAllAnnouncements() {
//        return announcementRepository.findAll();
//    }
//
//
//}





//bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb
//package com.backend.confee.service;
//
//import com.backend.confee.dto.Announcement_spDTO;
//import com.backend.confee.entity.Announcement_sp;
//import com.backend.confee.repo.AnnouncementRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class Announcement_spServiceImpl implements AnnouncementService {
//
//    @Autowired
//    private AnnouncementRepo announcementRepository;
//
//    @Override
//    public Announcement_sp addAnnouncement(Announcement_spDTO announcementDTO) {
//        Announcement_sp announcement = new Announcement_sp();
//        announcement.setAnnouncement(announcementDTO.getAnnouncement());
//        announcement.setTimestamp(LocalDateTime.now()); // Set the current timestamp
//        return announcementRepository.save(announcement);
//    }
//
//    @Override
//    public List<Announcement_sp> getAllAnnouncements() {
//        return announcementRepository.findAll();
//    }
//
//    @Override
//    public boolean updateAnnouncement(Long id, Announcement_spDTO announcementDTO) {
//        Optional<Announcement_sp> optionalAnnouncement = announcementRepository.findById(id);
//        if (optionalAnnouncement.isPresent()) {
//            Announcement_sp announcement = optionalAnnouncement.get();
//            announcement.setAnnouncement(announcementDTO.getAnnouncement());
//            announcementRepository.save(announcement);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public boolean deleteAnnouncement(Long id) {
//        if (announcementRepository.existsById(id)) {
//            announcementRepository.deleteById(id);
//            return true;
//        }
//        return false;
//    }
//}



//,mmmmmmmmmmmmmmmmmmmmmmmmmmm

package com.backend.confee.service;

import com.backend.confee.dto.Announcement_spDTO;
import com.backend.confee.entity.Announcement_sp;
import com.backend.confee.repo.AnnouncementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class Announcement_spServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementRepo announcementRepository;

    @Override
    public Announcement_sp addAnnouncement(Announcement_spDTO announcementDTO) {
        Announcement_sp announcement = new Announcement_sp();
        announcement.setAnnouncement(announcementDTO.getAnnouncement());
        announcement.setTimestamp(LocalDateTime.now()); // Set the current timestamp
        return announcementRepository.save(announcement);
    }

    @Override
    public List<Announcement_sp> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    @Override
    public boolean updateAnnouncement(Long id, Announcement_spDTO announcementDTO) {
        Optional<Announcement_sp> optionalAnnouncement = announcementRepository.findById(id);
        if (optionalAnnouncement.isPresent()) {
            Announcement_sp announcement = optionalAnnouncement.get();
            announcement.setAnnouncement(announcementDTO.getAnnouncement());
            announcementRepository.save(announcement);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAnnouncement(Long id) {
        if (announcementRepository.existsById(id)) {
            announcementRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

