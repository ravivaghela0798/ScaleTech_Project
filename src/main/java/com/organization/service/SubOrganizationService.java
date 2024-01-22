package com.organization.service;

import com.organization.entities.SubOrganization;

import jakarta.validation.Valid;

public interface SubOrganizationService {

	SubOrganization createSubOrganization(@Valid SubOrganization subOrganization);

}
