package com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "INDIVIDUAL_LESSON")
@EqualsAndHashCode
public class IndividualLessonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LESSON_ID", unique = true, nullable = false, updatable = false)
    private long lessonId;

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

    @Column(name = "CREATION_DATE_TIME", nullable = false)
    private LocalDateTime creationDateTime;

    @Column(name = "MODIFICATION_DATE_TIME")
    private LocalDateTime modificationDateTime;
}
