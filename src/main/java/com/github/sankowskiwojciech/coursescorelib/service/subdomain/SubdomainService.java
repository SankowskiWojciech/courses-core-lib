package com.github.sankowskiwojciech.coursescorelib.service.subdomain;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.subdomain.Subdomain;

public interface SubdomainService {
    SubdomainEntity readSubdomain(String subdomainAlias);

    Subdomain readSubdomainInformation(String subdomainAlias);

    Subdomain validateIfUserHasAccessToSubdomain(String subdomainAlias, String... userEmailAddresses);
}
