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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        long lessonId = INDIVIDUAL_LESSON_ID_STUB;
        long fileId = FILE_ID_STUB;

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
        long lessonIdStub = INDIVIDUAL_LESSON_ID_STUB;

        //when
        List<IndividualLessonFileEntity> individualLessonFileEntities = testee.findAllByLessonId(lessonIdStub);

        //then
        assertNotNull(individualLessonFileEntities);
        assertFalse(individualLessonFileEntities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByFileIdCorrectly() {
        //given
        long fileIdStub = FILE_ID_STUB;

        //when
        List<IndividualLessonFileEntity> individualLessonFileEntities = testee.findAllByFileId(fileIdStub);

        //then
        assertNotNull(individualLessonFileEntities);
        assertFalse(individualLessonFileEntities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByLessonIdFromListCorrectly() {
        //given
        List<Long> lessonsIdsStub = Lists.newArrayList(1L, 2L);

        //when
        List<IndividualLessonFileEntity> individualLessonFileEntities = testee.findAllByLessonIdIn(lessonsIdsStub);

        //then
        assertNotNull(individualLessonFileEntities);
        assertFalse(individualLessonFileEntities.isEmpty());
    }
}