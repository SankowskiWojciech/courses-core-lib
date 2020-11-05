package com.github.sankowskiwojciech.coursescorelib.model.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.lesson.LessonFileResponse;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class IndividualLessonResponse {
    private long lessonId;
    private String title;
    private LocalDateTime startDateOfLesson;
    private LocalDateTime endDateOfLesson;
    private String description;
    private String subdomainName;
    private String tutorEmailAddress;
    private String studentFullName;
    private String studentEmailAddress;
    private List<LessonFileResponse> filesInformation;
}
