package com.user.org.demo.userorgapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.org.demo.userorgapp.entity.Organization;
import com.user.org.demo.userorgapp.entity.User;

@Repository
public class UserOrgDAOImpl implements UserOrgDAO {
  // define field for entity manager
  private EntityManager entityManager;

  // set up constructor injection
  @Autowired
  public UserOrgDAOImpl(EntityManager theEntityManager) {
    entityManager = theEntityManager;
  }

  @Override
  public void addUser(Organization organization, User user) {

    Session session = entityManager.unwrap(Session.class);

    organization.addUser(user);

    session.save(organization);

  }

}
