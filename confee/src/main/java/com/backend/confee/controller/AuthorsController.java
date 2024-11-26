package com.backend.confee.controller;

import com.backend.confee.dto.AuthorsDTO;
import com.backend.confee.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getAuthors")
    public List<AuthorsDTO> getAuthors() {
        return authorsService.getAllAuthors();
    }

    @PutMapping("/updateAuthors")
    public AuthorsDTO updateAuthors(@RequestBody AuthorsDTO authorsDTO) {
        return authorsService.updateAuthors(authorsDTO);
    }

    @DeleteMapping("deleteAuthors")
    public boolean deleteAuthors(@RequestBody AuthorsDTO authorsDTO) {
        return authorsService.deleteAuthors(authorsDTO);
    }

}
