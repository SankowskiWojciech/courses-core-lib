package com.github.sankowskiwojciech.coursescorelib.stub;

import com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson.IndividualLessonFileEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IndividualLessonFileEntityStub {

    public static IndividualLessonFileEntity create(long individualLessonId, long fileId) {
        return IndividualLessonFileEntity.builder()
                .lessonId(individualLessonId)
                .fileId(fileId)
                .build();
    }
}
