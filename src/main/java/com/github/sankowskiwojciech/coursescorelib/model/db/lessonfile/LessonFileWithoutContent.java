package com.github.sankowskiwojciech.coursescorelib.model.db.lessonfile;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class LessonFileWithoutContent {
    private long fileId;
    private String name;
    private String extension;
    private String createdBy;
    private LocalDateTime creationDateTime;
}
