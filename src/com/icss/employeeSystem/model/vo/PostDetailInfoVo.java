package com.icss.employeeSystem.model.vo;

import java.util.List;

/**
 * 在显示查询岗位信息时候显示的
 * @author 李亮灿
 *
 */
public class PostDetailInfoVo {

	private String postName;
	private int employeeCount;
	private List<EmpPostInfoVo> employees;
	
	public String getPostName() {
		return postName;
	}
	
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	public int getEmployeeCount() {
		return employeeCount;
	}
	
	public void setEmployeeCount(int employeeCount) {
		this.employeeCount = employeeCount;
	}
	
	public List<EmpPostInfoVo> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<EmpPostInfoVo> employees) {
		this.employees = employees;
	}
	
}
