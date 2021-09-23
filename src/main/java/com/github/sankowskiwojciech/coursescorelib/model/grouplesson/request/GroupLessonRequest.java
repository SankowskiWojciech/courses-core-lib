package com.github.sankowskiwojciech.coursescorelib.model.grouplesson.request;

import com.github.sankowskiwojciech.coursescorelib.model.lesson.request.LessonRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class GroupLessonRequest extends LessonRequest {
    private final String groupId;

    public GroupLessonRequest(String title, LocalDateTime startDateOfLesson, LocalDateTime endDateOfLesson, String description, String subdomainAlias, String tutorId, List<String> filesIds, String groupId) {
        super(title, startDateOfLesson, endDateOfLesson, description, subdomainAlias, tutorId, filesIds);
        this.groupId = groupId;
    }
}
