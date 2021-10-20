package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.file.FileEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.file.FileWithoutContent;
import com.github.sankowskiwojciech.coursestestlib.stub.FileEntityStub;
import com.google.common.collect.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.FILE_CONTENT_STUB;
import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.FILE_EXTENSION_STUB;
import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.FILE_ID_STUB;
import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.FILE_NAME_STUB;
import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FileRepositoryTest {
    private static final int FIND_ALL_BY_CREATED_BY_EXPECTED_LIST_SIZE = 3;

    @Autowired
    private FileRepository testee;

    @Test
    public void shouldSaveEntityCorrectly() {
        //given
        FileEntity entityStub = FileEntityStub.create();

        //when
        FileEntity savedEntity = testee.save(entityStub);

        //then
        assertNotNull(savedEntity);
        assertEquals(entityStub.getName(), savedEntity.getName());
        assertEquals(entityStub.getExtension(), savedEntity.getExtension());
        assertEquals(new String(entityStub.getContent()), new String(savedEntity.getContent()));
        assertEquals(entityStub.getCreatedBy(), savedEntity.getCreatedBy());
        assertEquals(entityStub.getCreationDateTime(), savedEntity.getCreationDateTime());
    }

    @Test
    public void shouldFindEntityByIdCorrectly() {
        //given
        String idStub = FILE_ID_STUB;

        //when
        Optional<FileEntity> entityOptional = testee.findById(idStub);

        //then
        assertNotNull(entityOptional);
        assertTrue(entityOptional.isPresent());
        FileEntity entity = entityOptional.get();
        assertEquals(FILE_NAME_STUB, entity.getName());
        assertEquals(FILE_EXTENSION_STUB, entity.getExtension());
        assertEquals(new String(FILE_CONTENT_STUB), new String(entity.getContent()));
        assertEquals(TUTOR_EMAIL_ADDRESS_STUB, entity.getCreatedBy());
        assertNotNull(entity.getCreationDateTime());
    }

    @Test
    public void shouldFindAllEntitiesWithoutFileContentByIdsCorrectly() {
        //given
        Set<String> idStubs = Sets.newHashSet("65462773-84dc-4738-816b-d044409498bf", "93a86ee9-b655-4d24-aa0d-4e3a051f6111", "3f3ab813-25bc-41fb-9e26-3055cfbb9aa2");

        //when
        List<FileWithoutContent> files = testee.findAllByIdIn(idStubs);

        //then
        assertNotNull(files);
        assertFalse(files.isEmpty());
    }

    @Test
    public void shouldGetFileOwnerCorrectly() {
        //given
        String fileIdStub = FILE_ID_STUB;

        //when
        String fileOwnerId = testee.getFileOwnerIdByFileId(fileIdStub);

        //then
        assertEquals(TUTOR_EMAIL_ADDRESS_STUB, fileOwnerId);
    }

    @Test
    public void shouldFindAllByCreatedByCorrectly() {
        //given
        String fileOwnerIdStub = TUTOR_EMAIL_ADDRESS_STUB;

        //when
        List<FileWithoutContent> files = testee.findAllByCreatedBy(fileOwnerIdStub);

        //then
        assertNotNull(files);
        assertFalse(files.isEmpty());
        assertEquals(FIND_ALL_BY_CREATED_BY_EXPECTED_LIST_SIZE, files.size());
    }
}