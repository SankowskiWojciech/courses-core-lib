package com.github.sankowskiwojciech.coursescorelib.model.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.DayOfWeekWithTimes;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.LessonsSchedule;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.ScheduleType;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class IndividualLessonsSchedule extends LessonsSchedule {
    private final StudentEntity studentEntity;

    public IndividualLessonsSchedule(LocalDate beginningDate, LocalDate endDate, ScheduleType scheduleType, Long allLessonsDurationInMinutes, List<DayOfWeekWithTimes> lessonsDaysOfWeekWithTimes, List<String> lessonsTitles, SubdomainEntity subdomainEntity, TutorEntity tutorEntity, StudentEntity studentEntity) {
        super(beginningDate, endDate, scheduleType, allLessonsDurationInMinutes, lessonsDaysOfWeekWithTimes, lessonsTitles, subdomainEntity, tutorEntity);
        this.studentEntity = studentEntity;
    }
}
