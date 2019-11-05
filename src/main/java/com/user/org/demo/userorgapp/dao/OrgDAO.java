package com.user.org.demo.userorgapp.dao;

import java.util.List;

import com.user.org.demo.userorgapp.entity.Organization;

public interface OrgDAO {
  // DAO for users
  public List<Organization> findAllOrganizations();

  public Organization findOrgById(int theId);

  public void saveOrg(Organization theOrganization);

  public void deleteOrgById(int theId);

}
