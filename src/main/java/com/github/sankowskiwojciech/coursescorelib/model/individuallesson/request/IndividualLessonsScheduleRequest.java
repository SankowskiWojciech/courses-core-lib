package com.github.sankowskiwojciech.coursescorelib.model.individuallesson.request;

import com.github.sankowskiwojciech.coursescorelib.model.lesson.DayOfWeekWithTimes;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.ScheduleType;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.request.LessonsScheduleRequest;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class IndividualLessonsScheduleRequest extends LessonsScheduleRequest {
    private final String studentId;

    public IndividualLessonsScheduleRequest(LocalDate beginningDate, LocalDate endDate, ScheduleType scheduleType, Long allLessonsDurationInMinutes, List<DayOfWeekWithTimes> lessonsDaysOfWeekWithTimes, List<String> lessonsTitles, String subdomainAlias, String studentId) {
        super(beginningDate, endDate, scheduleType, allLessonsDurationInMinutes, lessonsDaysOfWeekWithTimes, lessonsTitles, subdomainAlias);
        this.studentId = studentId;
    }
}
