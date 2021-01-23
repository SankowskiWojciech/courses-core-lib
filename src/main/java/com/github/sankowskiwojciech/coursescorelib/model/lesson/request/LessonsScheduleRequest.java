package com.github.sankowskiwojciech.coursescorelib.model.lesson.request;

import com.github.sankowskiwojciech.coursescorelib.model.lesson.DayOfWeekWithTimes;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.ScheduleType;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public abstract class LessonsScheduleRequest {
    private final LocalDate beginningDate;
    private final LocalDate endDate;
    private final ScheduleType scheduleType;
    private final Long allLessonsDurationInMinutes;
    private final List<DayOfWeekWithTimes> lessonsDaysOfWeekWithTimes;
    private final List<String> lessonsTitles;
    private final String subdomainAlias;
    private final String tutorId;


    public LessonsScheduleRequest(LocalDate beginningDate, LocalDate endDate, ScheduleType scheduleType, Long allLessonsDurationInMinutes, List<DayOfWeekWithTimes> lessonsDaysOfWeekWithTimes, List<String> lessonsTitles, String subdomainAlias, String tutorId) {
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        this.scheduleType = scheduleType;
        this.allLessonsDurationInMinutes = allLessonsDurationInMinutes;
        this.lessonsDaysOfWeekWithTimes = lessonsDaysOfWeekWithTimes;
        this.lessonsTitles = lessonsTitles;
        this.subdomainAlias = subdomainAlias;
        this.tutorId = tutorId;
    }
}
