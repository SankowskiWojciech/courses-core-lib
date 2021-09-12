package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson.IndividualLessonEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursescorelib.stub.*;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IndividualLessonRepositoryTest {
    @Autowired
    private IndividualLessonRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<IndividualLessonEntity> entities = testee.findAll();

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindEntityByIdCorrectly() {
        //given
        String lessonIdStub = INDIVIDUAL_LESSON_ID_STUB;
        String organizationEmailAddressStub = ORGANIZATION_EMAIL_ADDRESS_STUB;
        String tutorEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;
        String studentEmailAddressStub = STUDENT_EMAIL_ADDRESS_STUB;

        //when
        Optional<IndividualLessonEntity> entityOptional = testee.findById(lessonIdStub);

        //then
        assertTrue(entityOptional.isPresent());
        IndividualLessonEntity entity = entityOptional.get();
        assertEquals(lessonIdStub, entity.getId());

        OrganizationEntity organizationEntity = entity.getOrganizationEntity();
        assertNotNull(organizationEntity);
        assertEquals(organizationEmailAddressStub, organizationEntity.getEmailAddress());

        TutorEntity tutorEntity = entity.getTutorEntity();
        assertNotNull(tutorEntity);
        assertEquals(tutorEmailAddressStub, tutorEntity.getEmailAddress());

        StudentEntity studentEntity = entity.getStudentEntity();
        assertNotNull(studentEntity);
        assertEquals(studentEmailAddressStub, studentEntity.getEmailAddress());
    }

    @Test
    public void shouldSaveEntityCorrectly() {
        //given
        OrganizationEntity organizationEntityStub = OrganizationEntityStub.create();
        TutorEntity tutorEntityStub = TutorEntityStub.create();
        StudentEntity studentEntityStub = StudentEntityStub.create();
        IndividualLessonEntity entityStub = IndividualLessonEntityStub.createWithExternalEntities(organizationEntityStub, tutorEntityStub, studentEntityStub);

        //when
        IndividualLessonEntity savedEntity = testee.save(entityStub);

        //then
        assertNotNull(savedEntity);
        assertEquals(entityStub.getId(), savedEntity.getId());
        assertEquals(entityStub.getTitle(), savedEntity.getTitle());
        assertEquals(entityStub.getStartDate(), savedEntity.getStartDate());
        assertEquals(entityStub.getEndDate(), savedEntity.getEndDate());
        assertEquals(entityStub.getDescription(), savedEntity.getDescription());
    }

    @Test
    public void shouldFindAllIndividualLessonsWhichCanCollideWithNewIndividualLesson() {
        //given
        final LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime existingLessonStartDate = currentDateTime;
        LocalDateTime existingLessonEndDate = currentDateTime.plusHours(2);
        IndividualLessonEntity existingLessonStub = IndividualLessonEntityStub.createWithDatesOfLesson(existingLessonStartDate, existingLessonEndDate);
        LocalDateTime newLessonStartDate = currentDateTime.minusHours(1);
        LocalDateTime newLessonEndDate = currentDateTime.plusHours(1);
        String tutorEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;

        testee.save(existingLessonStub);

        //when
        List<IndividualLessonEntity> entities = testee.findAllLessonsWhichCanCollideWithNewLesson(newLessonStartDate, newLessonEndDate, tutorEmailAddressStub);

        //then
        assertNotNull(entities);
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindAllIndividualLessonsInRangeForTutor() {
        //given
        final LocalDateTime currentDate = LocalDate.now().atStartOfDay();
        LocalDateTime existingLessonStartDate = currentDate.minusDays(2);
        LocalDateTime existingLessonEndDate = currentDate.plusDays(3);
        IndividualLessonEntity existingLessonStub = IndividualLessonEntityStub.createWithDatesOfLesson(currentDate, currentDate.plusHours(2));
        String tutorEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;

        testee.save(existingLessonStub);

        //when
        List<IndividualLessonEntity> entities = testee.findAllLessonsInRangeForTutor(existingLessonStartDate, existingLessonEndDate, tutorEmailAddressStub);

        //then
        assertNotNull(entities);
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByTutorIdAndLessonsIdsCorrectly() {
        //given
        String tutorIdStub = TUTOR_EMAIL_ADDRESS_STUB;
        List<String> lessonsIdStubs = Lists.newArrayList("f0604742-8031-4d8a-b6e4-a9d7faaaaba3", "93ec0365-1c31-4fb3-b90b-b92d89ea8cfa", "21809b9c-1cf6-482f-a67f-6283c23a85f8", "f88ec986-e473-48d2-85fe-1eecaa39f10a");

        //when
        List<IndividualLessonEntity> entities = testee.findAllByUserIdAndLessonsIds(tutorIdStub, lessonsIdStubs);

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByStudentIdAndLessonsIdsCorrectly() {
        //given
        String studentIdStub = STUDENT_EMAIL_ADDRESS_STUB;
        List<String> lessonsIdStubs = Lists.newArrayList("f0604742-8031-4d8a-b6e4-a9d7faaaaba3", "93ec0365-1c31-4fb3-b90b-b92d89ea8cfa", "21809b9c-1cf6-482f-a67f-6283c23a85f8", "f88ec986-e473-48d2-85fe-1eecaa39f10a");

        //when
        List<IndividualLessonEntity> entities = testee.findAllByUserIdAndLessonsIds(studentIdStub, lessonsIdStubs);

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByUserIdCorrectly() {
        //given
        String tutorIdStub = TUTOR_EMAIL_ADDRESS_STUB;

        //when
        List<IndividualLessonEntity> entities = testee.findAllByUserId(tutorIdStub);

        //then
        assertFalse(entities.isEmpty());
    }
}