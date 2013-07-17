package com.icss.employeeSystem.repository.authority;

import java.util.List;

/**
 * 主要查询员工与权力之间的关系
 * @author 李亮灿
 *
 */
public interface EmpAuthRepository {

	/**
	 * 根据员工的id获取该员工的所有权限
	 * @param empId
	 * @return
	 */
	public List<Integer> getAllAuthorities(String empId);
	
}
