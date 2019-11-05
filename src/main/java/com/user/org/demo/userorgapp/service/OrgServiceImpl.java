package com.user.org.demo.userorgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.org.demo.userorgapp.dao.OrgDAO;
import com.user.org.demo.userorgapp.entity.Organization;

@Service
public class OrgServiceImpl implements OrgService {

	private OrgDAO orgDAO;

	@Autowired
	public OrgServiceImpl(OrgDAO theOrgDAO) {
		orgDAO = theOrgDAO;
	}

	@Override
	@Transactional
	public List<Organization> findAllOrganizations() {
		return orgDAO.findAllOrganizations();
	}

	@Override
	@Transactional
	public Organization findOrgById(int theId) {
		return orgDAO.findOrgById(theId);
	}

	@Override
	@Transactional
	public void saveOrg(Organization theOrganization) {
		orgDAO.saveOrg(theOrganization);

	}

	@Override
	@Transactional
	public void deleteOrgById(int theId) {
		orgDAO.deleteOrgById(theId);
	}

}
