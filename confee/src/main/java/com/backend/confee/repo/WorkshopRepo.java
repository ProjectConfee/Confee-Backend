package com.backend.confee.repo;

import com.backend.confee.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopRepo extends JpaRepository<Workshop, Integer> {
}
