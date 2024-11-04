package com.backend.confee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class playGameDTO {

    private String gameName;
    private String gameType;

    // Constructors
    public playGameDTO() {
    }

    public playGameDTO(String gameName, String gameType) {
        this.gameName = gameName;
        this.gameType = gameType;
    }


}
