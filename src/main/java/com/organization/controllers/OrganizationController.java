package com.organization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.entities.Organization;
import com.organization.service.OrganizationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;

	// Create Organization
	@PostMapping
	public ResponseEntity<Object> createOrganization(@Valid @RequestBody Organization organization) {
		Organization createdOrganization = organizationService.createOrganization(organization);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdOrganization);
	}
}
