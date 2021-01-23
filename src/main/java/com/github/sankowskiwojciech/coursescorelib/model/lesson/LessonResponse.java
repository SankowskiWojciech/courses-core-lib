package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public abstract class LessonResponse {
    private final long lessonId;
    private final String title;
    private final LocalDateTime startDateOfLesson;
    private final LocalDateTime endDateOfLesson;
    private final String description;
    private final String subdomainName;
    private final String tutorEmailAddress;
    private final List<LessonFileResponse> filesInformation;

    public LessonResponse(long lessonId, String title, LocalDateTime startDateOfLesson, LocalDateTime endDateOfLesson, String description, String subdomainName, String tutorEmailAddress, List<LessonFileResponse> filesInformation) {
        this.lessonId = lessonId;
        this.title = title;
        this.startDateOfLesson = startDateOfLesson;
        this.endDateOfLesson = endDateOfLesson;
        this.description = description;
        this.subdomainName = subdomainName;
        this.tutorEmailAddress = tutorEmailAddress;
        this.filesInformation = filesInformation;
    }
}
