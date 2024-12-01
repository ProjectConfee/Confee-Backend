package com.backend.confee.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "profile")
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AllUsers user;

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
