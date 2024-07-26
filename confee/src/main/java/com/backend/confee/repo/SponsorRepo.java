package com.backend.confee.repo;

import com.backend.confee.entity.Sponsor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SponsorRepo extends CrudRepository<Sponsor, String> {
    Optional<Sponsor> findBySponsorId(String sponsorId);
}



