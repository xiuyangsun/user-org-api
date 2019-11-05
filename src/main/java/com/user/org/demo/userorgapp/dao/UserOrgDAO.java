package com.user.org.demo.userorgapp.dao;

import java.util.List;

import com.user.org.demo.userorgapp.entity.Organization;
import com.user.org.demo.userorgapp.entity.User;

public interface UserOrgDAO {
	//DAO for users
	public List<User> findAllUsers();
	public User findUserById(int theId);
	public void saveUser(User theUser);
	public void deleteUserById(int theId);
	//DAO for organizations
	public List<Organization> findAllOrganizations();
	public Organization findOrgById(int theId);
	public void saveOrg(Organization theOrganization);
	public void deleteOrgaById(int theId);
	
	//DAO for user organization relationship
	
	public void addUser(Organization organization, User user);
}
