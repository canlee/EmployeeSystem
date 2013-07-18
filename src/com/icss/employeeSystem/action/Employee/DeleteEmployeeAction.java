package com.icss.employeeSystem.action.Employee;

import com.icss.employeeSystem.model.po.Employee;
import com.icss.employeeSystem.service.EOAService;
import com.icss.employeeSystem.service.EmployeeService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteEmployeeAction extends ActionSupport{

	private String empId;
	private EmployeeService employeeService;
	private EOAService EOAservice;
	
	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public EOAService getEOAservice() {
		return EOAservice;
	}

	public void setEOAservice(EOAService eOAservice) {
		EOAservice = eOAservice;
	}

	public String delete(){
		System.out.println(empId+"============================================");
		try {
			Employee emp = (Employee)employeeService.get(Employee.class, empId);
			employeeService.delete(emp);
			EOAservice.deleteWithEmpId(empId);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "fail";
		}
	}
}
