package com.github.sankowskiwojciech.coursescorelib.model.grouplesson;

import com.github.sankowskiwojciech.coursescorelib.model.lesson.LessonFileResponse;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.LessonResponse;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class GroupLessonResponse extends LessonResponse {
    private final String groupName;

    public GroupLessonResponse(String lessonId, String title, LocalDateTime startDateOfLesson, LocalDateTime endDateOfLesson, String description, String subdomainAlias, String tutorEmailAddress, List<LessonFileResponse> filesInformation, String groupName) {
        super(lessonId, title, startDateOfLesson, endDateOfLesson, description, subdomainAlias, tutorEmailAddress, filesInformation);
        this.groupName = groupName;
    }
}
