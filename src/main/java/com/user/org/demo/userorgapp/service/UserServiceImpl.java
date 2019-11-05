package com.user.org.demo.userorgapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.org.demo.userorgapp.dao.UserDAO;
import com.user.org.demo.userorgapp.entity.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	@Autowired
	public UserServiceImpl(UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}

	@Override
	@Transactional
	public List<User> findAllUsers() {
		return userDAO.findAllUsers();
	}

	@Override
	@Transactional
	public User findUserById(int theId) {
		return userDAO.findUserById(theId);
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {
		userDAO.saveUser(theUser);

	}

	@Override
	@Transactional
	public void deleteUserById(int theId) {
		userDAO.deleteUserById(theId);
	}

}
