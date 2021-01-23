package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public abstract class LessonsSchedule {
    private final LocalDate beginningDate;
    private final LocalDate endDate;
    private final ScheduleType scheduleType;
    private final Long allLessonsDurationInMinutes;
    private final List<DayOfWeekWithTimes> lessonsDaysOfWeekWithTimes;
    private final List<String> lessonsTitles;
    private final OrganizationEntity organizationEntity;
    private final TutorEntity tutorEntity;

    public LessonsSchedule(LocalDate beginningDate, LocalDate endDate, ScheduleType scheduleType, Long allLessonsDurationInMinutes, List<DayOfWeekWithTimes> lessonsDaysOfWeekWithTimes, List<String> lessonsTitles, OrganizationEntity organizationEntity, TutorEntity tutorEntity) {
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        this.scheduleType = scheduleType;
        this.allLessonsDurationInMinutes = allLessonsDurationInMinutes;
        this.lessonsDaysOfWeekWithTimes = lessonsDaysOfWeekWithTimes;
        this.lessonsTitles = lessonsTitles;
        this.organizationEntity = organizationEntity;
        this.tutorEntity = tutorEntity;
    }
}
