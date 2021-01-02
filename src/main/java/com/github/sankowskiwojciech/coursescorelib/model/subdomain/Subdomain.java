package com.github.sankowskiwojciech.coursescorelib.model.subdomain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Subdomain {
    private final String name;
    private final String alias;
    private final String description;
    private final String emailAddress;
    private final String phoneNumber;
    private final String websiteUrl;
    private final SubdomainType subdomainType;
}
