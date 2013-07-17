package com.icss.employeeSystem.action.Authority;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.icss.employeeSystem.model.vo.EmployeeVo;
import com.icss.employeeSystem.service.authority.EmpAuthService;
import com.icss.employeeSystem.util.JsonUtil;
import com.opensymphony.xwork2.ActionSupport;

public class GetMyAuthorityAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private EmpAuthService empAuthService;
	
	public void getAuthority() 
			throws JsonGenerationException, JsonMappingException, IOException {
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		HttpSession session = ServletActionContext.getRequest().getSession();
		@SuppressWarnings("unchecked")
		List<Integer> auths = (List<Integer>) session.getAttribute("authIds");
		if(auths != null) {
			JsonUtil.sendJson(out, "authorities", auths);
		}
		else {
			//重数据库中读取用户的权限
			EmployeeVo emp = (EmployeeVo) session.getAttribute("employee");
			auths = empAuthService.getAllAuthorities(emp.getEmpID());
			session.setAttribute("authIds", auths);
			JsonUtil.sendJson(out, "authorities", auths);
		}
		out.flush();
		out.close();
	}

	public void setEmpAuthService(EmpAuthService empAuthService) {
		this.empAuthService = empAuthService;
	}
	
}
