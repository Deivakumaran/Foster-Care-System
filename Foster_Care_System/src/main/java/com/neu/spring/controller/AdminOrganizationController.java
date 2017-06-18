package com.neu.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.neu.spring.dao.AdminOrganizationDAO;
import com.neu.spring.dao.OrganizationDAO;
import com.neu.spring.dao.OrganizationOrphanDAO;
import com.neu.spring.exception.OrganizationException;
import com.neu.spring.pojo.Organization;
import com.neu.spring.pojo.Orphan;

@Controller
public class AdminOrganizationController {

	@Autowired
	AdminOrganizationDAO adminOrganizationDao;

	@Autowired
	OrganizationDAO organizationDao;

	@Autowired
	OrganizationOrphanDAO organizationOrphanDao;

	@RequestMapping(value = "/admin/organization_manage.htm", method = RequestMethod.GET)
	protected ModelAndView organizationManage() throws Exception {

		return new ModelAndView("admin-organization-manage-home");
	}

	@RequestMapping(value = "/admin/organization_add.htm", method = RequestMethod.GET)
	protected ModelAndView organizationAdd() throws Exception {

		return new ModelAndView("admin-organization-add", "organization", new Organization());
	}

	@RequestMapping(value = "/admin/organization_view.htm", method = RequestMethod.GET)
	protected ModelAndView organizationView(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		List<Organization> organizationList = organizationDao.getOrganization();
		session.setAttribute("organizationList", organizationList);
		return new ModelAndView("admin-organization-all-view");
	}

	@RequestMapping(value = "/admin/organization_select.htm", method = RequestMethod.POST)
	public ModelAndView organizationDetailView(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String organizationid = request.getParameter("organizationid");
		Organization organization = organizationDao.getOrganizationDetail(organizationid);
		session.setAttribute("organization", organization);
		return new ModelAndView("admin-organization-view-detail", "organization", organization);
	}

	@RequestMapping(value = "/admin/orphan_manage.htm", method = RequestMethod.GET)
	public ModelAndView orphanViewOrganization(HttpServletRequest request) {

		HttpSession session = request.getSession();
		List<Organization> organizationList = organizationDao.getOrganization();
		session.setAttribute("organizationList", organizationList);
		return new ModelAndView("admin-orphan-organization-select");
	}

	@RequestMapping(value = "/admin/orphan_view.htm", method = RequestMethod.GET)
	public ModelAndView orphanManage(HttpServletRequest request) {

		return new ModelAndView("admin-orphan-home", "organization", new Organization());

	}

	@RequestMapping(value = "/admin/organization_orphan_select.htm", method = RequestMethod.POST)
	public ModelAndView orphanAllView(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String organizationid = request.getParameter("organizationid");
		List<Orphan> orphanList = organizationOrphanDao.getOrphanList(organizationid);
		session.setAttribute("orphanList", orphanList);
		return new ModelAndView("admin-orphan-view-organization-wise", "orphanList", orphanList);
	}

	@RequestMapping(value = "/admin/organization_add.htm", method = RequestMethod.POST)
	protected ModelAndView organizationProcess(HttpServletRequest request,
			@ModelAttribute("organization") Organization org, BindingResult result) throws Exception {
		try {

			Organization organiz = adminOrganizationDao.create(org);
			request.getSession().setAttribute("organization", organiz);
			return new ModelAndView("admin-organization-success", "organization", organiz);
		} catch (OrganizationException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}
}
