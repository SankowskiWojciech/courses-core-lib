package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LessonFile {
    private long fileId;
    private String name;
    private String extension;
    private byte[] content;
    private String createdBy;
    private LocalDateTime creationDateTime;
}
