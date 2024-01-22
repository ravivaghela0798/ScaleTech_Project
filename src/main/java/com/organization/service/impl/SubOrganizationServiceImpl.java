package com.organization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.entities.SubOrganization;
import com.organization.repository.SubOrganizationRepository;
import com.organization.service.SubOrganizationService;

import jakarta.validation.Valid;

@Service
public class SubOrganizationServiceImpl implements SubOrganizationService {

	@Autowired
	private SubOrganizationRepository subOrganizationRepository;

	public SubOrganization createSubOrganization(@Valid SubOrganization subOrganization) {
		return subOrganizationRepository.save(subOrganization);
	}

}
