package com.github.sankowskiwojciech.coursescorelib.model.lesson.request;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public abstract class LessonRequest {
    private final String title;
    private final LocalDateTime startDateOfLesson;
    private final LocalDateTime endDateOfLesson;
    private final String description;
    private final String subdomainAlias;
    private final String tutorId;
    private final List<Long> filesIds;

    public LessonRequest(String title, LocalDateTime startDateOfLesson, LocalDateTime endDateOfLesson, String description, String subdomainAlias, String tutorId, List<Long> filesIds) {
        this.title = title;
        this.startDateOfLesson = startDateOfLesson;
        this.endDateOfLesson = endDateOfLesson;
        this.description = description;
        this.subdomainAlias = subdomainAlias;
        this.tutorId = tutorId;
        this.filesIds = filesIds;
    }
}
