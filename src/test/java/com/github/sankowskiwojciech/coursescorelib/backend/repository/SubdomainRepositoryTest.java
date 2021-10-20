package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainUserAccessEntity;
import com.github.sankowskiwojciech.coursescorelib.model.subdomain.SubdomainType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TUTOR_ALIAS_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SubdomainRepositoryTest {
    @Autowired
    private SubdomainRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<SubdomainEntity> entities = testee.findAll();

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindSubdomainBySubdomainIdCorrectly() {
        //given
        String idStub = TUTOR_ALIAS_STUB;

        //when
        Optional<SubdomainEntity> entityOptional = testee.findById(idStub);

        //then
        assertTrue(entityOptional.isPresent());
        SubdomainEntity entity = entityOptional.get();
        assertNotNull(entity);
        assertEquals(idStub, entity.getSubdomainId());
        assertEquals(SubdomainType.TUTOR, entity.getSubdomainType());
    }

    @Test
    public void shouldFindSubdomainAndItsSubdomainUserAccessEntitiesCorrectly() {
        //given
        String idStub = TUTOR_ALIAS_STUB;

        //when
        Optional<SubdomainEntity> subdomainEntityOptional = testee.findById(idStub);

        //then
        assertTrue(subdomainEntityOptional.isPresent());
        SubdomainEntity subdomainEntity = subdomainEntityOptional.get();
        assertNotNull(subdomainEntity);
        assertEquals(idStub, subdomainEntity.getSubdomainId());
        assertEquals(SubdomainType.TUTOR, subdomainEntity.getSubdomainType());
        assertNotNull(subdomainEntity.getSubdomainUserAccessEntities());
        Set<SubdomainUserAccessEntity> subdomainUserAccessEntities = subdomainEntity.getSubdomainUserAccessEntities();
        assertFalse(subdomainUserAccessEntities.isEmpty());
    }
}