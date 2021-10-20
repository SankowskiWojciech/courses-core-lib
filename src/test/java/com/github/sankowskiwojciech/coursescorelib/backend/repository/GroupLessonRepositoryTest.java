package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.grouplesson.GroupLessonEntity;
import com.github.sankowskiwojciech.coursestestlib.stub.GroupLessonEntityStub;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        Assert.assertFalse(entities.isEmpty());
    }
}