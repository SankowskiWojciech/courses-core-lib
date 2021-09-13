package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.lesson.LessonFileAccessEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.lesson.LessonFileAccessEntityId;
import com.github.sankowskiwojciech.coursescorelib.stub.LessonFileAccessEntityStub;
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
public class LessonFileAccessRepositoryTest {
    @Autowired
    private LessonFileAccessRepository testee;

    @Test
    public void shouldSaveEntityCorrectly() {
        //given
        LessonFileAccessEntity entityStub = LessonFileAccessEntityStub.create(INDIVIDUAL_LESSON_ID_STUB, FILE_ID_STUB);

        //when
        LessonFileAccessEntity savedEntity = testee.save(entityStub);

        //then
        assertNotNull(savedEntity);
        assertEquals(INDIVIDUAL_LESSON_ID_STUB, savedEntity.getLessonId());
        assertEquals(FILE_ID_STUB, savedEntity.getFileId());
    }

    @Test
    public void shouldFindEntityByIdCorrectly() {
        //given
        String lessonIdStub = INDIVIDUAL_LESSON_ID_STUB;
        String fileIdStub = FILE_ID_STUB;

        //when
        Optional<LessonFileAccessEntity> entityOptional = testee.findById(new LessonFileAccessEntityId(lessonIdStub, fileIdStub));

        //then
        assertNotNull(entityOptional);
        assertTrue(entityOptional.isPresent());
        LessonFileAccessEntity entity = entityOptional.get();
        assertEquals(lessonIdStub, entity.getLessonId());
        assertEquals(fileIdStub, entity.getFileId());
    }

    @Test
    public void shouldFindAllEntitiesByLessonIdCorrectly() {
        //given
        String idStub = INDIVIDUAL_LESSON_ID_STUB;

        //when
        List<LessonFileAccessEntity> entities = testee.findAllByLessonId(idStub);

        //then
        assertNotNull(entities);
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByFileIdCorrectly() {
        //given
        String idStub = FILE_ID_STUB;

        //when
        List<LessonFileAccessEntity> entities = testee.findAllByFileId(idStub);

        //then
        assertNotNull(entities);
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByLessonIdFromListCorrectly() {
        //given
        List<String> idStubs = Lists.newArrayList("f0604742-8031-4d8a-b6e4-a9d7faaaaba3", "7d0ae6d0-7da0-4a36-9876-ee8881b9ceae");

        //when
        List<LessonFileAccessEntity> entities = testee.findAllByLessonIdIn(idStubs);

        //then
        assertNotNull(entities);
        assertFalse(entities.isEmpty());
    }
}