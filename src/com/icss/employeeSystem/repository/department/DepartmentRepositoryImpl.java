package com.icss.employeeSystem.repository.department;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.icss.employeeSystem.model.po.Department;
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
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
