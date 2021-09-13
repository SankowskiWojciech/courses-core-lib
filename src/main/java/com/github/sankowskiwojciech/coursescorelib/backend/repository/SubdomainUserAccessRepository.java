package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainUserAccessEntity;
import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainUserAccessEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubdomainUserAccessRepository extends JpaRepository<SubdomainUserAccessEntity, SubdomainUserAccessEntityId> {
    List<SubdomainUserAccessEntity> findAllBySubdomainUserAccessEntityIdSubdomainIdAndSubdomainUserAccessEntityIdUserEmailAddressIsNot(String subdomainId, String tutorEmailAddress);
}
