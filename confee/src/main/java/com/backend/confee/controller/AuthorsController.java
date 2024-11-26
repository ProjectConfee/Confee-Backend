package com.backend.confee.controller;

import com.backend.confee.dto.AuthorsDTO;
import com.backend.confee.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/authors")
@CrossOrigin

public class AuthorsController {

    @Autowired
    private AuthorsService authorsService;

    @PostMapping("/saveAuthors")
    public AuthorsDTO saveAuthors(@RequestBody AuthorsDTO authorsDTO) {
        return authorsService.saveAuthors(authorsDTO);
    }
}
