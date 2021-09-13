package com.github.sankowskiwojciech.coursescorelib.model.db.file;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "FILE")
@EqualsAndHashCode
public class FileEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", length = 36, unique = true, nullable = false, updatable = false)
    private String id;

    @Column(name = "NAME", length = 50, nullable = false, updatable = false)
    private String name;

    @Column(name = "EXTENSION", length = 5, updatable = false)
    private String extension;

    @Column(name = "CONTENT", nullable = false, updatable = false)
    private byte[] content;

    @Column(name = "CREATED_BY", length = 50, nullable = false, updatable = false)
    private String createdBy;

    @Column(name = "CREATION_DATE_TIME", nullable = false, updatable = false)
    private LocalDateTime creationDateTime;
}
