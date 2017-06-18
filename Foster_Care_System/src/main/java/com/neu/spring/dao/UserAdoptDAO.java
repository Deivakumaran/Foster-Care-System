package com.neu.spring.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import com.neu.spring.pojo.Adoption;
import com.neu.spring.pojo.Organization;
import com.neu.spring.pojo.Orphan;
import com.neu.spring.pojo.User;

public class UserAdoptDAO extends DAO {

	public List<Orphan> getOrphan(User user) {

		begin();
		long id = user.getOrganization().getOrganizationid();
		Query q = getSession().createQuery(
				"from Orphan where organization_organizationid = :organizationid AND currentstatus =:status");
		q.setLong("organizationid", id);
		q.setString("status", "Not-Adopted");
		List<Orphan> orphan = q.list();
		commit();
		close();
		return orphan;

	}

	public Orphan getOrphanView(String orphanid) {

		begin();
		Query q = getSession().createQuery("from Orphan where orphan_id = :orphanid ");
		q.setString("orphanid", orphanid);
		Orphan orphan = (Orphan) q.uniqueResult();
		commit();
		close();
		return orphan;

	}

	public void adoptOrphan(String orphanid, User user, Organization organization) {

		begin();
		Query q = getSession().createQuery("from Orphan where orphan_id = :orphanid ");
		q.setString("orphanid", orphanid);
		Orphan orphan = (Orphan) q.uniqueResult();
		orphan.setCurrentstatus("Adopted");
		Adoption adoption = new Adoption();
		adoption.setOrphan(orphan);
		orphan.setAdoption(adoption);
		adoption.setUser(user);
		user.setAdoption(adoption);
		Set<Organization> org = new HashSet<Organization>();
		org.add(organization);
		adoption.setOrganization(org);
		getSession().merge(adoption);
		getSession().flush();
		commit();
		getSession().clear();
		close();

	}
}
