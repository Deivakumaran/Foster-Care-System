package com.neu.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.neu.spring.pojo.Email;

@Entity
@Table(name = "user_table")
/*
 * This annotation specifies a primary key column that is used as a foreign key
 * to join to another table
 */

@PrimaryKeyJoinColumn(name = "personid") // primary key from User table
public class User extends Person {

	@Transient
	private String organizationtype;

	@Column(name = "username", unique = true, nullable = false)
	private String username;

	@Column(name = "password")
	private String password;

	@OneToOne(cascade = CascadeType.ALL) // whenever there is a change on one
											// entity, it is reflected on the
											// other entity
	private Email email;

	@OneToOne(cascade = { CascadeType.ALL }) // whenever there is a change on
												// one entity, it is reflected
												// on the other entity
	private Address address;

	@OneToOne(mappedBy = "user", cascade = { CascadeType.ALL })
	private Adoption adoption;

	@ManyToOne(cascade = CascadeType.ALL)
	private Organization organization;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {

	}

	public Adoption getAdoption() {
		return adoption;
	}

	public void setAdoption(Adoption adoption) {
		this.adoption = adoption;
	}

	public String getOrganizationtype() {
		return organizationtype;
	}

	public void setOrganizationtype(String organizationtype) {
		this.organizationtype = organizationtype;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}