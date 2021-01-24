package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LessonFileResponse {
    private String fileId;
    private String name;
    private String extension;
    private String createdBy;
    private LocalDateTime creationDateTime;
}
