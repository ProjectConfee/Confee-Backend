package com.backend.confee.repo;

import com.backend.confee.entity.Schedule;
import com.backend.confee.entity.WorkshopDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepo extends JpaRepository<Schedule, Long> {
    @Query("SELECT s FROM Schedule s WHERE s.workshopDay.workshop.id = :workshopId")
    List<Schedule> findSchedulesByWorkshopId(Long workshopId);

    @Query("SELECT wd FROM WorkshopDay wd WHERE wd.id = :id")
    WorkshopDay findWorkshopDayById(Integer id);

}
