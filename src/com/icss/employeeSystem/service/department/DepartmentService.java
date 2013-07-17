package com.icss.employeeSystem.service.department;

import java.util.List;

import com.icss.employeeSystem.model.po.Department;
import com.icss.employeeSystem.model.vo.DepartmentInfoVo;

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
	
	/**
	 * 根据部门的id获取该部门的所有信息
	 * @param depId
	 * @return
	 */
	public DepartmentInfoVo getDepartmentInfo(int depId);
	
}
