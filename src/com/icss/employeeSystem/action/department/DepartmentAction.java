package com.icss.employeeSystem.action.department;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.icss.employeeSystem.action.BaseAction;
import com.icss.employeeSystem.model.po.Department;
import com.icss.employeeSystem.model.vo.DepartmentInfoVo;
import com.icss.employeeSystem.service.department.DepartmentService;
import com.icss.employeeSystem.util.JsonUtil;

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
		Department dep = new Department();
		dep.setDepName(depName);
		if(departmentService.inset(dep)) {
			return "success";
		}
		else {
			return "false";
		}
	}
	
	public String queryDepartment() {
		List<Department> deps = departmentService.getAllDepartment();
		getRequest().setAttribute("departments", deps);
		return "success";
	}
	
	public void queryDetailDepartment() {
		String idStr = getRequest().getParameter("depId");
		int depId;
		try {
			depId = Integer.parseInt(idStr);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		DepartmentInfoVo depInfo = departmentService.getDepartmentInfo(depId);
		try {
			PrintWriter out = getWriter();
			JsonUtil.sendJson(out, "depInfo", depInfo);
			out.flush();
			out.close();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

}
