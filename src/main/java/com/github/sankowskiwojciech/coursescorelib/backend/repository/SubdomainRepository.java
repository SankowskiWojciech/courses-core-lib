package com.github.sankowskiwojciech.coursescorelib.backend.repository;

import com.github.sankowskiwojciech.coursescorelib.model.db.subdomain.SubdomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubdomainRepository extends JpaRepository<SubdomainEntity, String> {
}
