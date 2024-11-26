package com.backend.confee.repo;

import com.backend.confee.entity.WorkshopDay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkshopDayRepo extends JpaRepository<WorkshopDay, Integer> {
}
