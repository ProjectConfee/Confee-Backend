package com.backend.confee.dto;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//@Getter
//@Setter
//public class ProfileDto {
//    private Long id;
//    private String companyName;
//    private String companyAddress;
//    private String contactNumber;
//    private String companyEmail;
//    private String biography;
//    private List<String> playGamesAdded;
//    private String companyLogo;
//    private List<SocialMediaLinkDto> socialMediaLinks;
//}




//
//
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter
//@Setter
//public class ProfileDto {
//    private String companyName;
//    private String companyAddress;
//    private String contactNumber;
//    private String companyEmail;
//    private String biography;
//    private List<String> playGames;
//    private String companyLogo;
//    private List<SocialMediaLinkDto> socialMediaLinks;
//}
//


import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ProfileDTO {

    private String companyName;
    private String companyAddress;
    private String contactNumber;
    private String companyEmail;
    private String biography;
    private List<String> playGames;
    private String companyLogo;
    private List<SocialMediaLinkDto> socialMediaLinks;
}

