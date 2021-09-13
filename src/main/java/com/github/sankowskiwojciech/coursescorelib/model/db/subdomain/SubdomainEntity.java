package com.github.sankowskiwojciech.coursescorelib.model.db.subdomain;

import com.github.sankowskiwojciech.coursescorelib.model.subdomain.SubdomainType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SUBDOMAIN")
@EqualsAndHashCode(of = "subdomainId")
public class SubdomainEntity {
    @Id
    @Column(name = "SUBDOMAIN_ID", length = 20, unique = true, nullable = false, updatable = false)
    private String subdomainId;

    @Column(name = "SUBDOMAIN_TYPE", length = 12, nullable = false)
    @Enumerated(EnumType.STRING)
    private SubdomainType subdomainType;

    @OneToMany(mappedBy = "subdomainEntity")
    private Set<SubdomainUserAccessEntity> subdomainUserAccessEntities;
}
