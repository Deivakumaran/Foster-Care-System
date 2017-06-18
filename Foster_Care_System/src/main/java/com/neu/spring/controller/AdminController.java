package com.neu.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.spring.pojo.User;

@Controller
public class AdminController {

	@RequestMapping(value = "/admin/login.htm", method = RequestMethod.GET)
	protected ModelAndView adminLogin() throws Exception {
	   return new ModelAndView("admin-login");
	}

	@RequestMapping(value = "/admin/login.htm", method = RequestMethod.POST)
	protected String adminHome(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();

		try {

			System.out.println("loginAdmin");

			if (request.getParameter("username").equalsIgnoreCase("admin")
					&& request.getParameter("password").equalsIgnoreCase("admin")) {
				User user = new User();
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				session.setAttribute("user", user);
				return "admin-home";
			} else {
				session.setAttribute("errorMessage", "Please enter the valid credentials");
				return "error";
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "Error while login");
			return "error";
		}
	}
}