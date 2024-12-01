package com.backend.confee.repo;

import com.backend.confee.dto.WorkshopDTO;
import com.backend.confee.dto.WorkshopResDTO;
import com.backend.confee.entity.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkshopRepo extends JpaRepository<Workshop, Integer> {
    @Query("SELECT new com.backend.confee.dto.WorkshopResDTO(w.id, w.type, w.title, w.noOfSeat,w.coverPhoto) " +
            "FROM Workshop w")
    List<WorkshopResDTO> findWorkshopSummary();
}
