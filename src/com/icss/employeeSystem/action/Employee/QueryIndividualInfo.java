package com.icss.employeeSystem.action.Employee;

import com.icss.employeeSystem.model.po.Employee;
import com.icss.employeeSystem.model.vo.EmployeeVo;
import com.icss.employeeSystem.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class QueryIndividualInfo extends ActionSupport{

	private String empId;
	private EmployeeService employeeService;
	
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

	public String query(){
		try {
			ActionContext ac = ActionContext.getContext();
			if(empId==null){
				setEmpId(((EmployeeVo)ac.getSession().get("employee")).getEmpID());
			}
			Employee emp = (Employee)employeeService.get(Employee.class, getEmpId());
			ac.put("emp", emp);
			System.out.println("+++++++ASFDSADFASDF++++++++++++++");
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}		
	}
}
