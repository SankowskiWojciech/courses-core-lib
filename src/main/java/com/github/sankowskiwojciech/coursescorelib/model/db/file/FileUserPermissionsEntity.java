package com.github.sankowskiwojciech.coursescorelib.model.db.file;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FILE_USER_PERMISSIONS")
@EqualsAndHashCode(of = "fileUserPermissionsEntityId")
public class FileUserPermissionsEntity {
    @Getter
    @EmbeddedId
    private FileUserPermissionsEntityId fileUserPermissionsEntityId;

    @Column(name = "CAN_READ", nullable = false)
    private boolean canRead = false;

    @Column(name = "CAN_MODIFY", nullable = false)
    private boolean canModify = false;

    @Column(name = "CAN_DELETE", nullable = false)
    private boolean canDelete = false;

    @Getter
    @Column(name = "MODIFICATION_DATE_TIME")
    private LocalDateTime modificationDateTime;

    @Getter
    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    public FileUserPermissionsEntity(FileUserPermissionsEntityId fileUserPermissionsEntityId, boolean canRead, boolean canModify, boolean canDelete) {
        this.fileUserPermissionsEntityId = fileUserPermissionsEntityId;
        this.canRead = canRead;
        this.canModify = canModify;
        this.canDelete = canDelete;
    }

    public boolean canRead() {
        return canRead;
    }

    public boolean canModify() {
        return canModify;
    }

    public boolean canDelete() {
        return canDelete;
    }
}
