package com.icss.employeeSystem.service.department;

import java.util.List;

import com.icss.employeeSystem.model.po.Department;

public interface DepartmentService {

	/**
	 * 获取所有的部门
	 * @return
	 */
	public List<Department> getAllDepartment();
	
	/**
	 * 插入一个新部门
	 * @param dep
	 * @return 如果插入成功返回true，并且把新的id复制到dep中
	 */
	public boolean inset(Department dep);
	
}
