package com.github.sankowskiwojciech.coursescorelib.model.individuallesson;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class IndividualLessonResponse {
    private String title;
    private LocalDateTime startDateOfLesson;
    private LocalDateTime endDateOfLesson;
    private String description;
    private String subdomainName;
    private String tutorEmailAddress;
    private String studentFullName;
    private String studentEmailAddress;
}