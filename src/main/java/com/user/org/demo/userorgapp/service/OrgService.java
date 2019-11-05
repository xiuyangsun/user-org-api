package com.user.org.demo.userorgapp.service;

import java.util.List;

import com.user.org.demo.userorgapp.entity.Organization;

public interface OrgService {
	// Service for organizations
	public List<Organization> findAllOrganizations();

	public Organization findOrgById(int theId);

	public void saveOrg(Organization theOrganization);

	public void deleteOrgById(int theId);
}
