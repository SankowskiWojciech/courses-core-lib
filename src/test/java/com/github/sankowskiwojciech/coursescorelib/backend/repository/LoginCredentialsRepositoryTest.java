package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.login.LoginCredentialsEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LoginCredentialsRepositoryTest {
    @Autowired
    private LoginCredentialsRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<LoginCredentialsEntity> entities = testee.findAll();

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldReturnTrueWhenEntityExistsByEmailAddress() {
        //given
        String emailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;

        //when
        Optional<LoginCredentialsEntity> entity = testee.findById(emailAddressStub);

        //then
        assertTrue(entity.isPresent());
    }
}