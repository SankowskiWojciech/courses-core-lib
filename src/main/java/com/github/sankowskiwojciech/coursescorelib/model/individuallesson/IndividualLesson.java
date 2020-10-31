package com.github.sankowskiwojciech.coursescorelib.model.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class IndividualLesson {
    private String title;
    private LocalDateTime startDateOfLesson;
    private LocalDateTime endDateOfLesson;
    private String description;
    private OrganizationEntity organizationEntity;
    private TutorEntity tutorEntity;
    private StudentEntity studentEntity;
    private List<Long> filesIds;
}
