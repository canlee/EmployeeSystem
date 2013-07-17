package com.icss.employeeSystem.repository.department;

import java.util.List;

import com.icss.employeeSystem.model.po.Department;

public interface DepartmentRepository {

	/**
	 * 获取所有的部门信息
	 * @return
	 */
	public List<Department> getAllDepartment();
	
	/**
	 * 插入一个新的部门
	 * @param dep
	 * @return
	 */
	public int insert(Department dep);
	
	public Department getDepartmentByName(String name);
	
}
