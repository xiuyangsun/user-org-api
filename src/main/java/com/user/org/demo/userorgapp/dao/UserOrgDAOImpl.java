package com.user.org.demo.userorgapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.user.org.demo.userorgapp.entity.Organization;
import com.user.org.demo.userorgapp.entity.User;
@Repository
public class UserOrgDAOImpl implements UserOrgDAO {
	//define field for entity manager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public UserOrgDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<User> findAllUsers() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<User> theQuery = session.createQuery("from User", User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;
	}


	@Override
	public User findUserById(int theId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		User theUser = session.get(User.class, theId);
		
		
		return theUser;
	}


	@Override
	public void saveUser(User theUser) {
		
		Session session = entityManager.unwrap(Session.class);
		
		//save or update a user, if id=0 then save/insert else update;
		session.saveOrUpdate(theUser);
		
	}


	@Override
	public void deleteUserById(int theId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query theQuery = session.createQuery("delete from User where id=:userId");
		
		theQuery.setParameter("userId", theId);
		
		theQuery.executeUpdate();
		
	}


	@Override
	public List<Organization> findAllOrganizations() {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query<Organization> theQuery = session.createQuery("from Organization", Organization.class);
		
		List<Organization> organizations = theQuery.getResultList();
		
		return organizations;
	}


	@Override
	public Organization findOrgById(int theId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Organization theOrganization = session.get(Organization.class, theId);
		
		
		return theOrganization;
	}


	@Override
	public void saveOrg(Organization theOrganization) {
		
		Session session = entityManager.unwrap(Session.class);
		
		//save or update a user, if id=0 then save/insert else update;
		session.saveOrUpdate(theOrganization);	
	}


	@Override
	public void deleteOrgaById(int theId) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query theQuery = session.createQuery("delete from Organization where id=:organizationId");
		
		theQuery.setParameter("organizationId", theId);
		
		theQuery.executeUpdate();
		
	}


	@Override
	public void addUser(Organization organization, User user) {

		Session session = entityManager.unwrap(Session.class);
		
		organization.addUser(user);
		
		session.save(organization);
		
		
	}

}
