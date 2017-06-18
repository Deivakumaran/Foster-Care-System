package com.neu.spring.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.spring.exception.OrganizationException;
import com.neu.spring.exception.UserException;
import com.neu.spring.pojo.Address;
import com.neu.spring.pojo.Email;
import com.neu.spring.pojo.Organization;
import com.neu.spring.pojo.Orphan;
import com.neu.spring.pojo.User;

public class OrganizationOrphanDAO extends DAO {
	public Orphan create(Orphan orphan, Organization organization) throws OrganizationException {
		try {

			begin();
			Email email = new Email(orphan.getEmail().getEmailaddress());
			orphan.setEmail(email);
			email.setOrphan(orphan);
			Address address = new Address(orphan.getAddress().getStreet(), orphan.getAddress().getCity(),
					orphan.getAddress().getState(), orphan.getAddress().getCountry(), orphan.getAddress().getZip());
			orphan.setAddress(address);
			address.setOrphan(orphan);
			orphan.setOrganization(organization);
			getSession().save(orphan);
			commit();
			return orphan;

		} catch (HibernateException e) {
			rollback();
			throw new OrganizationException("Exception while creating orphan: " + e.getMessage());
		}
	}

	public void delete(Orphan Orphan) throws OrganizationException {
		try {
			begin();
			getSession().delete(Orphan);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new OrganizationException("Could not delete advert", e);
		}
	}

	public List<Orphan> list() throws OrganizationException {

		try {
			begin();
			Query q = getSession().createQuery("from Orphan");
			List<Orphan> orphans = q.list();
			commit();
			return orphans;
		} catch (HibernateException e) {
			rollback();
			throw new OrganizationException("Could not delete orphans", e);
		}

	}

	public List<Orphan> getOrphanList(String organizationid) {
		begin();
		Query q = getSession().createQuery("from Orphan where organization_organizationid =:organizationid");
		q.setString("organizationid", organizationid);
		List<Orphan> orphan = q.list();
		commit();
		close();
		return orphan;
	}

	public Orphan get(Orphan orphan) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from Orphan where firstname= :firstname");
			q.setString("firstname", orphan.getFirstname());
			Orphan orphan1 = (Orphan) q.uniqueResult();
			commit();
			return orphan1;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Try selecting different username.Could not register user name : ", e);
		}

	}

	public Orphan getOrp(String name) throws UserException {

		begin();
		Query q = getSession().createQuery("from Orphan where firstname= :name");
		q.setString("name", name);
		Orphan orphan1 = (Orphan) q.uniqueResult();
		commit();
		return orphan1;
	}

	public List<Orphan> searchOrphan(String name) {
		begin();
		Query q = getSession().createQuery("from Orphan where firstname =:name");
		q.setString("name", name);
		List<Orphan> orphan = q.list();
		commit();
		close();
		return orphan;
	}
}