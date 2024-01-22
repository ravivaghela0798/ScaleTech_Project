package com.organization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.entities.Organization;
import com.organization.repository.OrganizationRepository;
import com.organization.service.OrganizationService;

import jakarta.validation.Valid;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;

	@Override
	public Organization createOrganization(@Valid Organization organization) {
		return organizationRepository.save(organization);
	}

}
