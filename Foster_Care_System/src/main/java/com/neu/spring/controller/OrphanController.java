package com.neu.spring.controller;

import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.neu.spring.dao.OrganizationOrphanDAO;
import com.neu.spring.exception.OrganizationException;
import com.neu.spring.pojo.Organization;
import com.neu.spring.pojo.Orphan;

@Controller

public class OrphanController {

	@Autowired
	OrganizationOrphanDAO organizationOrphanDao;

	@RequestMapping(value = "/organization/orphan_manage.htm", method = RequestMethod.GET)
	protected ModelAndView organizationManageOrphan(HttpServletRequest request) throws Exception {

		return new ModelAndView("organization-manage-orphan");
	}

	@RequestMapping(value = "/organization/orphan_search.htm", method = RequestMethod.GET)
	protected ModelAndView organizationSearchOrphan(HttpServletRequest request) throws Exception {
		String name = request.getParameter("query");
		Orphan orphan = organizationOrphanDao.getOrp(name);
		if (orphan == null) {
			return new ModelAndView("organization-search-orphan", "orphan", orphan);
		}
		request.getSession().setAttribute("orphan", orphan);
		return new ModelAndView("organization-search-orphan-success", "orphan", orphan);

	}

	@RequestMapping(value = "/organization/orphan_add.htm", method = RequestMethod.GET)
	protected ModelAndView organizationAddOrphan() throws Exception {

		return new ModelAndView("organization-add-orphan", "orphan", new Orphan());
	}

	@RequestMapping(value = "/organization/check_orphan.htm", method = RequestMethod.GET)
	public @ResponseBody String checkPatient(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String query = request.getParameter("query");
		List<Orphan> orphanList = organizationOrphanDao.searchOrphan(query);
		if (orphanList.size() != 0) {
			session.setAttribute("orp", null);
			return orphanList.size() + "users found";
		} else {
			session.setAttribute("orp", orphanList);
			return "no user found";
		}
	}

	@RequestMapping(value = "/organization/orphan_add.htm", method = RequestMethod.POST)
	protected ModelAndView organizationProcess(HttpServletRequest request, @ModelAttribute("orphan") Orphan orp,
			BindingResult result) throws Exception {
		HttpSession session = request.getSession();
		Organization org = (Organization) session.getAttribute("organization");

		try {
			File directory;
			CommonsMultipartFile photoInMemory = null;
			File localFile = null;
			Orphan p = null;
			String path = "E:\\Images\\";
			directory = new File(path);
			boolean temp = directory.exists();
			if (!temp) {
				temp = directory.mkdir();
			}
			if (temp) {
				photoInMemory = orp.getPhoto();
				localFile = new File(directory.getPath(), orp.getFirstname() + "_".toString() + ".jpg");
				orp.setImage(localFile.getPath());
				photoInMemory.transferTo(localFile);
			} else {
				System.out.println("Failed to create directory!");
			}

			Orphan orphan = organizationOrphanDao.create(orp, org);
			request.getSession().setAttribute("orphan", orphan);
			return new ModelAndView("organization-orphan-success", "orphan", orphan);

		} catch (OrganizationException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while adding orphan");
		}

	}
}