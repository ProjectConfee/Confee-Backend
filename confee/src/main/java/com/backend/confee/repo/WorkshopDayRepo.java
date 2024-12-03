package com.backend.confee.repo;

import com.backend.confee.dto.ConferenceDayResDTO;
import com.backend.confee.entity.ConferenceDay;
import com.backend.confee.entity.WorkshopDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WorkshopDayRepo extends JpaRepository<WorkshopDay, Integer> {
    @Query("SELECT wd FROM WorkshopDay wd WHERE wd.workshop.id = :workshopId")
    List<WorkshopDay> findWorkshopDaysByWorkshopId(Long workshopId);


}
