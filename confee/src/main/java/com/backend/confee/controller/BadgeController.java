

package com.backend.confee.controller;


//import com.backend.confee.dto.BadgeDTO;
//import com.backend.confee.entity.Badge;
//import com.backend.confee.service.BadgeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.List;
//@CrossOrigin
//@RestController
//@RequestMapping("/badges")
//public class BadgeController {
//
//    @Autowired
//    private BadgeService badgeService;
//
//    @PostMapping("/add")
//    public ResponseEntity<Badge> createBadge(@RequestParam("badgeName") String badgeName,
//                                             @RequestParam("privileges") String privileges,
//                                             @RequestParam("image") MultipartFile image) throws IOException {
//        String imagePath = badgeService.saveImage(image);
//        BadgeDTO badgeDTO = new BadgeDTO();
//        badgeDTO.setBadgeName(badgeName);
//        badgeDTO.setPrivileges(privileges);
//        badgeDTO.setImagePath(imagePath);
//
//        Badge savedBadge = badgeService.saveBadge(badgeDTO);
//        return ResponseEntity.ok(savedBadge);
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Badge>> getAllBadges() {
//        List<Badge> badges = badgeService.getAllBadges();
//        return ResponseEntity.ok(badges);
//    }
//}




//
//import com.backend.confee.dto.BadgeDTO;
//import com.backend.confee.entity.Badge;
//import com.backend.confee.service.BadgeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//import java.util.List;
//
//
//@CrossOrigin(origins = "http://localhost:5173")
//@RestController
//@RequestMapping("/badges")
//public class BadgeController {
//
//    @Autowired
//    private BadgeService badgeService;
//
//    /**
//     * Endpoint to create a new badge.
//     * @param badgeName the name of the badge
//     * @param privileges the privileges associated with the badge
//     * @param image the image file associated with the badge
//     * @return the created Badge
//     * @throws IOException if there is an issue with file handling
//     */
//    @PostMapping("/add")
//    public ResponseEntity<Badge> createBadge(
//            @RequestParam("badgeName") String badgeName,
//            @RequestParam("privileges") String privileges,
//            @RequestParam("image") MultipartFile image) throws IOException {
//        BadgeDTO badgeDTO = new BadgeDTO();
//        badgeDTO.setBadgeName(badgeName);
//        badgeDTO.setPrivileges(privileges);
//        String imagePath = badgeService.saveImage(image);
//        badgeDTO.setImagePath(imagePath);
//        Badge savedBadge = badgeService.saveBadge(badgeDTO);
//        return ResponseEntity.ok(savedBadge);
//    }
//    public String saveImage(MultipartFile image) throws IOException {
//        // Define the directory to save images
//        File directory = new File("confee/uploads");
//        if (!directory.exists()) {
//            if (!directory.mkdirs()) {
//                throw new IOException("Failed to create directory: " + directory.getAbsolutePath());
//            }
//        }
//
//        // Define the path to save the image
//        String filePath = directory.getAbsolutePath() + "/" + image.getOriginalFilename();
//        File file = new File(filePath);
//
//        // Save the file
//        try (InputStream inputStream = image.getInputStream();
//             OutputStream outputStream = new FileOutputStream(file)) {
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//        }
//
//        return filePath;
//    }
//
//
//    /**
//     * Endpoint to retrieve all badges.
//     * @return a list of all badges
//     */
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Badge>> getAllBadges() {
//        try {
//            List<Badge> badges = badgeService.getAllBadges();
//            return ResponseEntity.ok(badges);
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body(null); // Adjust status and response as needed
//        }
//    }
//}


import com.backend.confee.dto.BadgeDTO;
import com.backend.confee.entity.Badge;
import com.backend.confee.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/badges")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;

    /**
     * Endpoint to create a new badge.
     * @param badgeName the name of the badge
     * @param privileges the privileges associated with the badge
     * @param image the image file associated with the badge
     * @return the created Badge
     */
    @PostMapping("/add")
    public ResponseEntity<?> createBadge(
            @RequestParam("badgeName") String badgeName,
            @RequestParam("privileges") String privileges,
            @RequestParam("image") MultipartFile image) {
        try {
            BadgeDTO badgeDTO = new BadgeDTO();
            badgeDTO.setBadgeName(badgeName);
            badgeDTO.setPrivileges(privileges);
            String imagePath = badgeService.saveImage(image);
            badgeDTO.setImagePath(imagePath);
            Badge savedBadge = badgeService.saveBadge(badgeDTO);
            return ResponseEntity.ok(savedBadge);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Badge creation failed: " + e.getMessage());
        }


    }

    /**
     * Endpoint to retrieve all badges.
     * @return a list of all badges
     */
    @GetMapping("/getAll")
    public ResponseEntity<?> getAllBadges() {
        try {
            List<Badge> badges = badgeService.getAllBadges();
            return ResponseEntity.ok(badges);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve badges: " + e.getMessage());
        }
    }
}
