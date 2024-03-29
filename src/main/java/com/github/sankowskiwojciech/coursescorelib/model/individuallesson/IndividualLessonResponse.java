package com.github.sankowskiwojciech.coursescorelib.model.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.lesson.LessonFileResponse;
import com.github.sankowskiwojciech.coursescorelib.model.lesson.LessonResponse;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class IndividualLessonResponse extends LessonResponse {
    private final String studentFullName;
    private final String studentEmailAddress;

    public IndividualLessonResponse(String lessonId, String title, LocalDateTime startDateOfLesson, LocalDateTime endDateOfLesson, String description, String subdomainAlias, String tutorEmailAddress, List<LessonFileResponse> filesInformation, String studentFullName, String studentEmailAddress) {
        super(lessonId, title, startDateOfLesson, endDateOfLesson, description, subdomainAlias, tutorEmailAddress, filesInformation);
        this.studentFullName = studentFullName;
        this.studentEmailAddress = studentEmailAddress;
    }
}
