package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainUserAccessEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TUTOR_ALIAS_STUB;
import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SubdomainUserAccessRepositoryTest {
    private static final int SUBDOMAIN_USER_ACCESS_ENTITY_LIST_EXPECTED_SIZE = 2;

    @Autowired
    private SubdomainUserAccessRepository testee;

    @Test
    public void shouldFindAllEntitiesCorrectly() {
        //given

        //when
        List<SubdomainUserAccessEntity> entities = testee.findAll();

        //then
        assertFalse(entities.isEmpty());
    }

    @Test
    public void shouldFindAllEntitiesBySubdomainIdCorrectly() {
        //given
        String subdomainIdStub = TUTOR_ALIAS_STUB;
        String tutorEmailAddress = TUTOR_EMAIL_ADDRESS_STUB;

        //when
        List<SubdomainUserAccessEntity> entities = testee.findAllBySubdomainUserAccessEntityIdSubdomainIdAndSubdomainUserAccessEntityIdUserEmailAddressIsNot(subdomainIdStub, tutorEmailAddress);

        //then
        assertNotNull(entities);
        assertFalse(entities.isEmpty());
        assertEquals(SUBDOMAIN_USER_ACCESS_ENTITY_LIST_EXPECTED_SIZE, entities.size());
    }
}