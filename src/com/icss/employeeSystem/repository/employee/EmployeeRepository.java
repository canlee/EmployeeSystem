package com.icss.employeeSystem.repository.employee;

public interface EmployeeRepository {

	/**
	 * 删除指定岗位下的人员
	 * @param postId
	 */
	public void deleteByPost(int postId);
	
}
