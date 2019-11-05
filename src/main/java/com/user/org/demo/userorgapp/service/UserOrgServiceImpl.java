package com.user.org.demo.userorgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.org.demo.userorgapp.dao.UserOrgDAO;
import com.user.org.demo.userorgapp.entity.Organization;
import com.user.org.demo.userorgapp.entity.User;

@Service
public class UserOrgServiceImpl implements UserOrgService {
	
	private UserOrgDAO userOrgDAO;
	
	@Autowired
	public UserOrgServiceImpl(UserOrgDAO theUserOrgDAO) {
		userOrgDAO = theUserOrgDAO;
	}

	@Override
	@Transactional
	public List<User> findAllUsers() {
		return userOrgDAO.findAllUsers();
	}

	@Override
	@Transactional
	public User findUserById(int theId) {
		return userOrgDAO.findUserById(theId);
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {
		userOrgDAO.saveUser(theUser);

	}

	@Override
	@Transactional
	public void deleteUserById(int theId) {
		userOrgDAO.deleteUserById(theId);
	}

	@Override
	@Transactional
	public List<Organization> findAllOrganizations() {
		return userOrgDAO.findAllOrganizations();
	}

	@Override
	@Transactional
	public Organization findOrgById(int theId) {
		return userOrgDAO.findOrgById(theId);
	}

	@Override
	@Transactional
	public void saveOrg(Organization theOrganization) {
		userOrgDAO.saveOrg(theOrganization);
		
	}

	@Override
	@Transactional
	public void deleteOrgaById(int theId) {
		userOrgDAO.deleteOrgaById(theId);
		
	}

	@Override
	public void addUser(Organization organization, User user) {
		userOrgDAO.addUser(organization, user);
		
	}

}
