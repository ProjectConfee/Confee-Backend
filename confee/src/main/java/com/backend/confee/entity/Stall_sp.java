package com.backend.confee.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stalls")
public class Stall_sp {
    @Id
    private String stallId;
    private String stallName;
    private String sponsorId;

    public String getStallId() {
        return stallId;
    }

    public void setStallId(String stallId) {
        this.stallId = stallId;
    }

    public String getStallName() {
        return stallName;
    }

    public void setStallName(String stallName) {
        this.stallName = stallName;
    }

    public String getSponsorId() {
        return sponsorId;
    }

    public void setSponsorId(String sponsorId) {
        this.sponsorId = sponsorId;
    }





}

