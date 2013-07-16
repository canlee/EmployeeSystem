package com.icss.employeeSystem.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.icss.framework.base.dao.BaseDaoImpl;

@Component("employeeService")
public class EmployeeService {
	
	@Autowired
	private BaseDaoImpl baseDao;	

	public BaseDaoImpl getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDaoImpl baseDao) {
		this.baseDao = baseDao;
	}
	
	public Object get(Class<?> clazz, Serializable id){
		return baseDao.get(clazz, id);
	}
	
	public void save(Object obj){
		baseDao.save(obj);
	}
	
	public void update(Object obj){
		baseDao.update(obj);
	}
	
	public List<?> queryForList(final String sql, final List<?> paras){
		return baseDao.queryForList(sql, paras);
	}
}
