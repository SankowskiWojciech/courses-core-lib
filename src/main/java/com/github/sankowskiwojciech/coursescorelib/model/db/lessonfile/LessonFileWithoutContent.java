package com.github.sankowskiwojciech.coursescorelib.model.db.lessonfile;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class LessonFileWithoutContent {
    String fileId;
    String name;
    String extension;
    String createdBy;
    LocalDateTime creationDateTime;
}
