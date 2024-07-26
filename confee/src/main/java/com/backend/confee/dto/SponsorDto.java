package com.backend.confee.dto;

public class SponsorDto {
    private String sponsorId;
//    private byte[] qrCodeImage;
    private String qrCodeUrl;

    // Getters and Setters
    public String getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(String sponsorId) {
        this.sponsorId = sponsorId;
    }

//    public byte[] getQrCodeImage() {
//        return qrCodeImage;
//    }
//
//    public void setQrCodeImage(byte[] qrCodeImage) {
//        this.qrCodeImage = qrCodeImage;
//    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }
}

