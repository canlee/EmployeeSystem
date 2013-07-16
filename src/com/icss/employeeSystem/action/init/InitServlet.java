package com.icss.employeeSystem.action.init;

import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.icss.employeeSystem.repository.DatabaseFactory;
import com.icss.employeeSystem.service.init.InitAdminService;
import com.icss.employeeSystem.service.init.InitAdminServiceImpl;
import com.icss.employeeSystem.service.init.InitAuthorityService;
import com.icss.employeeSystem.service.init.InitAuthorityServiceImpl;

public class InitServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		ServletConfig config = getServletConfig();
		
		//数据库连接
		String DBDriver = config.getInitParameter("DBDriver");
		String DBConnStr = config.getInitParameter("DBConnStr");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		Connection connection = DatabaseFactory.open(
				DBDriver, DBConnStr, user, password);
		
		//初始化权限
		String authorityPath = config.getInitParameter("allAuthority");
		InitAuthorityService auService = new InitAuthorityServiceImpl(connection);
		auService.initAuthority(
				config.getServletContext().getRealPath("/") + 
				"/WEB-INF/classes/" + authorityPath);
		
		//初始化管理员名单
		String userPath = config.getInitParameter("admin");
		InitAdminService adService = new InitAdminServiceImpl(connection);
		adService.initAdmin(
				config.getServletContext().getRealPath("/") + 
				"/WEB-INF/classes/" + userPath);
		
		//关闭数据库
		DatabaseFactory.close(connection);
	}
	
}
