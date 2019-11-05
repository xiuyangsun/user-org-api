package com.user.org.demo.userorgapp.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.user.org.demo.userorgapp.entity.Organization;

@Repository
public class OrgDAOImpl implements OrgDAO {
	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public OrgDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
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

		// save or update a organization, if id=0 then save/insert else update;
		session.saveOrUpdate(theOrganization);
	}

	@Override
	public void deleteOrgById(int theId) {

		Session session = entityManager.unwrap(Session.class);

		Query theQuery = session.createQuery("delete from Organization where id=:organizationId");

		theQuery.setParameter("organizationId", theId);

		theQuery.executeUpdate();

	}
}
