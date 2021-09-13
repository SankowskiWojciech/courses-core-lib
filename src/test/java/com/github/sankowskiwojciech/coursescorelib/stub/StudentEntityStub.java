package com.github.sankowskiwojciech.coursescorelib.stub;

import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentEntityStub {
    public static StudentEntity create() {
        return StudentEntity.builder()
                .emailAddress(STUDENT_EMAIL_ADDRESS_STUB)
                .firstName(STUDENT_FIRST_NAME_STUB)
                .lastName(STUDENT_LAST_NAME_STUB)
                .build();
    }
}
