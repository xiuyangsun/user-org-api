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
	public void addUser(Organization organization, User user) {
		userOrgDAO.addUser(organization, user);
	}
}
