package com.neu.spring.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.neu.spring.validator.UserValidator;
import com.neu.spring.dao.OrganizationDAO;
import com.neu.spring.dao.UserDAO;
import com.neu.spring.exception.UserException;
import com.neu.spring.pojo.Organization;
import com.neu.spring.pojo.User;

@Controller
public class UserController {

	@Autowired
	UserDAO userDao;
	@Autowired
	OrganizationDAO organizationDao;

	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value = "/user/login.htm", method = RequestMethod.GET)
	protected ModelAndView homeLoginUser() throws Exception {

		return new ModelAndView("user-login");

	}

	@RequestMapping(value = "/user/login.htm", method = RequestMethod.POST)
	protected String loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		try {

			User u = userDao.get(request.getParameter("username"), request.getParameter("password"));

			if (u == null) {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return "error";
			}
			session.setAttribute("user", u);
			return "user-home";
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "Please enter valid username ");
			return "error";
		}

	}

	@RequestMapping(value = "/user/register.htm", method = RequestMethod.GET)
	protected ModelAndView registerUser(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		String name = "";
		List<Organization> orgList = organizationDao.getOrganization();
		ArrayList<String> nameList = new ArrayList<String>();
		for (Organization org : orgList) {
			name = org.getOrganizationname();
			nameList.add(name);
		}
		session.setAttribute("nameList", nameList);
		return new ModelAndView("user-register", "user", new User());

	}

	@RequestMapping(value = "/user/register.htm", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request, @ModelAttribute("user") User user,
			BindingResult result) throws Exception {

		try {

			User u1 = userDao.get(user);
			if (u1 != null) {
				return new ModelAndView("error", "errorMessage", "Username Already exist");
			}

			String orgname = user.getOrganizationtype();
			User u = userDao.register(user, orgname);
			request.getSession().setAttribute("user", u);
			return new ModelAndView("user-home", "user", u);

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}

}
