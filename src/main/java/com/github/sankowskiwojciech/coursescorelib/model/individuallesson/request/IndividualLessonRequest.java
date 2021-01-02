package com.github.sankowskiwojciech.coursescorelib.model.individuallesson.request;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class IndividualLessonRequest {
    private final String title;
    private final LocalDateTime startDateOfLesson;
    private final LocalDateTime endDateOfLesson;
    private final String description;
    private final String subdomainName;
    private final String tutorId;
    private final String studentId;
    private final List<Long> filesIds;
}
