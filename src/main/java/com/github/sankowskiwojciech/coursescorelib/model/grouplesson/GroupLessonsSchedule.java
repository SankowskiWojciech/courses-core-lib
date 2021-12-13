package com.github.sankowskiwojciech.coursescorelib.model.grouplesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.group.GroupEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.DayOfWeekWithTimes;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.LessonsSchedule;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.ScheduleType;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class GroupLessonsSchedule extends LessonsSchedule {
    private final GroupEntity groupEntity;

    public GroupLessonsSchedule(LocalDate beginningDate, LocalDate endDate, ScheduleType scheduleType, Long allLessonsDurationInMinutes, List<DayOfWeekWithTimes> lessonsDaysOfWeekWithTimes, List<String> lessonsTitles, SubdomainEntity subdomainEntity, TutorEntity tutorEntity, GroupEntity groupEntity) {
        super(beginningDate, endDate, scheduleType, allLessonsDurationInMinutes, lessonsDaysOfWeekWithTimes, lessonsTitles, subdomainEntity, tutorEntity);
        this.groupEntity = groupEntity;
    }
}
