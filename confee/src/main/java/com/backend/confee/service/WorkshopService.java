package com.backend.confee.service;

import com.backend.confee.dto.ResponseDTO;
import com.backend.confee.dto.WorkshopDTO;
import com.backend.confee.entity.SubTopic;
import com.backend.confee.entity.Workshop;
import com.backend.confee.entity.WorkshopDay;
import com.backend.confee.repo.WorkshopRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkshopService {



    private final WorkshopRepo workshopRepo;
    private final ModelMapper modelMapper;
    private final ResponseDTO responseDTO;

    public ResponseDTO saveWorkshop(WorkshopDTO workshopDTO) {
        try {
            Workshop workshop = new Workshop();
            workshop.setTitle(workshopDTO.getTitle());
            workshop.setDescription(workshopDTO.getDescription());
            workshop.setLocation(workshopDTO.getLocation());
            workshop.setType(workshopDTO.getType());
            workshop.setCertificateFrom(workshopDTO.getCertificateFrom());
            workshop.setLunch(workshopDTO.isLunch());
            workshop.setPost(workshopDTO.getPost());
            workshop.setCoverPhoto(workshopDTO.getCoverPhoto());

            List<WorkshopDay> workshopDays = workshopDTO.getWorkshopDays().stream()
                    .map(dayDTO -> {
                        WorkshopDay workshopDay = new WorkshopDay();
                        workshopDay.setDay(dayDTO.getDay());
                        workshopDay.setDate(dayDTO.getDate());
                        workshopDay.setStartTime(dayDTO.getStartTime());
                        workshopDay.setEndTime(dayDTO.getEndTime());
                        workshopDay.setMainTopic(dayDTO.getMainTopic());
                        workshopDay.setInvestment(dayDTO.getInvestment());

                        List<SubTopic> subTopics= dayDTO.getSubTopics().stream().map(subTopic -> {
                            SubTopic subTopic1 = new SubTopic();
                            subTopic1.setSubTopic(subTopic.getSubTopic());

                            subTopic1.setWorkshopDay(workshopDay);
                            return subTopic1;
                        }).toList(); ;
                        workshopDay.setSubTopics(subTopics);
                        workshopDay.setWorkshop(workshop);
                        return workshopDay;
                    }).collect(Collectors.toList());

            workshop.setWorkshopDays(workshopDays);
            workshopRepo.save(workshop);
            responseDTO.setStatusCode(HttpStatus.CREATED);
            responseDTO.setMessage(HttpStatus.CREATED.toString());
        } catch (Exception e) {
            responseDTO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }

//            Workshop workshop = modelMapper.map(workshopDTO, Workshop.class);
//
//            try{
//                workshopRepo.save(workshop);
//                responseDTO.setMessage("Workshop saved successfully");
//                responseDTO.setStatusCode(HttpStatus.CREATED);
//            }catch (Exception e){
//                responseDTO.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
//                responseDTO.setMessage(e.getMessage());
//            }
//            return responseDTO;
//    }
}
