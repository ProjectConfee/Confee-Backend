package com.backend.confee.dto;

import lombok.Data;

@Data
public class UserProfileDTO {
    private String name;
    private String email;
    private String phone;
    private String altPhone;
    private String jobTitle;
    private String organization;
    private String country;
    private Number yearOfExperience ;
    private Number noOfAttendance;
    private String researchInterest;
    private String dietaryReference;
    private Boolean accessibility;
    private String note;
    private Boolean isComplete;
}
