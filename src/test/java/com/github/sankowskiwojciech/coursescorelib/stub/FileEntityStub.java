package com.github.sankowskiwojciech.coursescorelib.stub;

import com.github.sankowskiwojciech.coursescorelib.model.db.file.FileEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FileEntityStub {
    public static FileEntity create() {
        return FileEntity.builder()
                .name(FILE_NAME_STUB)
                .extension(FILE_EXTENSION_STUB)
                .content(FILE_CONTENT_STUB)
                .createdBy(TUTOR_EMAIL_ADDRESS_STUB)
                .creationDateTime(LocalDateTime.now())
                .build();
    }
}
