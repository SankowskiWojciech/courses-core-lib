package com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson;

import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "INDIVIDUAL_LESSON_FILE")
@IdClass(IndividualLessonFileEntityId.class)
@EqualsAndHashCode
public class IndividualLessonFileEntity {

    @Id
    @Column(name = "LESSON_ID", length = 36, nullable = false, updatable = false)
    private String lessonId;

    @Id
    @Column(name = "FILE_ID", length = 36, nullable = false, updatable = false)
    private String fileId;
}
