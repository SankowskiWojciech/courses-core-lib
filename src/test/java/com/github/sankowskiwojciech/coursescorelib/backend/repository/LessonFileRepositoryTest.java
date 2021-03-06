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

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_CONTENT_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_EXTENSION_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_ID_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.FILE_NAME_STUB;
import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void shouldFindAllEntitiesWithoutFileContentByFileIdsCorrectly() {
        //given
        Set<Long> fileIdsStub = Sets.newHashSet(1L, 2L, 3L);

        //when
        List<LessonFileWithoutContent> lessonFilesWithoutContent = testee.findAllByFileIdIn(fileIdsStub);

        //then
        assertNotNull(lessonFilesWithoutContent);
        assertFalse(lessonFilesWithoutContent.isEmpty());
    }

    @Test
    public void shouldGetFileOwnerCorrectly() {
        //given
        long lessonFileId = FILE_ID_STUB;

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