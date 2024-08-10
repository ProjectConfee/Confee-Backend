package com.backend.confee.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
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

    @Column(length = 200)
    private String biography;

    @ElementCollection
    private List<String> playGamesAdded;

    private String companyLogo;

    @ElementCollection
    private List<SocialMediaLink> socialMediaLinks;


}

