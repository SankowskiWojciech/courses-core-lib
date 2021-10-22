package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class LessonsSchedule {
    private final LocalDate beginningDate;
    private final LocalDate endDate;
    private final ScheduleType scheduleType;
    private final Long allLessonsDurationInMinutes;
    private final List<DayOfWeekWithTimes> daysOfWeekWithTimes;
    private final List<String> titles;
    private final SubdomainEntity subdomainEntity;
    private final TutorEntity tutorEntity;

    public LessonsSchedule(LocalDate beginningDate, LocalDate endDate, ScheduleType scheduleType, Long allLessonsDurationInMinutes, List<DayOfWeekWithTimes> daysOfWeekWithTimes, List<String> titles, SubdomainEntity subdomainEntity, TutorEntity tutorEntity) {
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        this.scheduleType = scheduleType;
        this.allLessonsDurationInMinutes = allLessonsDurationInMinutes;
        this.daysOfWeekWithTimes = daysOfWeekWithTimes;
        this.titles = titles;
        this.subdomainEntity = subdomainEntity;
        this.tutorEntity = tutorEntity;
    }
}
