package com.github.sankowskiwojciech.coursescorelib.model.db.lesson;

import lombok.*;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "LESSON_FILE_ACCESS")
@IdClass(LessonFileAccessEntityId.class)
@EqualsAndHashCode
public class LessonFileAccessEntity {
    @Id
    @Column(name = "LESSON_ID", length = 36, nullable = false, updatable = false)
    private String lessonId;

    @Id
    @Column(name = "FILE_ID", length = 36, nullable = false, updatable = false)
    private String fileId;
}
