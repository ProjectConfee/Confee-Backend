//package com.backend.confee.entity;
//
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Getter;
//
//import java.time.LocalDateTime;
//
//
//@Entity
//public class Announcement_sp {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String announcement;
//    private LocalDateTime timestamp;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getAnnouncement() {
//        return announcement;
//    }
//
//    public void setAnnouncement(String announcement) {
//        this.announcement = announcement;
//    }
//}
//package com.backend.confee.entity;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@Entity
//@Getter
//@Setter
//public class Announcement_sp {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String announcement;
//    @JsonFormat(pattern = "HH:mm")
//    private LocalDateTime timestamp;
//
//    public String getTimestamp() {
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
//        return this.timestamp.format(formatter);
//    }
//
//    public void setTimestamp(String timestamp) {
//        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
//        this.timestamp = LocalDateTime.parse(timestamp, formatter);
//    }
//
//}
package com.backend.confee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Announcement_sp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String announcement;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    // Remove custom getter and setter for timestamp
}
