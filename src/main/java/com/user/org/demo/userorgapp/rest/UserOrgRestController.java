package com.user.org.demo.userorgapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.org.demo.userorgapp.entity.Organization;
import com.user.org.demo.userorgapp.entity.User;
import com.user.org.demo.userorgapp.service.UserOrgService;

@RestController
@RequestMapping("/api")
public class UserOrgRestController {

	private UserOrgService userOrgService;

	@Autowired
	public UserOrgRestController(UserOrgService theUserOrgService) {
		userOrgService = theUserOrgService;
	}
	
	/*
	 * CRUD function end points for users
	 */

	// expose "/users" and return list of users

	@GetMapping("/users")
	public List<User> findAllUsers() {
		return userOrgService.findAllUsers();
	}
	
	// expose "/users/{userId} and return single user using Id
	
	@GetMapping("/users/{userId}")
	public User getUser (@PathVariable int userId) {
		User theUser = userOrgService.findUserById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User id not found -" + userId);
		}
		
		return theUser;
	}
	
	//expose "/users" for POST to add new user;
	
	@PostMapping("/users")
	public User addUser (@RequestBody User theUser) {
		
		//just in case id is put in JSON, I set id to 0
		//this is to force a save of new item instead of update;
		
		theUser.setId(0);
		
		userOrgService.saveUser(theUser);
		
		return theUser;
	}
	
	//expose "/users" for PUT to update user;
	
	@PutMapping("/users")
	public User updateUser (@RequestBody User theUser) {
		
		userOrgService.saveUser(theUser);
		
		return theUser;
	}
	
	//expose "/users/{userId}" to delete an existing user;
	
	@DeleteMapping("/users/{userId}")
	public User deleteUser (@PathVariable int userId) {
		
		User theUser = userOrgService.findUserById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User id not found -" + userId);
		}
		
		userOrgService.deleteUserById(userId);
		
		return theUser;
	}
	
	
	
	/*
	 * CRUD function end points for organizations
	 */
	
	// expose "/organizations" and return list of organizations
	
	@GetMapping("/organizations")
	public List<Organization> findAllOrganizations() {
		return userOrgService.findAllOrganizations();
	}
	
	// expose "/organizations/{organizationId} and return single organization using Id
	
	@GetMapping("/organizations/{organizationId}")
	public Organization getOrganization (@PathVariable int organizationId) {
		Organization theOrganization = userOrgService.findOrgById(organizationId);
		
		if (theOrganization == null) {
			throw new RuntimeException("Organization id not found -" + organizationId);
		}
		
		return theOrganization;
	}
	
	//expose "/organizations" for POST to add new organization;
	
	@PostMapping("/organizations")
	public Organization addOrganization (@RequestBody Organization theOrganization) {
		
		//just in case id is put in JSON, I set id to 0
		//this is to force a save of new item instead of update;
		
		theOrganization.setId(0);
		
		userOrgService.saveOrg(theOrganization);
		
		return theOrganization;
	}
	
	//expose "/organizations" for PUT to update organization;
	
	@PutMapping("/organizations")
	public Organization updateOrganization (@RequestBody Organization theOrganization) {
		
		userOrgService.saveOrg(theOrganization);
		
		return theOrganization;
	}
	
	//expose "/organizations/{organizationId}" to delete an existing organization;
	
	@DeleteMapping("/organizations/{organizationId}")
	public Organization deleteOrganization (@PathVariable int organizationId) {
		
		Organization theOrganization = userOrgService.findOrgById(organizationId);
		
		if (theOrganization == null) {
			throw new RuntimeException("User id not found -" + organizationId);
		}
		
		userOrgService.deleteOrgaById(organizationId);
		
		return theOrganization;
	}
	
	
	/*
	 * End Points to handle User-organization relationship
	 */
	
	
	//expose "/userorg/{organizationId}/{userId}" to add a user to an organization
	
	@PostMapping("/userorg/{organizationId}/{userId}")
	public List<User> addUserToOrg (@PathVariable int organizationId, @PathVariable int userId) {
		Organization organization = userOrgService.findOrgById(organizationId);
		User user = userOrgService.findUserById(userId);
		userOrgService.addUser(organization, user);
		
		return organization.getUsers();
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
}
