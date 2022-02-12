package com.github.sankowskiwojciech.coursescorelib.model.db.file;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
@Getter
public class FileUserPermissionsEntityId implements Serializable {
    @Column(name = "FILE_ID", length = 36, nullable = false, updatable = false)
    private String fileId;

    @Column(name = "USER_ID", length = 50, nullable = false, updatable = false)
    private String userId;
}
