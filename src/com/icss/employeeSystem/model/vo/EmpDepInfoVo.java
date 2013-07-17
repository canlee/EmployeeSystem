package com.icss.employeeSystem.model.vo;

/**
 * 在查询部门时显示的员工信息
 * @author 李亮灿
 *
 */
public class EmpDepInfoVo {

	private String empId;
	private String empName;
	private int postId;
	private String postName;
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getEmpName() {
		return empName;
	}
	
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public int getPostId() {
		return postId;
	}
	
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public String getPostName() {
		return postName;
	}
	
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
}
