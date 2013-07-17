package com.icss.employeeSystem.repository.department;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.icss.employeeSystem.model.po.Department;
import com.icss.employeeSystem.model.po.Employee;
import com.icss.framework.base.dao.BaseDao;

@Component("departmentRepository")
public class DepartmentRepositoryImpl implements DepartmentRepository {

	private BaseDao baseDao;
	
	@Override
	public List<Department> getAllDepartment() {
		String sql = "SELECT * FROM department;";
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> result = 
				(List<Map<String, Object>>) baseDao.queryForList(
						sql, new ArrayList<Object>());
		List<Department> deps = new ArrayList<Department>();
		for(Map<String, Object> map : result) {
			Department dep = new Department();
			dep.setDepId((Integer) map.get("depId"));
			dep.setDepName((String) map.get("depName"));
			deps.add(dep);
		}
		return deps;
	}
	
	@Override
	public int insert(Department dep) {
		return (Integer) baseDao.save(dep);
	}
	
	@Override
	public Department getDepartmentByName(String name) {
		String sql = "SELECT * FROM department WHERE depName='" + name + "';";
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> result = 
				(List<Map<String, Object>>) baseDao.queryForList(
						sql, new ArrayList<Object>());
		if(result != null && result.size() != 0) {
			Department dep = new Department();
			Map<String, Object> map = result.get(0);
			dep.setDepId((Integer) map.get("depId"));
			dep.setDepName((String) map.get("depName"));
			return dep;
		}
		return null;
	}
	
	@Override
	public List<Employee> getEmployeeInDepartment(int depId) {
		String sql = 
				"SELECT empId FROM employee WHERE postId in " +
				"(SELECT postId FROM post WHERE depId=" + depId + ");";
		@SuppressWarnings("unchecked")
		List<Map<String, String>> result = 
				(List<Map<String, String>>) baseDao.queryForList(
						sql, new ArrayList<Object>());
		List<Employee> emps = new ArrayList<Employee>();
		for(Map<String, String> map : result) {
			String id = map.get("empId");
			emps.add((Employee) baseDao.get(Employee.class, id));
		}
		return emps;
	}
	
	@Override
	public boolean update(Department dep) {
		try {
			baseDao.update(dep);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public void delete(Department dep) {
		baseDao.delete(dep);
	}
	
	@Override
	public Department getById(int depId) {
		return (Department) baseDao.get(Department.class, depId);
	}
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
