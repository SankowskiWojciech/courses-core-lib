package com.github.sankowskiwojciech.coursescorelib.model.db.subdomain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

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
