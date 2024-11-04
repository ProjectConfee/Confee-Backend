package com.backend.confee.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class PlayGame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gameName;
    private String gameType;

    // Constructors
    public PlayGame() {
    }

    public PlayGame(String gameName, String gameType) {
        this.gameName = gameName;
        this.gameType = gameType;
    }


}

