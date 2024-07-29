package com.backend.confee.service;




import com.backend.confee.dto.Stall_spDto;
import com.backend.confee.entity.Stall_sp;

import java.util.List;

public interface StallService {
    void saveStall(Stall_sp stall);
    List<Stall_spDto> getStallsBySponsorId(String sponsorId);
}
