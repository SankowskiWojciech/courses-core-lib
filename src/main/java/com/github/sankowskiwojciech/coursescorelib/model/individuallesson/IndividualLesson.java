package com.github.sankowskiwojciech.coursescorelib.model.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.Lesson;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class IndividualLesson extends Lesson {
    private final StudentEntity studentEntity;

    public IndividualLesson(String title, LocalDateTime startDateOfLesson, LocalDateTime endDateOfLesson, String description, SubdomainEntity subdomainEntity, TutorEntity tutorEntity, List<String> filesIds, StudentEntity studentEntity) {
        super(title, startDateOfLesson, endDateOfLesson, description, subdomainEntity, tutorEntity, filesIds);
        this.studentEntity = studentEntity;
    }
}
