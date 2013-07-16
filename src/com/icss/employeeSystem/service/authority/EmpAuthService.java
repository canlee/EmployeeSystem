package com.icss.employeeSystem.service.authority;

import java.util.List;

/**
 * 主要操控员工和权力间的关系
 * @author 李亮灿
 *
 */
public interface EmpAuthService {
	
	/**
	 * 根据员工的id获取所拥有的权力
	 * @param empId
	 * @return
	 */
	public List<Integer> getAllAuthorities(String empId);
	
}
