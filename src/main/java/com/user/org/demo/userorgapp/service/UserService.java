package com.user.org.demo.userorgapp.service;

import java.util.List;

import com.user.org.demo.userorgapp.entity.Organization;
import com.user.org.demo.userorgapp.entity.User;

public interface UserService {
	// Service for users
	public List<User> findAllUsers();

	public User findUserById(int theId);

	public void saveUser(User theUser);

	public void deleteUserById(int theId);
}
