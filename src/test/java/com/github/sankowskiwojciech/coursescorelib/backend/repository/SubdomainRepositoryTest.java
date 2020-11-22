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

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.TUTOR_ALIAS_STUB;
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
        List<SubdomainEntity> subdomainEntities = testee.findAll();

        //then
        assertFalse(subdomainEntities.isEmpty());
    }

    @Test
    public void shouldFindSubdomainBySubdomainIdCorrectly() {
        //given
        String subdomainIdStub = TUTOR_ALIAS_STUB;

        //when
        Optional<SubdomainEntity> subdomainEntityOptional = testee.findById(subdomainIdStub);

        //then
        assertTrue(subdomainEntityOptional.isPresent());
        SubdomainEntity subdomainEntity = subdomainEntityOptional.get();
        assertNotNull(subdomainEntity);
        assertEquals(subdomainIdStub, subdomainEntity.getSubdomainId());
        assertEquals(SubdomainType.TUTOR, subdomainEntity.getSubdomainType());
    }

    @Test
    public void shouldFindSubdomainAndItsSubdomainUserAccessEntitiesCorrectly() {
        //given
        String subdomainIdStub = TUTOR_ALIAS_STUB;

        //when
        Optional<SubdomainEntity> subdomainEntityOptional = testee.findById(subdomainIdStub);

        //then
        assertTrue(subdomainEntityOptional.isPresent());
        SubdomainEntity subdomainEntity = subdomainEntityOptional.get();
        assertNotNull(subdomainEntity);
        assertEquals(subdomainIdStub, subdomainEntity.getSubdomainId());
        assertEquals(SubdomainType.TUTOR, subdomainEntity.getSubdomainType());
        assertNotNull(subdomainEntity.getSubdomainUserAccessEntities());
        Set<SubdomainUserAccessEntity> subdomainUserAccessEntities = subdomainEntity.getSubdomainUserAccessEntities();
        assertFalse(subdomainUserAccessEntities.isEmpty());
    }
}