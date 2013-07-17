package com.icss.employeeSystem.service.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.employeeSystem.model.po.Department;
import com.icss.employeeSystem.repository.department.DepartmentRepository;

@Component("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAllDepartment() {
		return departmentRepository.getAllDepartment();
	}
	
	@Override
	public boolean inset(Department dep) {
		if(departmentRepository.getDepartmentByName(dep.getDepName()) == null) {
			int id = departmentRepository.insert(dep);
			dep.setDepId(id);
			return true;
		}
		return false;
	}
	
	public void setDepartmentRepository(
			DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

}
