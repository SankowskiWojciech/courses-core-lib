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
        List<IndividualLessonEntity> individualLessonEntities = testee.findAll();

        //then
        assertFalse(individualLessonEntities.isEmpty());
    }

    @Test
    public void shouldFindEntityByIdCorrectly() {
        //given
        String individualLessonIdStub = INDIVIDUAL_LESSON_ID_STUB;
        String organizationEmailAddressStub = ORGANIZATION_EMAIL_ADDRESS_STUB;
        String tutorEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;
        String studentEmailAddressStub = STUDENT_EMAIL_ADDRESS_STUB;

        //when
        Optional<IndividualLessonEntity> individualLessonEntityOptional = testee.findById(individualLessonIdStub);

        //then
        assertTrue(individualLessonEntityOptional.isPresent());
        IndividualLessonEntity individualLessonEntity = individualLessonEntityOptional.get();
        assertEquals(individualLessonIdStub, individualLessonEntity.getLessonId());

        OrganizationEntity organizationEntity = individualLessonEntity.getOrganizationEntity();
        assertNotNull(organizationEntity);
        assertEquals(organizationEmailAddressStub, organizationEntity.getEmailAddress());

        TutorEntity tutorEntity = individualLessonEntity.getTutorEntity();
        assertNotNull(tutorEntity);
        assertEquals(tutorEmailAddressStub, tutorEntity.getEmailAddress());

        StudentEntity studentEntity = individualLessonEntity.getStudentEntity();
        assertNotNull(studentEntity);
        assertEquals(studentEmailAddressStub, studentEntity.getEmailAddress());
    }

    @Test
    public void shouldSaveEntityCorrectly() {
        //given
        OrganizationEntity organizationEntityStub = OrganizationEntityStub.create();
        TutorEntity tutorEntityStub = TutorEntityStub.create();
        StudentEntity studentEntityStub = StudentEntityStub.create();
        IndividualLessonEntity individualLessonEntityStub = IndividualLessonEntityStub.createWithExternalEntities(organizationEntityStub, tutorEntityStub, studentEntityStub);

        //when
        IndividualLessonEntity savedIndividualLessonEntity = testee.save(individualLessonEntityStub);

        //then
        assertNotNull(savedIndividualLessonEntity);
        assertEquals(individualLessonEntityStub.getLessonId(), savedIndividualLessonEntity.getLessonId());
        assertEquals(individualLessonEntityStub.getTitle(), savedIndividualLessonEntity.getTitle());
        assertEquals(individualLessonEntityStub.getStartDateOfLesson(), savedIndividualLessonEntity.getStartDateOfLesson());
        assertEquals(individualLessonEntityStub.getEndDateOfLesson(), savedIndividualLessonEntity.getEndDateOfLesson());
        assertEquals(individualLessonEntityStub.getDescription(), savedIndividualLessonEntity.getDescription());
    }

    @Test
    public void shouldFindAllIndividualLessonsWhichCanCollideWithNewIndividualLesson() {
        //given
        final LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime existingIndividualLessonStartDate = currentDateTime;
        LocalDateTime existingIndividualLessonEndDate = currentDateTime.plusHours(2);
        IndividualLessonEntity existingIndividualLessonStub = IndividualLessonEntityStub.createWithDatesOfLesson(existingIndividualLessonStartDate, existingIndividualLessonEndDate);
        LocalDateTime newIndividualLessonStartDate = currentDateTime.minusHours(1);
        LocalDateTime newIndividualLessonEndDate = currentDateTime.plusHours(1);
        String tutorEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;
        String organizationEmailAddress = ORGANIZATION_EMAIL_ADDRESS_STUB;

        testee.save(existingIndividualLessonStub);

        //when
        List<IndividualLessonEntity> individualLessonEntities = testee.findAllLessonsWhichCanCollideWithNewLesson(newIndividualLessonStartDate, newIndividualLessonEndDate, tutorEmailAddressStub, organizationEmailAddress);

        //then
        assertNotNull(individualLessonEntities);
        assertFalse(individualLessonEntities.isEmpty());
    }

    @Test
    public void shouldFindAllIndividualLessonsInRangeForTutor() {
        //given
        final LocalDateTime currentDate = LocalDate.now().atStartOfDay();
        LocalDateTime existingIndividualLessonStartDate = currentDate.minusDays(2);
        LocalDateTime existingIndividualLessonEndDate = currentDate.plusDays(3);
        IndividualLessonEntity existingIndividualLessonStub = IndividualLessonEntityStub.createWithDatesOfLesson(currentDate, currentDate.plusHours(2));
        String tutorEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;
        String organizationEmailAddress = ORGANIZATION_EMAIL_ADDRESS_STUB;

        testee.save(existingIndividualLessonStub);

        //when
        List<IndividualLessonEntity> individualLessonEntities = testee.findAllLessonsInRangeForTutor(existingIndividualLessonStartDate, existingIndividualLessonEndDate, tutorEmailAddressStub, organizationEmailAddress);

        //then
        assertNotNull(individualLessonEntities);
        assertFalse(individualLessonEntities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByTutorIdAndLessonsIdsCorrectly() {
        //given
        String tutorIdStub = TUTOR_EMAIL_ADDRESS_STUB;
        List<String> lessonsIdsStub = Lists.newArrayList("f0604742-8031-4d8a-b6e4-a9d7faaaaba3", "93ec0365-1c31-4fb3-b90b-b92d89ea8cfa", "21809b9c-1cf6-482f-a67f-6283c23a85f8", "f88ec986-e473-48d2-85fe-1eecaa39f10a");

        //when
        List<IndividualLessonEntity> individualLessonEntities = testee.findAllByUserIdAndLessonsIds(tutorIdStub, lessonsIdsStub);

        //then
        assertFalse(individualLessonEntities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByStudentIdAndLessonsIdsCorrectly() {
        //given
        String studentIdStub = STUDENT_EMAIL_ADDRESS_STUB;
        List<String> lessonsIdsStub = Lists.newArrayList("f0604742-8031-4d8a-b6e4-a9d7faaaaba3", "93ec0365-1c31-4fb3-b90b-b92d89ea8cfa", "21809b9c-1cf6-482f-a67f-6283c23a85f8", "f88ec986-e473-48d2-85fe-1eecaa39f10a");

        //when
        List<IndividualLessonEntity> individualLessonEntities = testee.findAllByUserIdAndLessonsIds(studentIdStub, lessonsIdsStub);

        //then
        assertFalse(individualLessonEntities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByUserIdCorrectly() {
        //given
        String tutorIdStub = TUTOR_EMAIL_ADDRESS_STUB;

        //when
        List<IndividualLessonEntity> individualLessonEntities = testee.findAllByUserId(tutorIdStub);

        //then
        assertFalse(individualLessonEntities.isEmpty());
    }
}