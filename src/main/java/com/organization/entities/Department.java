package com.organization.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "departments")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name not be null")
	@Column(name = "name")
	private String name;

	@NotNull(message = "Sub-organization ID is required")
	@ManyToOne
	@JoinColumn(name = "sub_organization_id")
	private SubOrganization subOrganization;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SubOrganization getSubOrganization() {
		return subOrganization;
	}

	public void setSubOrganization(SubOrganization subOrganization) {
		this.subOrganization = subOrganization;
	}

}
