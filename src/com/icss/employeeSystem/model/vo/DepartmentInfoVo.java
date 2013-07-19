package com.icss.employeeSystem.model.vo;

import java.util.List;

public class DepartmentInfoVo {

	private int depId;
	private String depName;
	private int employeeCount;
	private List<EmpDepInfoVo> employees;
	
	/**
	 * 部门的id
	 * @return
	 */
	public int getDepId() {
		return depId;
	}
	
	public void setDepId(int depId) {
		this.depId = depId;
	}
	
	/**
	 * 部门的名称
	 * @return
	 */
	public String getDepName() {
		return depName;
	}
	
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
	/**
	 * 部门的人员人数
	 * @return
	 */
	public int getEmployeeCount() {
		return employeeCount;
	}
	
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	/**
	 * 部门的所有人员信息
	 * @return
	 */
	public List<EmpDepInfoVo> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<EmpDepInfoVo> employees) {
		this.employees = employees;
	}
	
}
