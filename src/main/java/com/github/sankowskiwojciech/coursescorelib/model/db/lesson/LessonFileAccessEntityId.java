package com.github.sankowskiwojciech.coursescorelib.model.db.lesson;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class LessonFileAccessEntityId implements Serializable {
    private String lessonId;
    private String fileId;
}
