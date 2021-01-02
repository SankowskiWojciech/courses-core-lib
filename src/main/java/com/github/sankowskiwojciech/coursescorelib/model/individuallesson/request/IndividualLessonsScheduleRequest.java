package com.github.sankowskiwojciech.coursescorelib.model.individuallesson.request;

import com.github.sankowskiwojciech.coursescorelib.model.lesson.DayOfWeekWithTimes;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.ScheduleType;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class IndividualLessonsScheduleRequest {
    private final LocalDate beginningDate;
    private final LocalDate endDate;
    private final ScheduleType scheduleType;
    private final Long allLessonsDurationInMinutes;
    private final List<DayOfWeekWithTimes> lessonsDaysOfWeekWithTimes;
    private final List<String> lessonsTitles;
    private final String subdomainName;
    private final String tutorId;
    private final String studentId;
}
