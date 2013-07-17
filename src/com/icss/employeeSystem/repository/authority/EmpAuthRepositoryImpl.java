package com.icss.employeeSystem.repository.authority;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.framework.base.dao.BaseDao;

@Component("empAuthRepository")
public class EmpAuthRepositoryImpl implements EmpAuthRepository {

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public List<Integer> getAllAuthorities(String empId) {
		String sql = "SELECT authId FROM employee_authority " +
				"WHERE empId='" + empId + "';";
		@SuppressWarnings("unchecked")
		List<Map<String, Integer>> result = 
			(List<Map<String, Integer>>) baseDao.queryForList(
					sql, new ArrayList<Object>());
		List<Integer> allAu = new ArrayList<Integer>();
		for(Map<String, Integer> map : result) {
			allAu.add(map.get("authId"));
		}
		return allAu;
	}
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}
	
}
