package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson.IndividualLessonFileEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson.IndividualLessonFileEntityId;
import com.github.sankowskiwojciech.coursescorelib.stub.IndividualLessonFileEntityStub;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_ID_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.INDIVIDUAL_LESSON_ID_STUB;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IndividualLessonFileRepositoryTest {

    @Autowired
    private IndividualLessonFileRepository testee;

    @Test
    public void shouldSaveEntityCorrectly() {
        //given
        IndividualLessonFileEntity individualLessonFileEntityStub = IndividualLessonFileEntityStub.create(INDIVIDUAL_LESSON_ID_STUB, FILE_ID_STUB);

        //when
        IndividualLessonFileEntity savedIndividualLessonFileEntity = testee.save(individualLessonFileEntityStub);

        //then
        assertNotNull(savedIndividualLessonFileEntity);
        assertEquals(INDIVIDUAL_LESSON_ID_STUB, savedIndividualLessonFileEntity.getLessonId());
        assertEquals(FILE_ID_STUB, savedIndividualLessonFileEntity.getFileId());
    }

    @Test
    public void shouldFindEntityByIdCorrectly() {
        //given
        String lessonId = INDIVIDUAL_LESSON_ID_STUB;
        String fileId = FILE_ID_STUB;

        //when
        Optional<IndividualLessonFileEntity> foundIndividualLessonFileEntityOptional = testee.findById(new IndividualLessonFileEntityId(lessonId, fileId));

        //then
        assertNotNull(foundIndividualLessonFileEntityOptional);
        assertTrue(foundIndividualLessonFileEntityOptional.isPresent());
        IndividualLessonFileEntity foundIndividualLessonFileEntity = foundIndividualLessonFileEntityOptional.get();
        assertEquals(lessonId, foundIndividualLessonFileEntity.getLessonId());
        assertEquals(fileId, foundIndividualLessonFileEntity.getFileId());
    }

    @Test
    public void shouldFindAllEntitiesByLessonIdCorrectly() {
        //given
        String lessonIdStub = INDIVIDUAL_LESSON_ID_STUB;

        //when
        List<IndividualLessonFileEntity> individualLessonFileEntities = testee.findAllByLessonId(lessonIdStub);

        //then
        assertNotNull(individualLessonFileEntities);
        assertFalse(individualLessonFileEntities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByFileIdCorrectly() {
        //given
        String fileIdStub = FILE_ID_STUB;

        //when
        List<IndividualLessonFileEntity> individualLessonFileEntities = testee.findAllByFileId(fileIdStub);

        //then
        assertNotNull(individualLessonFileEntities);
        assertFalse(individualLessonFileEntities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByLessonIdFromListCorrectly() {
        //given
        List<String> lessonsIdsStub = Lists.newArrayList("f0604742-8031-4d8a-b6e4-a9d7faaaaba3", "7d0ae6d0-7da0-4a36-9876-ee8881b9ceae");

        //when
        List<IndividualLessonFileEntity> individualLessonFileEntities = testee.findAllByLessonIdIn(lessonsIdsStub);

        //then
        assertNotNull(individualLessonFileEntities);
        assertFalse(individualLessonFileEntities.isEmpty());
    }
}