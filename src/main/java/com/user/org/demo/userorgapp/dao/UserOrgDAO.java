package com.user.org.demo.userorgapp.dao;

import java.util.List;

import com.user.org.demo.userorgapp.entity.Organization;
import com.user.org.demo.userorgapp.entity.User;

public interface UserOrgDAO {

  // DAO for user organization relationship

  public void addUser(Organization organization, User user);
}