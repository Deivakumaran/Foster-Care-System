package com.neu.spring.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Entity
@Table(name = "orphan_table")

@PrimaryKeyJoinColumn(name = "orphan_id")
public class Orphan extends Person {

	private String currentstatus;

	@Transient
	private CommonsMultipartFile photo;

	public Orphan(String currentstatus, Organization organization) {
		this.currentstatus = currentstatus;
		this.organization = organization;
	}

	public Orphan() {

	}

	@OneToOne(mappedBy = "orphan", cascade = { CascadeType.ALL })
	private Adoption adoption;

	@OneToOne(cascade = { CascadeType.ALL })
	private Address address;

	@OneToOne(cascade = { CascadeType.ALL })
	private Email email;

	@ManyToOne(cascade = CascadeType.MERGE)
	Organization organization;

	@Column(name = "image")
	private String image;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getCurrentstatus() {
		return currentstatus;
	}

	public void setCurrentstatus(String currentstatus) {
		this.currentstatus = currentstatus;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public CommonsMultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(CommonsMultipartFile photo) {
		this.photo = photo;
	}

	public Adoption getAdoption() {
		return adoption;
	}

	public void setAdoption(Adoption adoption) {
		this.adoption = adoption;
	}

}
