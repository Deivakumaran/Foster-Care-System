package com.neu.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.neu.spring.exception.UserException;
import com.neu.spring.pojo.Address;
import com.neu.spring.pojo.Email;
import com.neu.spring.pojo.Organization;
import com.neu.spring.pojo.User;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			User user = (User) q.uniqueResult();
			commit();
			close();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}

	public User get(User user) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where username= :username");
			q.setString("username", user.getUsername());
			User user1 = (User) q.uniqueResult();
			commit();
			return user1;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Try selecting different username .Could not register user name : ", e);
		}

	}

	public User register(User u, String orgname) throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			Email email = new Email(u.getEmail().getEmailaddress());
			u.setEmail(email);
			email.setUser(u);

			Address address = new Address(u.getAddress().getStreet(), u.getAddress().getCity(),
					u.getAddress().getState(), u.getAddress().getCountry(), u.getAddress().getZip());
			u.setAddress(address);
			address.setUser(u);

			Query q = getSession().createQuery("from Organization where organizationname= :organizationname");
			q.setString("organizationname", orgname);
			Organization organization = (Organization) q.uniqueResult();

			u.setOrganization(organization);

			getSession().save(u);
			commit();
			return u;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUsername(), e);
		}
	}
}