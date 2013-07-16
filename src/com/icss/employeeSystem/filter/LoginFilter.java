package com.icss.employeeSystem.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpSession session = req.getSession();
		if(session.getAttribute("employee") == null) {
			String url = req.getRequestURI();
			if(url.endsWith("login.htm") || url.endsWith("login")) {
				arg2.doFilter(arg0, arg1);
			}
			else {
				HttpServletResponse resp = (HttpServletResponse) arg1;
				resp.getWriter().write(
						"<SCRIPT type=\"text/javascript\">" +
						"top.document.location='/EmployeeSystem/login.htm';" +
						"</SCRIPT>");
			}
		}
		else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
