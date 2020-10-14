package com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class IndividualLessonFileEntityId implements Serializable {
    private long lessonId;
    private long fileId;
}
