package com.neu.spring.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.neu.spring.pojo.Address;

@Entity
@Table(name = "organization_table")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "organizationid", unique = true, nullable = false)
	private long organizationid;
	private String organizationname;
	private String password;
	private String phonenumber;

	@ManyToMany
	@JoinTable(name = "organization_adoption_table", joinColumns = {
			@JoinColumn(name = "organizationid", nullable = false, unique = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "adoptionid") })

	private Set<Adoption> adoption;

	public Organization(long organizationid, String organizationname, String password, String phonenumber,
			Set<Adoption> adoption, Address address, Email email, Set<Orphan> orphan, Set<User> user) {

		this.organizationid = organizationid;
		this.organizationname = organizationname;
		this.password = password;
		this.phonenumber = phonenumber;
		this.adoption = adoption;
		this.address = address;
		this.email = email;
		this.orphan = orphan;
		this.adoption = new HashSet<Adoption>();
	}

	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;

	@OneToOne(cascade = { CascadeType.ALL })
	private Email email;

	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	private Set<Orphan> orphan;

	@OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
	private Set<User> user;

	public Organization() {

	}

	public Organization(long organizationID, String organizationName, Address address, Email email, Orphan orphan) {

		this.organizationid = organizationID;
		this.organizationname = organizationName;
		this.address = address;
		this.email = email;
	}

	public Set<Adoption> getAdoption() {
		return adoption;
	}

	public void setAdoption(Set<Adoption> adoption) {
		this.adoption = adoption;
	}

	public long getOrganizationid() {
		return organizationid;
	}

	public void setOrganizationid(long organizationid) {
		this.organizationid = organizationid;
	}

	public String getOrganizationname() {
		return organizationname;
	}

	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Set<Orphan> getOrphan() {
		return orphan;
	}

	public void setOrphan(Set<Orphan> orphan) {
		this.orphan = orphan;
	}

	public Set<User> getUser() {
		return user;

	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
