package com.backend.confee.controller;

import com.backend.confee.dto.ConferenceDTO;
import com.backend.confee.dto.ResponseDTO;
import com.backend.confee.service.ConferenceService;
import com.backend.confee.util.VarList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
@RequiredArgsConstructor()
public class ConferenceController {

    private final ConferenceService conferenceService;

    private final ResponseDTO responseDTO;

    @PostMapping("/saveConference")
    public ResponseEntity saveConference(@RequestBody ConferenceDTO conferenceDTO){

        try {
            String response = conferenceService.saveConference(conferenceDTO);
            if (response.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(conferenceDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else if (response.equals("06")) {
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("User Already Exists");
                responseDTO.setContent(conferenceDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception exception){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(exception.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
