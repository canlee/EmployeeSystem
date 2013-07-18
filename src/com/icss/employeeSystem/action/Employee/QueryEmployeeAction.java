package com.icss.employeeSystem.action.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.icss.employeeSystem.model.vo.EmployeeVo;
import com.icss.employeeSystem.service.EOAService;
import com.icss.employeeSystem.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryEmployeeAction extends ActionSupport{

	private EmployeeService employeeService;
	private EOAService EOAservice;
	private String empId = "";
	private String depId = "%";
	private String postId = "%";
	private String target;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public EOAService getEOAservice() {
		return EOAservice;
	}

	public void setEOAservice(EOAService eOAservice) {
		EOAservice = eOAservice;
	}

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
		if(empId.equals("")){
			if(target.equals("individual")||target.equals("update")){
				empId = ((EmployeeVo)ac.getSession().get("employee")).getEmpID();
			}
			else{
				empId = "%";
			}
		}		
		String sql = "select * from Employee,Post,Department where Employee.postId=Post.postId and Post.depId=Department.depId and " +
				"Employee.empId like ? and Employee.postId like ? and Post.depId like ?";
		List<Map<String, Object>> employeeList = new ArrayList<Map<String,Object>>();
		List<String> param = new ArrayList<String>();
		param.add(empId);
		param.add(postId);
		param.add(depId);
		try {
			employeeList = (List<Map<String, Object>>)employeeService.queryForList(sql, param);
			ac.put("employeeList", employeeList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
		
		if(target.equals("individual")){
			sql = "select authorityName from employee_authority,Authority where employee_authority.authId = Authority.authorityId and employee_authority.empId = "+empId;
			try {
				List<Map<String, String>> authorityList = new ArrayList<Map<String,String>>();
				authorityList = (List<Map<String, String>>)EOAservice.queryForList(sql, authorityList);
				//authorityList.get(0).get("authorityName");
				ac.put("authorityList", authorityList);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return "fail";
			}
		}
		return target;
	}
}
