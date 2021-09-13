package com.github.sankowskiwojciech.coursescorelib.model.db.group;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
@Getter
public class StudentGroupAccessEntityId implements Serializable {
    @Column(name = "STUDENT_ID", length = 50, nullable = false, updatable = false)
    private String studentId;

    @Column(name = "GROUP_ID", length = 50, nullable = false, updatable = false)
    private String groupId;
}
