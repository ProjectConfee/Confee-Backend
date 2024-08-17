package com.backend.confee.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter

@Setter
@Embeddable
public class SocialMediaLink {

    private String platform;
    private String url;


    // Getters and Setters
    // ...
}
