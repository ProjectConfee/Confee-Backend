package com.backend.confee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ParticipantFeedbackDTO {
    private int id;
    private Long participantId;
    private String title;
    private String content;
    private int rating;
}
