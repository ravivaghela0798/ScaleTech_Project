package com.organization.service;

import com.organization.entities.Organization;

import jakarta.validation.Valid;

public interface OrganizationService {

	Organization createOrganization(@Valid Organization organization);

}
