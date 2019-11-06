package com.user.org.demo.userorgapp.service;

import com.user.org.demo.userorgapp.entity.User;

import java.util.List;

public interface UserService {
	// Service for users
	List<User> findAllUsers();

	User findUserById(int theId);

	void saveUser(User theUser);

	void deleteUserById(int theId);
}
