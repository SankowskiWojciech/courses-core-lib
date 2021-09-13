package com.github.sankowskiwojciech.coursescorelib.model.db.file;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class FileWithoutContent {
    String id;
    String name;
    String extension;
    String createdBy;
    LocalDateTime creationDateTime;
}
