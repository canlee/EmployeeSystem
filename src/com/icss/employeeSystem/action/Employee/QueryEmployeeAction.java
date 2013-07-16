package com.icss.employeeSystem.action.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icss.employeeSystem.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryEmployeeAction extends ActionSupport{

	private EmployeeService employeeService;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public String query(){
		ActionContext ac = ActionContext.getContext();
		String sql = "select * from Employee";
		List<Map<String, Object>> employeeList = new ArrayList<Map<String,Object>>();
		try {
			employeeList = (List<Map<String, Object>>)employeeService.queryForList(sql, employeeList);
			ac.put("employeeList", employeeList);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			return "fail";
		}		
		
	}
}
