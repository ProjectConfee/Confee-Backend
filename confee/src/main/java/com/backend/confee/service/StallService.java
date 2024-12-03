package com.backend.confee.service;




import com.backend.confee.dto.Stall_spDto;
import com.backend.confee.entity.Stall_sp;
import com.backend.confee.repo.StallRepo;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




public interface StallService {
    void saveStall(Stall_sp stall);
    List<Stall_spDto> getStallsBySponsorId(String sponsorId);
    List<Stall_spDto> getAllStalls();
}
