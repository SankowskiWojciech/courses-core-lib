package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.lessonfile.LessonFileEntity;
import com.github.sankowskiwojciech.coursescorelib.stub.LessonFileEntityStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_CONTENT_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_EXTENSION_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_ID_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_NAME_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LessonFileRepositoryTest {

    @Autowired
    private LessonFileRepository testee;

    @Test
    public void shouldSaveEntityCorrectly() {
        //given
        LessonFileEntity lessonFileEntityStub = LessonFileEntityStub.create();

        //when
        LessonFileEntity savedLessonFileEntity = testee.save(lessonFileEntityStub);

        //then
        assertNotNull(savedLessonFileEntity);
        assertEquals(lessonFileEntityStub.getName(), savedLessonFileEntity.getName());
        assertEquals(lessonFileEntityStub.getExtension(), savedLessonFileEntity.getExtension());
        assertEquals(new String(lessonFileEntityStub.getContent()), new String(savedLessonFileEntity.getContent()));
        assertEquals(lessonFileEntityStub.getCreatedBy(), savedLessonFileEntity.getCreatedBy());
        assertEquals(lessonFileEntityStub.getCreationDateTime(), savedLessonFileEntity.getCreationDateTime());
    }

    @Test
    public void shouldFindEntityByIdCorrectly() {
        //given
        long lessonFileId = FILE_ID_STUB;

        //when
        Optional<LessonFileEntity> foundLessonFileEntityOptional = testee.findById(lessonFileId);

        //then
        assertNotNull(foundLessonFileEntityOptional);
        assertTrue(foundLessonFileEntityOptional.isPresent());
        LessonFileEntity lessonFileEntity = foundLessonFileEntityOptional.get();
        assertEquals(FILE_NAME_STUB, lessonFileEntity.getName());
        assertEquals(FILE_EXTENSION_STUB, lessonFileEntity.getExtension());
        assertEquals(new String(FILE_CONTENT_STUB), new String(lessonFileEntity.getContent()));
        assertEquals(TUTOR_EMAIL_ADDRESS_STUB, lessonFileEntity.getCreatedBy());
        assertNotNull(lessonFileEntity.getCreationDateTime());
    }
}