package com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.lesson.LessonEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "studentEntity")
@Entity
@Table(name = "INDIVIDUAL_LESSON")
public class IndividualLessonEntity extends LessonEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STUDENT_ID", nullable = false)
    private StudentEntity studentEntity;

    public IndividualLessonEntity(String id, String title, LocalDateTime startDate, LocalDateTime endDate, String description, LocalDateTime creationDateTime, LocalDateTime modificationDateTime, SubdomainEntity subdomainEntity, TutorEntity tutorEntity, StudentEntity studentEntity) {
        super(id, title, startDate, endDate, description, creationDateTime, modificationDateTime, subdomainEntity, tutorEntity);
        this.studentEntity = studentEntity;
    }
}
