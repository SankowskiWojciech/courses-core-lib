package com.github.sankowskiwojciech.coursescorelib.model.db.individuallesson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

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
    @Column(name = "LESSON_ID", nullable = false, updatable = false)
    private long lessonId;

    @Id
    @Column(name = "FILE_ID", nullable = false, updatable = false)
    private long fileId;
}
