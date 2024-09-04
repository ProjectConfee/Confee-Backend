package com.backend.confee.service;





import com.backend.confee.dto.Announcement_spDTO;
import com.backend.confee.entity.Announcement_sp;

import java.util.List;

public interface AnnouncementService {
    Announcement_sp addAnnouncement(Announcement_spDTO announcementDTO);
    List<Announcement_sp> getAllAnnouncements();

    boolean updateAnnouncement(Long id, Announcement_spDTO announcementDTO);

    boolean deleteAnnouncement(Long id);
}

