package com.backend.confee.controller;

import com.backend.confee.dto.StallLocationDTO;


import com.backend.confee.service.StallLocationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/stall-locations")
//public class StallLocationController {
//
//    @Autowired
//    private StallLocationService stallLocationService;
//
//    @GetMapping("/getAll")
//    public List<StallLocationDTO> getAllStallLocations() {
//        return stallLocationService.getAllStallLocations();
//    }
//
//    @PostMapping("/add")
//    public StallLocationDTO addStallLocation(@RequestBody StallLocationDTO stallLocationDTO) {
//        return stallLocationService.saveStallLocation(stallLocationDTO);
//    }
//}




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/stall-locations")  // Updated endpoint
public class StallLocationController {

    @Autowired
    private StallLocationService stallLocationService;

    @GetMapping
    public List<StallLocationDTO> getAllStallLocations() {
        return stallLocationService.getAllStallLocations();
    }

    @PostMapping
    public StallLocationDTO addStallLocation(@RequestBody StallLocationDTO stallLocationDTO) {
        return stallLocationService.saveStallLocation(stallLocationDTO);
    }
}
