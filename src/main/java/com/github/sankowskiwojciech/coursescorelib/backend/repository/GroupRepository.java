package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.group.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, String> {
    List<GroupEntity> findAllByTutorEntityEmailAddressAndSubdomainEntitySubdomainId(String tutorEmailAddress, String subdomainAlias);
}
