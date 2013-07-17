package com.icss.employeeSystem.action.department;

import java.util.List;

import com.icss.employeeSystem.action.BaseAction;
import com.icss.employeeSystem.model.po.Department;
import com.icss.employeeSystem.service.department.DepartmentService;

public class DepartmentAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	private DepartmentService departmentService;
	
	public String addDepartment() {
		List<Department> deps = departmentService.getAllDepartment();
		getRequest().setAttribute("departments", deps);
		return "success";
	}
	
	public String insert() {
		String depName = getRequest().getParameter("department");
		System.out.println(depName);
		Department dep = new Department();
		dep.setDepName(depName);
		if(departmentService.inset(dep)) {
			return "success";
		}
		else {
			return "false";
		}
	}
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

}
