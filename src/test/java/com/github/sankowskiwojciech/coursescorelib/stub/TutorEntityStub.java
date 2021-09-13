package com.github.sankowskiwojciech.coursescorelib.stub;

import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TutorEntityStub {
    public static TutorEntity create() {
        return TutorEntity.builder()
                .emailAddress(TUTOR_EMAIL_ADDRESS_STUB)
                .alias(TUTOR_ALIAS_STUB)
                .firstName(TUTOR_FIRST_NAME_STUB)
                .lastName(TUTOR_LAST_NAME_STUB)
                .description(TUTOR_DESCRIPTION_STUB)
                .phoneNumber(TUTOR_PHONE_NUMBER_STUB)
                .build();
    }
}
