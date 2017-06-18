package com.neu.spring.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.spring.dao.DAO;
import com.neu.spring.exception.OrganizationException;
import com.neu.spring.pojo.Address;
import com.neu.spring.pojo.Email;
import com.neu.spring.pojo.Organization;

public class AdminOrganizationDAO extends DAO {
	public Organization create(Organization organization) throws OrganizationException {
		try {
			begin();
			Email email = new Email(organization.getEmail().getEmailaddress());
			organization.setEmail(email);
			email.setOrganization(organization);
			Address address = new Address(organization.getAddress().getStreet(), organization.getAddress().getCity(),
					organization.getAddress().getState(), organization.getAddress().getCountry(),
					organization.getAddress().getZip());
			organization.setAddress(address);
			address.setOrganization(organization);
			getSession().save(organization);
			commit();
			return organization;
		} catch (HibernateException e) {
			rollback();
			throw new OrganizationException("Exception while creating organization: " + e.getMessage());
		}
	}

	public void delete(Organization organization) throws OrganizationException {
		try {
			begin();
			getSession().delete(organization);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new OrganizationException("Could not delete organization", e);
		}
	}

	public List<Organization> list() throws OrganizationException {

		try {
			begin();
			Query q = getSession().createQuery("from organization_table");
			List<Organization> organizations = q.list();
			commit();
			return organizations;
		} catch (HibernateException e) {
			rollback();
			throw new OrganizationException("Could not delete organization", e);
		}

	}
}
