package com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.lesson.LessonEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.*;

import javax.persistence.*;
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

    public IndividualLessonEntity(String id, String title, LocalDateTime startDate, LocalDateTime endDate, String description, LocalDateTime creationDateTime, LocalDateTime modificationDateTime, OrganizationEntity organizationEntity, TutorEntity tutorEntity, StudentEntity studentEntity) {
        super(id, title, startDate, endDate, description, creationDateTime, modificationDateTime, organizationEntity, tutorEntity);
        this.studentEntity = studentEntity;
    }
}
