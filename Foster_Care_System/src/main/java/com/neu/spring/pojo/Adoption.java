package com.neu.spring.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "adoption_table")
public class Adoption {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "adoptionid", unique = true, nullable = false)
	private long adoptionid;

	@OneToOne(cascade = CascadeType.ALL)
	private Orphan orphan;

	@OneToOne(cascade = CascadeType.ALL)
	private User user;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Organization> organization;

	public Adoption() {

	}

	public Adoption(long adoptionid, Orphan orphan, User user, Organization organization) {
		super();
		this.adoptionid = adoptionid;
		this.orphan = orphan;
		this.user = user;
		this.organization = new HashSet<Organization>();
	}

	public long getAdoptionid() {
		return adoptionid;
	}

	public void setAdoptionid(long adoptionid) {
		this.adoptionid = adoptionid;
	}

	public Orphan getOrphan() {
		return orphan;
	}

	public void setOrphan(Orphan orphan) {
		this.orphan = orphan;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Organization> getOrganization() {
		return organization;
	}

	public void setOrganization(Set<Organization> organization) {
		this.organization = organization;
	}

}
