package com.github.sankowskiwojciech.coursescorelib.stub;

import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import lombok.NoArgsConstructor;

import static com.github.sankowskiwojciech.coursescorelib.DefaultTestValues.*;

@NoArgsConstructor
public class OrganizationEntityStub {
    public static OrganizationEntity create() {
        return OrganizationEntity.builder()
                .emailAddress(ORGANIZATION_EMAIL_ADDRESS_STUB)
                .alias(ORGANIZATION_ALIAS_STUB)
                .name(ORGANIZATION_NAME_STUB)
                .description(ORGANIZATION_DESCRIPTION_STUB)
                .phoneNumber(ORGANIZATION_PHONE_NUMBER_STUB)
                .websiteUrl(ORGANIZATION_WEBSITE_URL_STUB)
                .build();
    }
}
