package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
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
    private final SubdomainEntity subdomainEntity;
    private final TutorEntity tutorEntity;
    private final List<String> filesIds;

    public Lesson(String title, LocalDateTime startDate, LocalDateTime endDate, String description, SubdomainEntity subdomainEntity, TutorEntity tutorEntity, List<String> filesIds) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.subdomainEntity = subdomainEntity;
        this.tutorEntity = tutorEntity;
        this.filesIds = filesIds;
    }
}
