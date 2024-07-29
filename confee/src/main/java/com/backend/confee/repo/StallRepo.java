package com.backend.confee.repo;



import com.backend.confee.entity.Stall_sp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StallRepo extends JpaRepository<Stall_sp, String> {
    List<Stall_sp> findBySponsorId(String sponsorId);
}

