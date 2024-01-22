package com.organization.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.entities.SubOrganization;
import com.organization.service.SubOrganizationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/suborganizations")
public class SubOrganizationController {

	@Autowired
	private SubOrganizationService subOrganizationService;

	// Create SubOrganization
	@PostMapping
	public ResponseEntity<Object> createSubOrganization(@Valid @RequestBody SubOrganization subOrganization) {
		SubOrganization createdSubOrganization = subOrganizationService.createSubOrganization(subOrganization);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdSubOrganization);
	}
}
