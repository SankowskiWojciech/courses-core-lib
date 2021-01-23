package com.github.sankowskiwojciech.coursescorelib.model.grouplesson.request;

import com.github.sankowskiwojciech.coursescorelib.model.lesson.DayOfWeekWithTimes;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.ScheduleType;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.request.LessonsScheduleRequest;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class GroupLessonsScheduleRequest extends LessonsScheduleRequest {
    private final String groupId;

    public GroupLessonsScheduleRequest(LocalDate beginningDate, LocalDate endDate, ScheduleType scheduleType, Long allLessonsDurationInMinutes, List<DayOfWeekWithTimes> lessonsDaysOfWeekWithTimes, List<String> lessonsTitles, String subdomainAlias, String tutorId, String groupId) {
        super(beginningDate, endDate, scheduleType, allLessonsDurationInMinutes, lessonsDaysOfWeekWithTimes, lessonsTitles, subdomainAlias, tutorId);
        this.groupId = groupId;
    }
}
