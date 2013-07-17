package com.icss.employeeSystem.repository.department;

import java.util.List;

import com.icss.employeeSystem.model.po.Department;
import com.icss.employeeSystem.model.po.Employee;

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
	
	public Department getById(int depId);
	
	/**
	 * 查询有多少员工在该部门
	 * @param depId
	 * @return
	 */
	public List<Employee> getEmployeeInDepartment(int depId);
	
}
