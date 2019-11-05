package com.user.org.demo.userorgapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.user.org.demo.userorgapp.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public UserDAOImpl(EntityManager theEntityManager) {
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

		// save or update a user, if id=0 then save/insert else update;
		session.saveOrUpdate(theUser);

	}

	@Override
	public void deleteUserById(int theId) {

		Session session = entityManager.unwrap(Session.class);

		Query theQuery = session.createQuery("delete from User where id=:userId");

		theQuery.setParameter("userId", theId);

		theQuery.executeUpdate();

	}
}
