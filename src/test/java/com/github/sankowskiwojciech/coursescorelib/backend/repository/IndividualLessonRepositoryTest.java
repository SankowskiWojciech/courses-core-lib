package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson.IndividualLessonEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursestestlib.stub.IndividualLessonEntityStub;
import com.github.sankowskiwojciech.coursestestlib.stub.StudentEntityStub;
import com.github.sankowskiwojciech.coursestestlib.stub.SubdomainEntityStub;
import com.github.sankowskiwojciech.coursestestlib.stub.TutorEntityStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.INDIVIDUAL_LESSON_ID_STUB;
import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.ORGANIZATION_ALIAS_STUB;
import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.STUDENT_EMAIL_ADDRESS_STUB;
import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        String idStub = INDIVIDUAL_LESSON_ID_STUB;
        String subdomainAlias = ORGANIZATION_ALIAS_STUB;
        String tutorEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;
        String studentEmailAddressStub = STUDENT_EMAIL_ADDRESS_STUB;

        //when
        Optional<IndividualLessonEntity> entityOptional = testee.findById(idStub);

        //then
        assertTrue(entityOptional.isPresent());
        IndividualLessonEntity entity = entityOptional.get();
        assertEquals(idStub, entity.getId());

        SubdomainEntity subdomainEntity = entity.getSubdomainEntity();
        assertNotNull(subdomainEntity);
        assertEquals(subdomainAlias, subdomainEntity.getSubdomainId());

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
        SubdomainEntity subdomainEntityStub = SubdomainEntityStub.create();
        TutorEntity tutorEntityStub = TutorEntityStub.create();
        StudentEntity studentEntityStub = StudentEntityStub.create();
        IndividualLessonEntity entityStub = IndividualLessonEntityStub.createWithExternalEntities(subdomainEntityStub, tutorEntityStub, studentEntityStub);

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
    public void shouldFindAllEntitiesByUserIdCorrectly() {
        //given
        String tutorIdStub = TUTOR_EMAIL_ADDRESS_STUB;

        //when
        List<IndividualLessonEntity> entities = testee.findAllByUserId(tutorIdStub);

        //then
        assertFalse(entities.isEmpty());
    }
}