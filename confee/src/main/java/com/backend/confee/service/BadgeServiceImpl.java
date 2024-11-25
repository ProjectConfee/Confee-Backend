package com.backend.confee.service;

//
import com.backend.confee.dto.BadgeDTO;
import com.backend.confee.entity.Badge;
import com.backend.confee.repo.BadgeRepository;
import com.backend.confee.service.BadgeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class BadgeServiceImpl implements BadgeService {
//
//    @Autowired
//    private BadgeRepository badgeRepository;
//
//    @Override
//    public Badge saveBadge(BadgeDTO badgeDTO) {
//        Badge badge = new Badge();
//        badge.setBadgeName(badgeDTO.getBadgeName());
//        badge.setPrivileges(badgeDTO.getPrivileges());
//        badge.setImagePath(badgeDTO.getImagePath());
//
//        return badgeRepository.save(badge);
//    }
//
//    @Override
//    public List<Badge> getAllBadges() {
//        return badgeRepository.findAll();
//    }
//
//    public String saveImage(MultipartFile image) throws IOException {
//        String uploadsDir = "uploads/";
//        String imagePath = uploadsDir + image.getOriginalFilename();
//        File file = new File(imagePath);
//        image.transferTo(file);
//        return imagePath;
//    }
//}


import com.backend.confee.dto.BadgeDTO;
import com.backend.confee.entity.Badge;
import com.backend.confee.repo.BadgeRepository;
import com.backend.confee.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class BadgeServiceImpl extends BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    @Override
    public Badge saveBadge(BadgeDTO badgeDTO) {
        Badge badge = new Badge();
        badge.setBadgeName(badgeDTO.getBadgeName());
        badge.setPrivileges(badgeDTO.getPrivileges());
        badge.setImagePath(badgeDTO.getImagePath());

        return badgeRepository.save(badge);
    }

    @Override
    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    @Override
    public String saveImage(MultipartFile image) throws IOException {
        String uploadsDir = "uploads/";
        String imagePath = uploadsDir + image.getOriginalFilename();
        File file = new File(imagePath);
        image.transferTo(file);
        return imagePath;
    }


    public BadgeDTO createBadge(BadgeDTO badgeDTO) {
        return null;
    }
}
