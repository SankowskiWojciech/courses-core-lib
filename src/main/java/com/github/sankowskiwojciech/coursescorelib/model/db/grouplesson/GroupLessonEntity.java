package com.github.sankowskiwojciech.coursescorelib.model.db.grouplesson;

import com.github.sankowskiwojciech.coursescorelib.model.db.group.GroupEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.lesson.LessonEntity;
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
@EqualsAndHashCode(callSuper = true, exclude = "groupEntity")
@Entity
@Table(name = "GROUP_LESSON")
public class GroupLessonEntity extends LessonEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "GROUP_ID", nullable = false)
    private GroupEntity groupEntity;

    public GroupLessonEntity(String id, String title, LocalDateTime startDate, LocalDateTime endDate, String description, LocalDateTime creationDateTime, LocalDateTime modificationDateTime, SubdomainEntity subdomainEntity, TutorEntity tutorEntity, GroupEntity groupEntity) {
        super(id, title, startDate, endDate, description, creationDateTime, modificationDateTime, subdomainEntity, tutorEntity);
        this.groupEntity = groupEntity;
    }
}
