package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.token.TokenEntity;
import com.github.sankowskiwojciech.coursestestlib.stub.TokenEntityStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TOKEN_VALUE_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TokenRepositoryTest {
    @Autowired
    private TokenRepository testee;

    @Test
    public void shouldSaveEntityCorrectly() {
        //given
        TokenEntity entityStub = TokenEntityStub.create();

        //when
        TokenEntity savedEntity = testee.save(entityStub);

        //then
        assertEquals(entityStub, savedEntity);
    }

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<TokenEntity> entities = testee.findAll();

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindByTokenValueCorrectly() {
        //given
        String tokenValueStub = TOKEN_VALUE_STUB;

        //when
        Optional<TokenEntity> tokenValue = testee.findByTokenValue(tokenValueStub);

        //then
        assertTrue(tokenValue.isPresent());
    }
}