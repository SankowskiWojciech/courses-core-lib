package com.github.sankowskiwojciech.coursescorelib.stub;

import com.github.sankowskiwojciech.coursescorelib.model.db.lessonfile.LessonFileEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_CONTENT_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_EXTENSION_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_NAME_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LessonFileEntityStub {
    public static LessonFileEntity create() {
        return LessonFileEntity.builder()
                .name(FILE_NAME_STUB)
                .extension(FILE_EXTENSION_STUB)
                .content(FILE_CONTENT_STUB)
                .createdBy(TUTOR_EMAIL_ADDRESS_STUB)
                .creationDateTime(LocalDateTime.now())
                .build();
    }
}
