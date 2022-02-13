package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.file.FileUserPermissionsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FileUserPermissionsRepositoryTest {
    @Autowired
    private FileUserPermissionsRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<FileUserPermissionsEntity> entities = testee.findAll();

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesByUserIdAndCanReadTrue() {
        //given
        String userIdStub = TUTOR_EMAIL_ADDRESS_STUB;

        //when
        List<FileUserPermissionsEntity> entities = testee.findAllByFileUserPermissionsEntityIdUserIdAndCanReadIsTrue(userIdStub);

        //then
        assertFalse(entities.isEmpty());
    }
}