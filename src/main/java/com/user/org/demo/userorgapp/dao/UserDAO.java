package com.user.org.demo.userorgapp.dao;

import java.util.List;

import com.user.org.demo.userorgapp.entity.User;

public interface UserDAO {
	// DAO for users
	public List<User> findAllUsers();

	public User findUserById(int theId);

	public void saveUser(User theUser);

	public void deleteUserById(int theId);

}
