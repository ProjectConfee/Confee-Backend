package com.backend.confee.service;
//
//import com.backend.confee.dto.SponsorDto;
//import com.backend.confee.entity.Sponsor;
//import com.backend.confee.repo.SponsorRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class SponsorServiceImpl implements SponsorService {
//
//    private final SponsorRepo sponsorRepository;
//
//    @Autowired
//    public SponsorServiceImpl(SponsorRepo sponsorRepository) {
//        this.sponsorRepository = sponsorRepository;
//    }
//
//    @Override
//    public void saveSponsor(Sponsor sponsor) {
//        sponsorRepository.save(sponsor);
//    }
//
//    @Override
//    public Optional<SponsorDto> getSponsorUrlBySponsorId(String sponsorId) {
//        return sponsorRepository.findBySponsorId(sponsorId)
//                .map(sponsor -> {
//                    SponsorDto sponsorDto = new SponsorDto();
//                    sponsorDto.setSponsorId(sponsor.getSponsorId());
////                    sponsorDto.setQrCodeImage(sponsor.getQrCodeImage());
//                    sponsorDto.setQrCodeUrl(sponsor.getQrCodeUrl());
//                    return sponsorDto;
//                });
//    }
//}


import com.backend.confee.dto.SponsorDto;
import com.backend.confee.entity.Sponsor;
import com.backend.confee.repo.SponsorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SponsorServiceImpl implements SponsorService {

    private final SponsorRepo sponsorRepository;

    @Autowired
    public SponsorServiceImpl(SponsorRepo sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    @Override
    public void saveSponsor(Sponsor sponsor) {
        sponsorRepository.save(sponsor);
    }

    @Override
    public Optional<SponsorDto> getSponsorUrlBySponsorId(String sponsorId) {
        return sponsorRepository.findBySponsorId(sponsorId)
                .map(sponsor -> {
                    SponsorDto sponsorDto = new SponsorDto();
                    sponsorDto.setSponsorId(sponsor.getSponsorId());
                    sponsorDto.setQrCodeUrl(sponsor.getQrCodeUrl());
                    return sponsorDto;
                });
    }
}
