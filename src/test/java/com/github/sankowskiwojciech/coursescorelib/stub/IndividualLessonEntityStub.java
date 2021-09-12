package com.github.sankowskiwojciech.coursescorelib.stub;

import com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson.IndividualLessonEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.LESSON_DESCRIPTION_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.LESSON_TITLE_STUB;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IndividualLessonEntityStub {
    public static IndividualLessonEntity createWithExternalEntities(OrganizationEntity organizationEntity, TutorEntity tutorEntity, StudentEntity studentEntity) {
        final IndividualLessonEntity entity = create();
        entity.setOrganizationEntity(organizationEntity);
        entity.setTutorEntity(tutorEntity);
        entity.setStudentEntity(studentEntity);
        return entity;
    }

    public static IndividualLessonEntity createWithDatesOfLesson(LocalDateTime startDate, LocalDateTime endDate) {
        final IndividualLessonEntity entity = create();
        entity.setStartDate(startDate);
        entity.setEndDate(endDate);
        return entity;
    }

    private static IndividualLessonEntity create() {
        final LocalDateTime currentDateTime = LocalDateTime.now().plusHours(1);
        return new IndividualLessonEntity(null, LESSON_TITLE_STUB, currentDateTime, currentDateTime.plusHours(3), LESSON_DESCRIPTION_STUB, currentDateTime, currentDateTime.plusMinutes(30), OrganizationEntityStub.create(), TutorEntityStub.create(), StudentEntityStub.create());
    }
}
