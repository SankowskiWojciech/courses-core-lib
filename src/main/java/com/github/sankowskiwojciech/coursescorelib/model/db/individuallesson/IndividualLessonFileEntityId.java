package com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class IndividualLessonFileEntityId implements Serializable {
    private String lessonId;
    private String fileId;
}
