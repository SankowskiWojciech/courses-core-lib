package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.group.GroupEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.group.StudentGroupAccessEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.group.StudentGroupAccessEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentGroupAccessRepository extends JpaRepository<StudentGroupAccessEntity, StudentGroupAccessEntityId> {

    List<StudentGroupAccessEntity> findAllByGroupEntity(GroupEntity groupEntity);
}
