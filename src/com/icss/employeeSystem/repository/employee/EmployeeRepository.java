package com.icss.employeeSystem.repository.employee;

public interface EmployeeRepository {

	/**
	 * 删除指定岗位下的人员
	 * @param postId
	 */
	public void deleteByPost(int postId);
	
	/**
	 * 删除指定部门下的所有人员
	 * @param depId
	 */
	public void deleteByDep(int depId);
	
}
