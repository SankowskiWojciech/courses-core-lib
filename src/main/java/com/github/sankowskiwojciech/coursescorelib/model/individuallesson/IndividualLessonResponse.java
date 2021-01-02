package com.github.sankowskiwojciech.coursescorelib.model.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.lesson.LessonFileResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class IndividualLessonResponse {
    private final long lessonId;
    private final String title;
    private final LocalDateTime startDateOfLesson;
    private final LocalDateTime endDateOfLesson;
    private final String description;
    private final String subdomainName;
    private final String tutorEmailAddress;
    private final String studentFullName;
    private final String studentEmailAddress;
    private final List<LessonFileResponse> filesInformation;
}
