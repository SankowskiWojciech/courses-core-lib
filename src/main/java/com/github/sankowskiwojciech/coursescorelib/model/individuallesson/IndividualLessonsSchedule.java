package com.github.sankowskiwojciech.coursescorelib.model.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class IndividualLessonsSchedule extends LessonsSchedule {
    private final StudentEntity studentEntity;

    public IndividualLessonsSchedule(LocalDate beginningDate, LocalDate endDate, ScheduleType scheduleType, Long allLessonsDurationInMinutes, List<DayOfWeekWithTimes> lessonsDaysOfWeekWithTimes, List<String> lessonsTitles, OrganizationEntity organizationEntity, TutorEntity tutorEntity, StudentEntity studentEntity) {
        super(beginningDate, endDate, scheduleType, allLessonsDurationInMinutes, lessonsDaysOfWeekWithTimes, lessonsTitles, organizationEntity, tutorEntity);
        this.studentEntity = studentEntity;
    }
}
