package com.github.sankowskiwojciech.coursescorelib.service.subdomain;

import com.github.sankowskiwojciech.coursescorelib.model.subdomain.Subdomain;

public interface SubdomainService {
    Subdomain readSubdomainInformation(String subdomainAlias);

    Subdomain validateIfUserIsAllowedToLoginToSubdomain(String subdomainAlias, String... userEmailAddresses);
}
