package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.lessonfile.LessonFileEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.lessonfile.LessonFileWithoutContent;
import com.github.sankowskiwojciech.coursescorelib.stub.LessonFileEntityStub;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LessonFileRepositoryTest {

    private static final int FIND_ALL_BY_CREATED_BY_EXPECTED_LIST_SIZE = 3;

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
        String lessonFileId = FILE_ID_STUB;

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

    @Test
    public void shouldFindAllEntitiesWithoutFileContentByFileIdsCorrectly() {
        //given
        Set<String> fileIdsStub = Sets.newHashSet("65462773-84dc-4738-816b-d044409498bf", "93a86ee9-b655-4d24-aa0d-4e3a051f6111", "3f3ab813-25bc-41fb-9e26-3055cfbb9aa2");

        //when
        List<LessonFileWithoutContent> lessonFilesWithoutContent = testee.findAllByFileIdIn(fileIdsStub);

        //then
        assertNotNull(lessonFilesWithoutContent);
        assertFalse(lessonFilesWithoutContent.isEmpty());
    }

    @Test
    public void shouldGetFileOwnerCorrectly() {
        //given
        String lessonFileId = FILE_ID_STUB;

        //when
        String fileOwnerId = testee.getFileOwnerId(lessonFileId);

        //then
        assertEquals(TUTOR_EMAIL_ADDRESS_STUB, fileOwnerId);
    }

    @Test
    public void shouldFindAllByCreatedByCorrectly() {
        //given
        String fileOwnerIdStub = TUTOR_EMAIL_ADDRESS_STUB;

        //when
        List<LessonFileWithoutContent> lessonFilesWithoutContent = testee.findAllByCreatedBy(fileOwnerIdStub);

        //then
        assertNotNull(lessonFilesWithoutContent);
        assertFalse(lessonFilesWithoutContent.isEmpty());
        assertEquals(FIND_ALL_BY_CREATED_BY_EXPECTED_LIST_SIZE, lessonFilesWithoutContent.size());
    }
}