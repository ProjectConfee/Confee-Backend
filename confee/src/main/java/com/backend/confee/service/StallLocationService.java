package com.backend.confee.service;



import com.backend.confee.dto.StallLocationDTO;

import java.util.List;

public interface StallLocationService {

    List<StallLocationDTO> getAllStallLocations();

    StallLocationDTO saveStallLocation(StallLocationDTO stallLocationDTO);
}

