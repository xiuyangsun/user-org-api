package com.user.org.demo.userorgapp.rest;

import com.user.org.demo.userorgapp.DTO.response.OrganizationRes;
import com.user.org.demo.userorgapp.DTO.response.UserRes;
import com.user.org.demo.userorgapp.entity.Organization;
import com.user.org.demo.userorgapp.entity.User;
import com.user.org.demo.userorgapp.service.OrgService;
import com.user.org.demo.userorgapp.service.UserService;
import com.user.org.demo.userorgapp.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api/userorg")
public class UserOrgRestController {
	@Autowired
	private UserService userService;
	@Autowired
	private OrgService orgService;

	/*
	 * End Points to handle User-organization relationship
	 */

	// expose "/userorg/{organizationId}/{userId}" to add a user to an organization

	@PostMapping("/{organizationId}/{userId}")
	public ResponseEntity<List<UserRes>> addUserToOrg(@PathVariable @Positive int organizationId, @PathVariable @Positive int userId) {
		Organization organization = orgService.findOrgById(organizationId);
		User user = userService.findUserById(userId);

		if (!organization.getUsers().contains(user)){
			organization.addUser(user);
			orgService.saveOrg(organization);
		}

		List<User> users = organization.getUsers();
		List<UserRes> res = Mapper.mapAll(users, UserRes.class);

		return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}



	@GetMapping("/org/{orgId}")
	public ResponseEntity<List<UserRes>> findUsersFromOrg(@PathVariable @Positive int orgId) {
		Organization org = orgService.findOrgById(orgId);

		List<User> users = org.getUsers();
		List<UserRes> res = Mapper.mapAll(users, UserRes.class);

		return ResponseEntity.ok(res);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<OrganizationRes>> findOrgForUser(@PathVariable @Positive int userId) {
		User user = userService.findUserById(userId);

		List<Organization> orgs = user.getOrganizations();
		List<OrganizationRes> res = Mapper.mapAll(orgs, OrganizationRes.class);

		return ResponseEntity.ok(res);
	}

	@PutMapping("/{orgId}/{userId}")
	public ResponseEntity<List<UserRes>> deleteUserFromOrg(@PathVariable @Positive int orgId, @PathVariable @Positive int userId) {
		Organization organization = orgService.findOrgById(orgId);
		User user = userService.findUserById(userId);

		List<User> userList = organization.getUsers();

		if (userList == null || userList.size() == 0 || !userList.contains(user)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("User with id - %d not found in organization with id - %d" , userId, orgId));
		}

		userList.remove(user);

		organization.setUsers(userList);

		orgService.saveOrg(organization);

		List<UserRes> res = Mapper.mapAll(userList, UserRes.class);

		return ResponseEntity.ok(res);
	}

}
