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

    public GroupLessonRequest(String title, LocalDateTime startDate, LocalDateTime endDate, String description, String subdomainAlias, List<String> filesIds, String groupId) {
        super(title, startDate, endDate, description, subdomainAlias, filesIds);
        this.groupId = groupId;
    }
}
