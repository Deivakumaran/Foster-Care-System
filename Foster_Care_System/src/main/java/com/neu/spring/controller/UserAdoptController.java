package com.neu.spring.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.neu.spring.dao.UserAdoptDAO;
import com.neu.spring.pojo.Adoption;
import com.neu.spring.pojo.Organization;
import com.neu.spring.pojo.Orphan;
import com.neu.spring.pojo.User;

@Controller
public class UserAdoptController {

	@Autowired
	UserAdoptDAO userAdoptDao;

	@RequestMapping(value = "/user/orphan_manage_adopt.htm", method = RequestMethod.GET)
	protected ModelAndView manageAdoptOrphan() throws Exception {

		return new ModelAndView("user-adopt-home");

	}

	@RequestMapping(value = "/user/orphan_listOrphan.htm", method = RequestMethod.GET)
	protected ModelAndView listOrphan(HttpServletRequest request) throws Exception {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		System.out.println("List Orphans");
		List<Orphan> orphanList = userAdoptDao.getOrphan(user);
		session.setAttribute("orphanList", orphanList);
		return new ModelAndView("list-orphan");

	}

	@RequestMapping(value = "/user/orphan_viewOrphans.htm", method = RequestMethod.POST)
	public ModelAndView viewOrphan(HttpServletRequest request) {

		HttpSession session = request.getSession();
		String orphanid = request.getParameter("orphanid");
		Orphan orphan = userAdoptDao.getOrphanView(orphanid);
		session.setAttribute("orphan", orphan);
		return new ModelAndView("user-view-orphan", "orphan", orphan);
	}

	@RequestMapping(value = "/user/orphan_adoptOrphanFinal.htm", method = RequestMethod.POST)
	public ModelAndView adoptFinalOrphan(HttpServletRequest request) {

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String orphanid = request.getParameter("id");
		Organization organization = user.getOrganization();
		userAdoptDao.adoptOrphan(orphanid, user, organization);
		Orphan orphan = userAdoptDao.getOrphanView(orphanid);
		session.setAttribute("orphan", orphan);
		return new ModelAndView("user-success-adopt", "orphan", orphan);

	}

}
