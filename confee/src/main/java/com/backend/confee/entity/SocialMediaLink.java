package com.backend.confee.entity;
//
//import jakarta.persistence.Embeddable;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//
//@Setter
//@Embeddable
//public class SocialMediaLink {
//
//    private String platform;
//    private String url;
//
//
//    // Getters and Setters
//    // ...
//}


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin
//@Getter
//@Setter
//@Embeddable
//public class SocialMediaLink {
//
//    private String platform;
//    private String url;
//
//    // Getters and Setters
//
//    // Constructor(s)
//    public SocialMediaLink() {}
//
//    public SocialMediaLink(String platform, String url) {
//        this.platform = platform;
//        this.url = url;
//    }
//}


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SocialMediaLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String platform;
    private String url;

    // Constructors, Getters, and Setters
    public SocialMediaLink() {}

    public SocialMediaLink(String platform, String url) {
        this.platform = platform;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
