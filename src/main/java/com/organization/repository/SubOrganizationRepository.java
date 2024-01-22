package com.organization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.entities.SubOrganization;

@Repository
public interface SubOrganizationRepository extends JpaRepository<SubOrganization, Long> {

}
