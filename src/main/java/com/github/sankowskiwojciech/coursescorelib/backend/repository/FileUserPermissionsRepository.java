package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.file.FileUserPermissionsEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.file.FileUserPermissionsEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileUserPermissionsRepository extends JpaRepository<FileUserPermissionsEntity, FileUserPermissionsEntityId> {

    List<FileUserPermissionsEntity> findAllByFileUserPermissionsEntityIdUserIdAndCanReadIsTrue(String userId);
}
