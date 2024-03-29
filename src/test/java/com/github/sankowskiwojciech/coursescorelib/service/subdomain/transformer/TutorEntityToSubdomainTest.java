package com.github.sankowskiwojciech.coursescorelib.service.subdomain.transformer;

import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursescorelib.model.subdomain.Subdomain;
import com.github.sankowskiwojciech.coursescorelib.model.subdomain.SubdomainType;
import com.github.sankowskiwojciech.coursestestlib.stub.TutorEntityStub;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TutorEntityToSubdomainTest {
    private final TutorEntityToSubdomain testee = TutorEntityToSubdomain.getInstance();

    private final static String TUTOR_FIRST_NAME_LAST_NAME_DELIMITER = " ";

    @Test
    public void shouldTransformCorrectly() {
        //given
        TutorEntity tutorEntityStub = TutorEntityStub.create();

        //when
        Subdomain subdomain = testee.apply(tutorEntityStub);

        //then
        assertNotNull(subdomain);
        assertSubdomainName(subdomain.getName(), tutorEntityStub.getFirstName(), tutorEntityStub.getLastName());
        assertEquals(tutorEntityStub.getAlias(), subdomain.getAlias());
        assertEquals(tutorEntityStub.getDescription(), subdomain.getDescription());
        assertEquals(tutorEntityStub.getEmailAddress(), subdomain.getEmailAddress());
        assertEquals(tutorEntityStub.getPhoneNumber(), subdomain.getPhoneNumber());
        assertEquals(SubdomainType.TUTOR, subdomain.getSubdomainType());
        assertNull(subdomain.getWebsiteUrl());
    }

    private void assertSubdomainName(String resultSubdomainName, String tutorFirstName, String tutorLastName) {
        assertEquals(String.join(TUTOR_FIRST_NAME_LAST_NAME_DELIMITER, tutorFirstName, tutorLastName), resultSubdomainName);
    }
}