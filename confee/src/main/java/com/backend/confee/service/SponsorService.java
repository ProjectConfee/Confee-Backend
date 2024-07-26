package com.backend.confee.service;

import com.backend.confee.dto.SponsorDto;
import com.backend.confee.entity.Sponsor;

import java.util.Optional;

public interface SponsorService {
    void saveSponsor(Sponsor sponsor);
    Optional<SponsorDto> getSponsorUrlBySponsorId(String sponsorId);
}
