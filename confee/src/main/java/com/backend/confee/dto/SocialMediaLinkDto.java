package com.backend.confee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocialMediaLinkDto {
    private String platform;
    private String url;

    // Constructors, Getters, and Setters

    public SocialMediaLinkDto() {
    }

    public SocialMediaLinkDto(String platform, String url) {
        this.platform = platform;
        this.url = url;
    }


}

