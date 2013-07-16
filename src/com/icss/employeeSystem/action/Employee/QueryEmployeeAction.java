package com.icss.employeeSystem.action.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.icss.employeeSystem.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryEmployeeAction extends ActionSupport{

	private EmployeeService employeeService;
	private String empId;
	private String sex;
	private String depId;
	private String postId;

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String query(){
		ActionContext ac = ActionContext.getContext();
		if(ac.getParameters().get("flag").equals("0")){
			empId = "*";
			postId = "*";
			depId = "*";
			sex = "*";
		}
		if(empId.equals(""))empId="*";
		String sql = "select * from Employee,Post,Department where Employee.postId=Post.postId and Post.depId=Department.depId and " +
				"Employee.empId like ? and Employee.postId like ? and Employee.depId like ? and sex like ?";
		List<Map<String, Object>> employeeList = new ArrayList<Map<String,Object>>();
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(postId);
		param.add(depId);
		param.add(sex);
		try {
			employeeList = (List<Map<String, Object>>)employeeService.queryForList(sql, param);
			ac.put("employeeList", employeeList);
			System.out.println("safasdfasdfasdfasdfsadfasfasdf");
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}		
		
	}
}
