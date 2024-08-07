package com.backend.confee.service;




import com.backend.confee.dto.StallLocationDTO;
import com.backend.confee.entity.StallLocation;
import com.backend.confee.repo.StallLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StallLocationServiceImpl implements StallLocationService {

    @Autowired
    private StallLocationRepository stallLocationRepository;

    @Override
    public List<StallLocationDTO> getAllStallLocations() {
        return stallLocationRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StallLocationDTO saveStallLocation(StallLocationDTO stallLocationDTO) {
        StallLocation stallLocation = convertToEntity(stallLocationDTO);
        stallLocation = stallLocationRepository.save(stallLocation);
        return convertToDTO(stallLocation);
    }

    private StallLocationDTO convertToDTO(StallLocation stallLocation) {
        StallLocationDTO dto = new StallLocationDTO();
        dto.setId(stallLocation.getId());
        dto.setStallType(stallLocation.getStallType());
        dto.setLocation(stallLocation.getLocation());
        return dto;
    }

    private StallLocation convertToEntity(StallLocationDTO dto) {
        StallLocation stallLocation = new StallLocation();
        stallLocation.setId(dto.getId());
        stallLocation.setStallType(dto.getStallType());
        stallLocation.setLocation(dto.getLocation());
        return stallLocation;
    }
}

