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
    private final Long durationOfAllLessonsInMinutes;
    private final List<DayOfWeekWithTimes> daysOfWeekWithTimes;
    private final List<String> titles;
    private final String subdomainAlias;

    public LessonsScheduleRequest(LocalDate beginningDate, LocalDate endDate, ScheduleType scheduleType, Long durationOfAllLessonsInMinutes, List<DayOfWeekWithTimes> daysOfWeekWithTimes, List<String> titles, String subdomainAlias) {
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        this.scheduleType = scheduleType;
        this.durationOfAllLessonsInMinutes = durationOfAllLessonsInMinutes;
        this.daysOfWeekWithTimes = daysOfWeekWithTimes;
        this.titles = titles;
        this.subdomainAlias = subdomainAlias;
    }
}
