package com.neu.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.neu.spring.pojo.Organization;
import com.neu.spring.pojo.User;

@Component
public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String uri = request.getRequestURI();

		if (!uri.endsWith("/user/login.htm") && !uri.endsWith("/organization/login.htm")
				&& !uri.endsWith("/admin/login.htm")) {
			User user = (User) request.getSession().getAttribute("user");
			Organization org = (Organization) request.getSession().getAttribute("organization");

			if (user == null && org == null) {
				response.sendRedirect(request.getContextPath());
				return false;
			}

		}

		return true;
	}
}