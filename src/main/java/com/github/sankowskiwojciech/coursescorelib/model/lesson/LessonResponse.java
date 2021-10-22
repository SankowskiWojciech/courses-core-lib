package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public abstract class LessonResponse {
    private final String id;
    private final String title;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String description;
    private final String subdomainAlias;
    private final String tutorEmailAddress;
    private final List<LessonFileResponse> filesInformation;

    public LessonResponse(String id, String title, LocalDateTime startDate, LocalDateTime endDate, String description, String subdomainAlias, String tutorEmailAddress, List<LessonFileResponse> filesInformation) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.subdomainAlias = subdomainAlias;
        this.tutorEmailAddress = tutorEmailAddress;
        this.filesInformation = filesInformation;
    }
}
