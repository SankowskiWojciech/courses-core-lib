package com.github.sankowskiwojciech.coursescorelib.model.lesson.request;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public abstract class LessonRequest {
    private final String title;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String description;
    private final String subdomainAlias;
    private final String tutorId;
    private final List<String> filesIds;

    public LessonRequest(String title, LocalDateTime startDate, LocalDateTime endDate, String description, String subdomainAlias, String tutorId, List<String> filesIds) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.subdomainAlias = subdomainAlias;
        this.tutorId = tutorId;
        this.filesIds = filesIds;
    }
}
