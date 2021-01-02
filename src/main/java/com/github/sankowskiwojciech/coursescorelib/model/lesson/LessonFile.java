package com.github.sankowskiwojciech.coursescorelib.model.lesson;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LessonFile {
    private final long fileId;
    private final String name;
    private final String extension;
    private final byte[] content;
    private final String createdBy;
    private final LocalDateTime creationDateTime;
}
