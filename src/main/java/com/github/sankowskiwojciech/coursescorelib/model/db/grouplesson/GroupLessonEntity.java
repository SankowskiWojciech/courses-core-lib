package com.github.sankowskiwojciech.coursescorelib.model.db.grouplesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.group.StudentsGroupEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.lesson.LessonEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.organization.OrganizationEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.tutor.TutorEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Setter
@EqualsAndHashCode(callSuper = true, exclude = "studentsGroupEntity")
@Entity
@Table(name = "GROUP_LESSON")
public class GroupLessonEntity extends LessonEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GROUP_ID", nullable = false)
    private StudentsGroupEntity studentsGroupEntity;

    public GroupLessonEntity(String id, String title, LocalDateTime startDate, LocalDateTime endDate, String description, LocalDateTime creationDateTime, LocalDateTime modificationDateTime, OrganizationEntity organizationEntity, TutorEntity tutorEntity, StudentsGroupEntity studentsGroupEntity) {
        super(id, title, startDate, endDate, description, creationDateTime, modificationDateTime, organizationEntity, tutorEntity);
        this.studentsGroupEntity = studentsGroupEntity;
    }
}
