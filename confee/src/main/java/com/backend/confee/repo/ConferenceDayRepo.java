package com.backend.confee.repo;

import com.backend.confee.dto.ConferenceDayResDTO;
import com.backend.confee.dto.ConferenceResDTO;
import com.backend.confee.dto.WorkshopResDTO;
import com.backend.confee.entity.AllUsers;
import com.backend.confee.entity.ConferenceDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ConferenceDayRepo extends JpaRepository<ConferenceDay, Long> {
    @Query("SELECT new com.backend.confee.dto.ConferenceDayResDTO(c.id, c.title,c.date,c.coverPhoto) " +
            "FROM ConferenceDay c")
    List<ConferenceDayResDTO> findWorkshopSummary();
    Optional<ConferenceDay> findById(long id);
}
