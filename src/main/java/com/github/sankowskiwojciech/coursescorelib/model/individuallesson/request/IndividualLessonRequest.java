package com.github.sankowskiwojciech.coursescorelib.model.individuallesson.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class IndividualLessonRequest {
    private String title;
    private LocalDateTime startDateOfLesson;
    private LocalDateTime endDateOfLesson;
    private String description;
    private String subdomainName;
    private String tutorId;
    private String studentId;
}
