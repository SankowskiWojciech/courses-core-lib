package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.ORGANIZATION_ALIAS_STUB;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrganizationRepositoryTest {
    @Autowired
    private OrganizationRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<OrganizationEntity> entities = testee.findAll();

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindEntityByAliasCorrectly() {
        //given
        String organizationAlias = ORGANIZATION_ALIAS_STUB;

        //when
        Optional<OrganizationEntity> entityOptional = testee.findByAlias(organizationAlias);

        //then
        assertTrue(entityOptional.isPresent());
        OrganizationEntity entity = entityOptional.get();
        assertFalse(entity.getIndividualLessons().isEmpty());
    }
}