package com.backend.confee.controller;//package com.backend.confee.controller;
//
//
//
//import com.backend.confee.entity.Stall_sp;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/stall")
//@CrossOrigin
//public class StallController<StallService> {
//
//    private final StallService stallService;
//
//    @Autowired
//    public StallController(StallService stallService) {
//        this.stallService = stallService;
//    }
//
//    @PostMapping("/add")
//    public String addStall(@RequestBody Stall_sp stall) {
//        stallService.equals(stall);
//        return "New stall is added";
//    }
//
//
//    @GetMapping("/getAll")
//    public Class<?> getAllStalls() {
//        return stallService.getClass(); // Assuming this method fetches all stalls
//    }
//}

import com.backend.confee.dto.Stall_spDto;
import com.backend.confee.entity.Stall_sp;
import com.backend.confee.service.StallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stall")
@CrossOrigin
public class StallController {

    private final StallService stallService;

    @Autowired
    public StallController(StallService stallService) {
        this.stallService = stallService;
    }

    @PostMapping("/add")
    public String addStall(@RequestBody Stall_sp stall) {
        stallService.saveStall(stall);
        return "New stall is added";
    }

    @GetMapping("/getAll")
    public List<Stall_spDto> getAllStalls() {
        return stallService.getAllStalls();
    }
}
