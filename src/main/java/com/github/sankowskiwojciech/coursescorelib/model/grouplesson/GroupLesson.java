package com.github.sankowskiwojciech.coursescorelib.model.grouplesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.group.GroupEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.Lesson;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GroupLesson extends Lesson {
    private final GroupEntity groupEntity;

    public GroupLesson(String title, LocalDateTime startDateOfLesson, LocalDateTime endDateOfLesson, String description, OrganizationEntity organizationEntity, TutorEntity tutorEntity, List<String> filesIds, GroupEntity groupEntity) {
        super(title, startDateOfLesson, endDateOfLesson, description, organizationEntity, tutorEntity, filesIds);
        this.groupEntity = groupEntity;
    }
}
