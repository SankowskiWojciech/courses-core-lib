package com.github.sankowskiwojciech.coursescorelib.model.db.group;

import com.github.sankowskiwojciech.coursescorelib.model.db.student.StudentEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "STUDENT_GROUP_ACCESS")
@EqualsAndHashCode(of = "studentGroupAccessEntityId")
public class StudentGroupAccessEntity {
    @EmbeddedId
    private StudentGroupAccessEntityId studentGroupAccessEntityId;

    @MapsId("studentId")
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "EMAIL_ADDRESS")
    @ManyToOne
    private StudentEntity studentEntity;

    @MapsId("groupId")
    @JoinColumn(name = "GROUP_ID", referencedColumnName = "ID")
    @ManyToOne
    private GroupEntity groupEntity;
}
