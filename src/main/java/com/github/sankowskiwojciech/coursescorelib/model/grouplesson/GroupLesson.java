package com.github.sankowskiwojciech.coursescorelib.model.grouplesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.group.GroupEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.Lesson;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GroupLesson extends Lesson {
    private final GroupEntity groupEntity;

    public GroupLesson(String title, LocalDateTime startDateOfLesson, LocalDateTime endDateOfLesson, String description, SubdomainEntity subdomainEntity, TutorEntity tutorEntity, List<String> filesIds, GroupEntity groupEntity) {
        super(title, startDateOfLesson, endDateOfLesson, description, subdomainEntity, tutorEntity, filesIds);
        this.groupEntity = groupEntity;
    }
}
