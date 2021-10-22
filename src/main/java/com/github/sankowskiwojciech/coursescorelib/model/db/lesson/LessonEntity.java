package com.github.sankowskiwojciech.coursescorelib.model.db.lesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@MappedSuperclass
public abstract class LessonEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", length = 36, unique = true, nullable = false, updatable = false)
    private String id;

    @Column(name = "TITLE", length = 50, nullable = false)
    private String title;

    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    @Column(name = "CREATION_DATE_TIME", nullable = false, updatable = false)
    private LocalDateTime creationDateTime;

    @Column(name = "MODIFICATION_DATE_TIME")
    private LocalDateTime modificationDateTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUBDOMAIN_ID", nullable = false, updatable = false)
    private SubdomainEntity subdomainEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TUTOR_ID", nullable = false, updatable = false)
    private TutorEntity tutorEntity;
}
