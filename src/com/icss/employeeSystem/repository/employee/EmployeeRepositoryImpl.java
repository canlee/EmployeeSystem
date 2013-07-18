package com.icss.employeeSystem.repository.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.framework.base.dao.BaseDao;

@Component("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public void deleteByPost(int postId) {
		String sql = "DELETE FROM employee WHERE postId=" + postId + ";";
		baseDao.execute(sql);
	}
	
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

}
