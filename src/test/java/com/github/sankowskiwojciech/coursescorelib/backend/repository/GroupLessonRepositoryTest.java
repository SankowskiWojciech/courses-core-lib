package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.group.GroupEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.grouplesson.GroupLessonEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursestestlib.stub.GroupEntityStub;
import com.github.sankowskiwojciech.coursestestlib.stub.GroupLessonEntityStub;
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

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GroupLessonRepositoryTest {
    @Autowired
    private GroupLessonRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<GroupLessonEntity> entities = testee.findAll();

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldSaveEntityCorrectly() {
        //given
        SubdomainEntity subdomainEntityStub = SubdomainEntityStub.create();
        TutorEntity tutorEntityStub = TutorEntityStub.create();
        GroupEntity groupEntity = GroupEntityStub.create();
        GroupLessonEntity entityStub = GroupLessonEntityStub.createWithExternalEntities(subdomainEntityStub, tutorEntityStub, groupEntity);

        //when
        GroupLessonEntity savedEntity = testee.save(entityStub);

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
        GroupLessonEntity existingLessonStub = GroupLessonEntityStub.createWithDatesOfLesson(existingLessonStartDate, existingLessonEndDate);
        LocalDateTime newLessonStartDate = currentDateTime.minusHours(1);
        LocalDateTime newLessonEndDate = currentDateTime.plusHours(1);
        String tutorEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;

        testee.save(existingLessonStub);

        //when
        List<GroupLessonEntity> entities = testee.findAllLessonsWhichCanCollideWithNewLesson(newLessonStartDate, newLessonEndDate, tutorEmailAddressStub);

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
        GroupLessonEntity existingLessonStub = GroupLessonEntityStub.createWithDatesOfLesson(currentDate, currentDate.plusHours(2));
        String tutorEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;

        testee.save(existingLessonStub);

        //when
        List<GroupLessonEntity> entities = testee.findAllLessonsInRangeForTutor(existingLessonStartDate, existingLessonEndDate, tutorEmailAddressStub);

        //then
        assertNotNull(entities);
        assertFalse(entities.isEmpty());
    }
}