package com.neu.spring.dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.spring.exception.UserException;
import com.neu.spring.pojo.Organization;


public class OrganizationDAO extends DAO {

	public OrganizationDAO() {

	}

	public Organization get(String organizationname, String password) throws UserException {
		try {
		
			begin();
			Query q = getSession().createQuery("from Organization where organizationname = :organizationname and password = :password");
			q.setString("organizationname", organizationname);
			q.setString("password", password);
			Organization organization = (Organization) q.uniqueResult();
			commit();
			close();
			return organization;
		
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get organization " + organizationname, e);
		}
	}

	public List<Organization> getOrganization() {
		
		begin();
		Query q = getSession().createQuery("from Organization");
		List<Organization> org = q.list();
		commit();
		close();
		return org;
	
	}

	public Organization getOrganizationDetail(String organizationid) {
	
		begin();
		Query q = getSession().createQuery("from Organization where organizationid = :organizationid ");
		q.setString("organizationid", organizationid);
		Organization organization = (Organization) q.uniqueResult();
		commit();
		close();
		return organization;
		
	}

}
