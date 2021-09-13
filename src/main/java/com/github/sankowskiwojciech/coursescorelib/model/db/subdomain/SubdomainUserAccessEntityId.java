package com.github.sankowskiwojciech.coursescorelib.model.db.subdomain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
@Getter
public class SubdomainUserAccessEntityId implements Serializable {
    @Column(name = "SUBDOMAIN_ID", length = 20, nullable = false, updatable = false)
    private String subdomainId;

    @Column(name = "USER_EMAIL_ADDRESS", length = 50, nullable = false, updatable = false)
    private String userEmailAddress;
}
