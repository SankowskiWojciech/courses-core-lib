package com.github.sankowskiwojciech.coursescorelib.model.db.subdomain;

import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SUBDOMAIN_USER_ACCESS")
@EqualsAndHashCode(of = "subdomainUserAccessEntityId")
public class SubdomainUserAccessEntity {
    @EmbeddedId
    private SubdomainUserAccessEntityId subdomainUserAccessEntityId;

    @MapsId("subdomainId")
    @JoinColumn(name = "SUBDOMAIN_ID", referencedColumnName = "SUBDOMAIN_ID")
    @ManyToOne
    private SubdomainEntity subdomainEntity;
}
