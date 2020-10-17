package com.github.sankowskiwojciech.coursescorelib.model.db.lessonfile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "LESSON_FILE")
@EqualsAndHashCode
public class LessonFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FILE_ID", unique = true, nullable = false, updatable = false)
    private long fileId;

    @Column(name = "NAME", length = 50, nullable = false, updatable = false)
    private String name;

    @Column(name = "EXTENSION", length = 5, updatable = false)
    private String extension;

    //    @Basic(fetch = FetchType.LAZY, optional = false) //TODO: check if needed
    @Column(name = "CONTENT", nullable = false, updatable = false)
    private byte[] content;

    @Column(name = "CREATED_BY", length = 50, nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "CREATION_DATE_TIME", nullable = false, updatable = false)
    private LocalDateTime creationDateTime;
}
