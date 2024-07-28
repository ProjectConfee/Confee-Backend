package com.backend.confee.repo;



import com.backend.confee.entity.Announcement_sp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepo extends JpaRepository<Announcement_sp, Long> {
}

