package com.github.sankowskiwojciech.coursescorelib.model.db.group;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "GROUP_OF_STUDENTS")
@EqualsAndHashCode(exclude = {"tutorEntity", "subdomainEntity"})
public class GroupEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", length = 36, unique = true, nullable = false, updatable = false)
    private String id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", length = 1000)
    private String description;

    @Column(name = "CREATION_DATE_TIME", nullable = false, updatable = false)
    private LocalDateTime creationDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUBDOMAIN_ID", nullable = false, updatable = false)
    private SubdomainEntity subdomainEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TUTOR_ID", nullable = false)
    private TutorEntity tutorEntity;
}
