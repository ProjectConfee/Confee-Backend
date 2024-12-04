package com.backend.confee.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QRCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String ticketId;

    @Lob
    @Column(nullable = false, columnDefinition = "LONGBLOB")
    private byte[] qrCodeImage;


    @Column(nullable = false)
    private boolean entrance = false;

    @Column(nullable = false)
    private boolean lunch = false;

    @Column(nullable = false)
    private boolean refreshments = false;

    public QRCode(String ticketId, byte[] qrCodeBytes) {
        this.ticketId = ticketId;
        this.qrCodeImage = qrCodeBytes;
        this.entrance = false;  // Default values
        this.lunch = false;
        this.refreshments = false;
    }

    @Override
    public String toString() {
        return "QRCode{" +
                "id=" + id +
                ", ticketId='" + ticketId + '\'' +
                ", qrCodeImageSize=" + (qrCodeImage != null ? qrCodeImage.length : 0) + " bytes" +
                ", entrance=" + entrance +
                ", lunch=" + lunch +
                ", refreshments=" + refreshments +
                '}';
    }
}
