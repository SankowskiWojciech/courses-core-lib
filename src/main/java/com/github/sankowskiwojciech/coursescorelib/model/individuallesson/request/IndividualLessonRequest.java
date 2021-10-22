package com.github.sankowskiwojciech.coursescorelib.model.individuallesson.request;

import com.github.sankowskiwojciech.coursescorelib.model.lesson.request.LessonRequest;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class IndividualLessonRequest extends LessonRequest {
    private final String studentId;

    public IndividualLessonRequest(String title, LocalDateTime startDateOfLesson, LocalDateTime endDateOfLesson, String description, String subdomainAlias, List<String> filesIds, String studentId) {
        super(title, startDateOfLesson, endDateOfLesson, description, subdomainAlias, filesIds);
        this.studentId = studentId;
    }
}
