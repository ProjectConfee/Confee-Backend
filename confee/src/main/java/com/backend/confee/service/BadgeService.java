

package com.backend.confee.service;

//
//import com.backend.confee.dto.BadgeDTO;
//import com.backend.confee.entity.Badge;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.util.List;
//import java.io.IOException;
//
//public interface BadgeService {
//    Badge saveBadge(BadgeDTO badgeDTO);
//    List<Badge> getAllBadges();
//
//    String saveImage(MultipartFile image) throws IOException;
//
//
//}

import com.backend.confee.dto.BadgeDTO;
import com.backend.confee.entity.Badge;
import com.backend.confee.repo.BadgeRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class BadgeService {

    public String saveImage(MultipartFile image) throws IOException {
        // Define the directory to save images
        File directory = new File("confee/uploads");
        if (!directory.exists()) {
            if (!directory.mkdirs()) {
                throw new IOException("Failed to create directory: " + directory.getAbsolutePath());
            }
        }

        // Define the path to save the image
        String filePath = directory.getAbsolutePath() + "/" + image.getOriginalFilename();
        File file = new File(filePath);

        // Save the file
        try (InputStream inputStream = image.getInputStream();
             OutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        return filePath;
    }
    @Autowired
    private BadgeRepository badgeRepository;
    public Badge saveBadge(BadgeDTO badgeDTO) {
        // Convert BadgeDTO to Badge entity
        Badge badge = new Badge();
        badge.setBadgeName(badgeDTO.getBadgeName());
        badge.setPrivileges(badgeDTO.getPrivileges());
        badge.setImagePath(badgeDTO.getImagePath());

        // Save the badge to the database
        return badgeRepository.save(badge); // Save the badge and return the saved entity
    }
    public List<Badge> getAllBadges() {
        return badgeRepository.findAll(); // Retrieve all badges from the database
    }
}
