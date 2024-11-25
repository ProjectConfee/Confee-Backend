package com.backend.confee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

//@Entity
//public class Profile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String companyName;
//    private String companyAddress;
//    private String contactNumber;
//    private String companyEmail;
//
//    @Column(length = 200)
//    private String biography;
//
//    @ElementCollection
//    @CollectionTable(name = "play_games_added", joinColumns = @JoinColumn(name = "profile_id"))
//    private List<PlayGamesAdded> playGamesAdded;
//
//    private String companyLogo;
//
////    @ElementCollection
////    private List<SocialMediaLink> socialMediaLinks;
////
////
////}
//
//
//@Entity
//public class Profile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String companyName;
//    private String companyAddress;
//    private String contactNumber;
//    private String companyEmail;
//    private String biography;
//
//    @ElementCollection
//    private List<String> playGames;
//
//    private String companyLogo;
//
//
//
//
//    public static class SocialMediaLink {
//        private String platform;
//        private String url;
//    }
//
//    // Getters and Setters
//}
//
//@Embeddable
//
//class SocialMediaLink {
//    private String platform;
//    private String url;
//
//    // Getters and Setters
//}


//@Entity
//public class Profile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String companyName;
//    private String companyAddress;
//    private String contactNumber;
//    private String companyEmail;
//    private String biography;
//
//    @ElementCollection
//    private List<String> playGames;
//
//    private String companyLogo;
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<SocialMediaLink> socialMediaLinks;
//
//    // Getters and Setters
//    public String getCompanyName() {
//        return companyName;
//    }
//
//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }
//
//
//
//
//    public void setCompanyAddress(String companyAddress) {
//    }
//
//    public void setContactNumber(String contactNumber) {
//    }
//
//    public void setCompanyEmail(String companyEmail) {
//    }
//
//    public void setBiography(String biography) {
//    }
//
//    public void setPlayGames(List<String> playGames) {
//    }
//
//    public void setCompanyLogo(String companyLogo) {
//    }
//
//    public void setSocialMediaLinks(List<SocialMediaLink> socialMediaLinks) {
//    }
//}
//
//@Entity
//public class SocialMediaLink {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String platform;
//    private String url;
//
//    // Getters and Setters
//    public String getPlatform() {
//        return platform;
//    }
//
//    public void setPlatform(String platform) {
//        this.platform = platform;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//}
//
//import java.util.List;
//
//@Entity
//public class Profile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String companyName;
//    private String companyAddress;
//    private String contactNumber;
//    private String companyEmail;
//    private String biography;
//
//    @ElementCollection
//    private List<String> playGames;
//
//    private String companyLogo;
//
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<SocialMediaLink> socialMediaLinks;
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getCompanyName() {
//        return companyName;
//    }
//
//    public void setCompanyName(String companyName) {
//        this.companyName = companyName;
//    }
//
//    public String getCompanyAddress() {
//        return companyAddress;
//    }
//
//    public void setCompanyAddress(String companyAddress) {
//        this.companyAddress = companyAddress;
//    }
//
//    public String getContactNumber() {
//        return contactNumber;
//    }
//
//    public void setContactNumber(String contactNumber) {
//        this.contactNumber = contactNumber;
//    }
//
//    public String getCompanyEmail() {
//        return companyEmail;
//    }
//
//    public void setCompanyEmail(String companyEmail) {
//        this.companyEmail = companyEmail;
//    }
//
//    public String getBiography() {
//        return biography;
//    }
//
//    public void setBiography(String biography) {
//        this.biography = biography;
//    }
//
//    public List<String> getPlayGames() {
//        return playGames;
//    }
//
//    public void setPlayGames(List<String> playGames) {
//        this.playGames = playGames;
//    }
//
//    public String getCompanyLogo() {
//        return companyLogo;
//    }
//
//    public void setCompanyLogo(String companyLogo) {
//        this.companyLogo = companyLogo;
//    }
//
//    public List<SocialMediaLink> getSocialMediaLinks() {
//        return socialMediaLinks;
//    }
//
//    public void setSocialMediaLinks(List<SocialMediaLink> socialMediaLinks) {
//        this.socialMediaLinks = socialMediaLinks;
//    }
//
//    @Entity
//    public static class SocialMediaLink {
//
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//
//        private String platform;
//        private String url;
//
//        // Getters and Setters
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public String getPlatform() {
//            return platform;
//        }
//
//        public void setPlatform(String platform) {
//            this.platform = platform;
//        }
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//    }
//}

//@Getter
//@Setter
//@Entity
//@Table(name = "profiles")
//public class Profile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String companyName;
//    private String companyAddress;
//    private String contactNumber;
//    private String companyEmail;
//    private String biography;
//
//    @ElementCollection
//    @CollectionTable(name = "play_games", joinColumns = @JoinColumn(name = "profile_id"))
//    @Column(name = "play_game")
//    private List<String> playGames;
//
//    private String companyLogo;
//
//    @ElementCollection
//    @CollectionTable(name = "social_media_links", joinColumns = @JoinColumn(name = "profile_id"))
//    private List<SocialMediaLink> socialMediaLinks;
//
//    public void setCompanyName(String companyName) {
//    }
//
//    // Getters and Setters
//    // ...
//}



//@Getter
//@Setter
//@Entity
//@CrossOrigin
//public class Profile {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String companyName;
//    private String companyAddress;
//    private String contactNumber;
//    private String companyEmail;
//
//    @Column(columnDefinition = "TEXT")
//    private String biography;
//
//    @ElementCollection
//    private List<String> playGames;
//
//    private String companyLogo;
//
//    @ElementCollection
//    private List<SocialMediaLink> socialMediaLinks;
//
//
//}

@Getter
@Setter
@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String companyName;
    private String companyAddress;
    private String contactNumber;
    private String companyEmail;
    private String biography;
    private String companyLogo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id")
    private List<PlayGame> playGames;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "profile_id")
    private List<SocialMediaLink> socialMediaLinks;



}
