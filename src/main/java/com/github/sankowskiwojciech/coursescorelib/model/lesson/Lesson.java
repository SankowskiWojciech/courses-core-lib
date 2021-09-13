package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Lesson {
    private final String title;
    private final LocalDateTime startDate;
    private final LocalDateTime endDate;
    private final String description;
    private final OrganizationEntity organizationEntity;
    private final TutorEntity tutorEntity;
    private final List<String> filesIds;

    public Lesson(String title, LocalDateTime startDate, LocalDateTime endDate, String description, OrganizationEntity organizationEntity, TutorEntity tutorEntity, List<String> filesIds) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.organizationEntity = organizationEntity;
        this.tutorEntity = tutorEntity;
        this.filesIds = filesIds;
    }
}
