package com.coo.s4.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		Object object = request.getSession().getAttribute("member");
		boolean result = false;
		if (object != null) {
			result = true;
		} else {
			response.sendRedirect("../member/memberLogin");
		}
		return result;
	}

}
