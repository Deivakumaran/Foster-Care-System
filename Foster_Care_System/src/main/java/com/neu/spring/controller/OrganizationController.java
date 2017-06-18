package com.neu.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.neu.spring.dao.OrganizationDAO;
import com.neu.spring.exception.UserException;
import com.neu.spring.pojo.Organization;

@Controller
public class OrganizationController {

	@Autowired
	OrganizationDAO organizationDao;

	@RequestMapping(value = "/organization/login.htm", method = RequestMethod.GET)
	protected ModelAndView organizationLogin() throws Exception {

		return new ModelAndView("organization-login");
	}

	@RequestMapping(value = "/organization/login.htm", method = RequestMethod.POST)
	protected String loginOrganization(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		try {
			Organization org = organizationDao.get(request.getParameter("username"), request.getParameter("password"));
			if (org == null) {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
			}
			session.setAttribute("organization", org);
			return "organization-home";

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return "error";
		}
	}
}
