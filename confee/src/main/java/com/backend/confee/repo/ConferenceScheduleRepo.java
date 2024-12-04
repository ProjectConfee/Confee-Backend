package com.backend.confee.repo;

import com.backend.confee.entity.ConferenceSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConferenceScheduleRepo extends JpaRepository<ConferenceSchedule, Long> {
    List<ConferenceSchedule> findByConferenceId(Long conferenceId);
}
