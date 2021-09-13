package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.TUTOR_ALIAS_STUB;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TutorRepositoryTest {
    @Autowired
    private TutorRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<TutorEntity> entities = testee.findAll();

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindEntityByAliasCorrectly() {
        //given
        String tutorAlias = TUTOR_ALIAS_STUB;

        //when
        Optional<TutorEntity> entityOptional = testee.findByAlias(tutorAlias);

        //then
        assertTrue(entityOptional.isPresent());
        TutorEntity entity = entityOptional.get();
        assertFalse(entity.getIndividualLessons().isEmpty());
    }
}