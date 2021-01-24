package com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "INDIVIDUAL_LESSON")
@EqualsAndHashCode
public class IndividualLessonEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "LESSON_ID", length = 36, unique = true, nullable = false, updatable = false)
    private String lessonId;

    @Column(name = "TITLE", length = 50, nullable = false)
    private String title;

    @Column(name = "START_DATE_OF_LESSON", nullable = false)
    private LocalDateTime startDateOfLesson;

    @Column(name = "END_DATE_OF_LESSON", nullable = false)
    private LocalDateTime endDateOfLesson;

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private OrganizationEntity organizationEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TUTOR_ID", nullable = false)
    private TutorEntity tutorEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private StudentEntity studentEntity;

    @Column(name = "CREATION_DATE_TIME", nullable = false, updatable = false)
    private LocalDateTime creationDateTime;

    @Column(name = "MODIFICATION_DATE_TIME")
    private LocalDateTime modificationDateTime;
}
