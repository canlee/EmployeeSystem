package com.icss.employeeSystem.service;

import java.io.Serializable;

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
	
}
