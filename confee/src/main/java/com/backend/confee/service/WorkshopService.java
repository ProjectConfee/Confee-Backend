package com.backend.confee.service;

import com.backend.confee.dto.*;
import com.backend.confee.entity.*;
import com.backend.confee.repo.WorkshopDayRepo;
import com.backend.confee.repo.WorkshopRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class WorkshopService {



    private final WorkshopRepo workshopRepo;
    private final ModelMapper modelMapper;
    private final ResponseDTO responseDTO;
    private  WorkshopDayDTO workshopDayDTO;
    private ResourceService resourceService;
    private WorkshopDayRepo workshopDayRepo;

    public ResponseDTO saveWorkshop(WorkshopDTO workshopDTO) {

        try {
            String postUrl = null;
            String coverPhotoUrl = null;
            if (workshopDTO.getPost() != null && !workshopDTO.getPost().isEmpty()) {
                postUrl = resourceService.storeFile(workshopDTO.getPost());
            }
            if (workshopDTO.getCoverPhoto() != null && !workshopDTO.getCoverPhoto().isEmpty()) {
                coverPhotoUrl = resourceService.storeFile(workshopDTO.getCoverPhoto());
            }
            Workshop workshop = new Workshop();
            workshop.setTitle(workshopDTO.getTitle());
            workshop.setDescription(workshopDTO.getDescription());
            workshop.setLocation(workshopDTO.getLocation());
            workshop.setMapLink(workshopDTO.getMapLink());
            workshop.setType(workshopDTO.getType());
            workshop.setNoOfSeat(workshopDTO.getNoOfSeat());
            workshop.setCertificateFrom(workshopDTO.getCertificateFrom());
            workshop.setLunch(workshopDTO.isLunch());
            workshop.setPost(postUrl);
            workshop.setCoverPhoto(coverPhotoUrl);

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



    public WorkshopResDTO getWorkshopById(Integer id) {
        Optional<Workshop> workshopOpt = workshopRepo.findById(id);
        return workshopOpt.map(this::mapWorkshopToDTO).orElse(null);
    }

    private WorkshopResDTO mapWorkshopToDTO(Workshop workshop) {
        // Convert the workshop days from entity to DTO
        List<WorkshopDayDTO> workshopDayDTOs = workshop.getWorkshopDays().stream()
                .map(this::mapWorkshopDayToDTO)
                .collect(Collectors.toList());


        // Return the final DTO representation of the workshop
        return new WorkshopResDTO(
                workshop.getId(),
                workshop.getTitle(),
                workshop.getDescription(),
                workshop.getLocation(),
                workshop.getMapLink(),
                workshop.getType(),
                workshop.getNoOfSeat(),
                workshop.getCertificateFrom(),
                workshop.isLunch(),
                workshop.getPost(),
                workshop.getCoverPhoto(),
                workshopDayDTOs
        );
    }

    private WorkshopDayDTO mapWorkshopDayToDTO(WorkshopDay workshopDay) {
        // Convert the subtopics from entity to DTO
        List<SubTopicDTO> subTopicDTOs = workshopDay.getSubTopics().stream()
                .map(this::mapSubTopicToDTO)
                .collect(Collectors.toList());

        List<ScheduleDTO> scheduleDTOs =
                (workshopDay.getSchedules() == null ? List.of() :
                        workshopDay.getSchedules().stream()
                                .map(this::mapScheduleToDTO)
                                .collect(Collectors.toList()));


        // Return the final DTO representation of the workshop day
        return new WorkshopDayDTO(
                workshopDay.getId(),
                workshopDay.getDay(),
                workshopDay.getDate(),
                workshopDay.getStartTime(),
                workshopDay.getEndTime(),
                workshopDay.getMainTopic(),
                workshopDay.getInvestment(),
                workshopDay.getWorkshop(),
                subTopicDTOs,
                scheduleDTOs

        );
    }

    private SubTopicDTO mapSubTopicToDTO(SubTopic subTopic) {
        // Return the DTO representation of the subtopic
        return new SubTopicDTO(
                subTopic.getId(),
                subTopic.getSubTopic(),
                subTopic.getWorkshopDay()
        );
    }
    private ScheduleDTO mapScheduleToDTO(Schedule schedule) {
        // Return the DTO representation of the subtopic
        return new ScheduleDTO(
                schedule.getId(),
                schedule.getEvent(),
                schedule.getStartTime(),
                schedule.getStatus(),
                schedule.getWorkshopDay().getId()
        );
    }

    public List<WorkshopResDTO> getWorkshopSummary() {
        return workshopRepo.findWorkshopSummary();
    }


}
