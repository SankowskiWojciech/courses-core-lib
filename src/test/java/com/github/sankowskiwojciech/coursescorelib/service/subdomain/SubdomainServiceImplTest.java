package com.github.sankowskiwojciech.coursescorelib.service.subdomain;

import com.github.sankowskiwojciech.coursescorelib.backend.repository.OrganizationRepository;
import com.github.sankowskiwojciech.coursescorelib.backend.repository.SubdomainRepository;
import com.github.sankowskiwojciech.coursescorelib.backend.repository.TutorRepository;
import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainUserAccessEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import com.github.sankowskiwojciech.coursescorelib.model.exception.SubdomainNotFoundException;
import com.github.sankowskiwojciech.coursescorelib.model.exception.permission.UserNotAllowedToAccessSubdomainException;
import com.github.sankowskiwojciech.coursescorelib.model.subdomain.Subdomain;
import com.github.sankowskiwojciech.coursescorelib.model.subdomain.SubdomainType;
import com.github.sankowskiwojciech.coursestestlib.stub.OrganizationEntityStub;
import com.github.sankowskiwojciech.coursestestlib.stub.SubdomainEntityStub;
import com.github.sankowskiwojciech.coursestestlib.stub.SubdomainUserAccessEntityStub;
import com.github.sankowskiwojciech.coursestestlib.stub.TutorEntityStub;
import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.ORGANIZATION_ALIAS_STUB;
import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TUTOR_ALIAS_STUB;
import static com.github.sankowskiwojciech.coursestestlib.DefaultTestValues.TUTOR_EMAIL_ADDRESS_STUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SubdomainServiceImplTest {
    private final OrganizationRepository organizationRepositoryMock = mock(OrganizationRepository.class);
    private final TutorRepository tutorRepositoryMock = mock(TutorRepository.class);
    private final SubdomainRepository subdomainRepositoryMock = mock(SubdomainRepository.class);
    private final SubdomainService testee = new SubdomainServiceImpl(organizationRepositoryMock, tutorRepositoryMock, subdomainRepositoryMock);

    @Before
    public void reset() {
        Mockito.reset(organizationRepositoryMock, tutorRepositoryMock, subdomainRepositoryMock);
    }

    @Test(expected = SubdomainNotFoundException.class)
    public void shouldThrowSubdomainNotFoundExceptionWhenSubdomainDoesNotExist() {
        //given
        String subdomainAliasStub = UUID.randomUUID().toString();
        when(subdomainRepositoryMock.findById(subdomainAliasStub)).thenReturn(Optional.empty());

        //when
        try {
            Subdomain subdomain = testee.readSubdomainInformation(subdomainAliasStub);
        } catch (SubdomainNotFoundException e) {

            //then exception is thrown
            verify(subdomainRepositoryMock).findById(subdomainAliasStub);
            throw e;
        }
    }

    @Test
    public void shouldDoNothingWhenSubdomainBelongsToOrganization() {
        //given
        String subdomainAliasStub = ORGANIZATION_ALIAS_STUB;
        OrganizationEntity organizationEntityStub = OrganizationEntityStub.create();
        SubdomainEntity subdomainEntityStub = SubdomainEntityStub.create(subdomainAliasStub, SubdomainType.ORGANIZATION, Collections.emptySet());

        when(subdomainRepositoryMock.findById(subdomainAliasStub)).thenReturn(Optional.of(subdomainEntityStub));
        when(organizationRepositoryMock.findByAlias(subdomainAliasStub)).thenReturn(Optional.of(organizationEntityStub));

        //when
        Subdomain subdomain = testee.readSubdomainInformation(subdomainAliasStub);

        //then nothing happens
        verify(subdomainRepositoryMock).findById(subdomainAliasStub);
        verify(organizationRepositoryMock).findByAlias(subdomainAliasStub);

        assertNotNull(subdomain);
    }

    @Test
    public void shouldDoNothingWhenSubdomainBelongsToTutor() {
        //given
        String subdomainAliasStub = TUTOR_ALIAS_STUB;
        TutorEntity tutorEntityStub = TutorEntityStub.create();
        SubdomainEntity subdomainEntityStub = SubdomainEntityStub.create(subdomainAliasStub, SubdomainType.TUTOR, Collections.emptySet());

        when(subdomainRepositoryMock.findById(subdomainAliasStub)).thenReturn(Optional.of(subdomainEntityStub));
        when(tutorRepositoryMock.findByAlias(subdomainAliasStub)).thenReturn(Optional.of(tutorEntityStub));

        //when
        Subdomain subdomain = testee.readSubdomainInformation(subdomainAliasStub);

        //then nothing happens
        verify(subdomainRepositoryMock).findById(subdomainAliasStub);
        verify(tutorRepositoryMock).findByAlias(subdomainAliasStub);

        assertNotNull(subdomain);
    }

    @Test(expected = UserNotAllowedToAccessSubdomainException.class)
    public void shouldThrowUserNotAllowedToAccessSubdomainExceptionWhenUserIsNotAllowedToLoginToGivenSubdomain() {
        //given
        String subdomainAliasStub = ORGANIZATION_ALIAS_STUB;
        String userEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;
        SubdomainEntity subdomainEntityStub = SubdomainEntityStub.create(subdomainAliasStub, SubdomainType.ORGANIZATION, Collections.emptySet());
        when(subdomainRepositoryMock.findById(subdomainAliasStub)).thenReturn(Optional.of(subdomainEntityStub));

        //when
        try {
            testee.validateIfUserHasAccessToSubdomain(subdomainAliasStub, userEmailAddressStub);
        } catch (UserNotAllowedToAccessSubdomainException e) {

            //then exception is thrown
            verify(subdomainRepositoryMock).findById(subdomainAliasStub);
            throw e;
        }
    }

    @Test
    public void shouldDoNothingWhenUserIsAllowedToLoginToGivenSubdomain() {
        //given
        String subdomainAliasStub = ORGANIZATION_ALIAS_STUB;
        String userEmailAddressStub = TUTOR_EMAIL_ADDRESS_STUB;
        Set<SubdomainUserAccessEntity> subdomainUserAccessEntities = Sets.newHashSet(SubdomainUserAccessEntityStub.create(subdomainAliasStub, userEmailAddressStub));
        SubdomainEntity subdomainEntityStub = SubdomainEntityStub.create(subdomainAliasStub, SubdomainType.ORGANIZATION, subdomainUserAccessEntities);
        OrganizationEntity organizationEntityStub = OrganizationEntityStub.create();

        when(subdomainRepositoryMock.findById(subdomainAliasStub)).thenReturn(Optional.of(subdomainEntityStub));
        when(organizationRepositoryMock.findByAlias(subdomainAliasStub)).thenReturn(Optional.of(organizationEntityStub));

        //when
        Subdomain subdomain = testee.validateIfUserHasAccessToSubdomain(subdomainAliasStub, userEmailAddressStub);

        //then nothing happens
        verify(subdomainRepositoryMock).findById(subdomainAliasStub);
        verify(organizationRepositoryMock).findByAlias(subdomainAliasStub);

        assertNotNull(subdomain);
        assertEquals(subdomainAliasStub, subdomain.getAlias());
        assertEquals(SubdomainType.ORGANIZATION, subdomain.getSubdomainType());
        assertEquals(organizationEntityStub.getEmailAddress(), subdomain.getEmailAddress());
    }
}