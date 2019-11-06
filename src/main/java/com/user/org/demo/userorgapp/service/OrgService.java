package com.user.org.demo.userorgapp.service;

import com.user.org.demo.userorgapp.entity.Organization;

import java.util.List;

public interface OrgService {
	// Service for organizations
	List<Organization> findAllOrganizations();

	Organization findOrgById(int theId);

	void saveOrg(Organization theOrganization);

	void deleteOrgById(int theId);
}
