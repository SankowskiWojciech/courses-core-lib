package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public abstract class Lesson {
    private final String title;
    private final LocalDateTime startDateOfLesson;
    private final LocalDateTime endDateOfLesson;
    private final String description;
    private final OrganizationEntity organizationEntity;
    private final TutorEntity tutorEntity;
    private final List<Long> filesIds;

    public Lesson(String title, LocalDateTime startDateOfLesson, LocalDateTime endDateOfLesson, String description, OrganizationEntity organizationEntity, TutorEntity tutorEntity, List<Long> filesIds) {
        this.title = title;
        this.startDateOfLesson = startDateOfLesson;
        this.endDateOfLesson = endDateOfLesson;
        this.description = description;
        this.organizationEntity = organizationEntity;
        this.tutorEntity = tutorEntity;
        this.filesIds = filesIds;
    }
}
