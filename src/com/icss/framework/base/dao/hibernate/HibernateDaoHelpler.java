package com.icss.framework.base.dao.hibernate;

import java.io.Serializable;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateDaoHelpler extends HibernateDaoSupport {
	public void save(Object obj) throws DataAccessException {
		getHibernateTemplate().save(obj);
	}

	public void update(Object obj) throws DataAccessException {
		getHibernateTemplate().update(obj);
	}
	
	public void delete(Object obj) throws DataAccessException {
		getHibernateTemplate().delete(obj);
	}
	
	/**
	 * 根据id查找实体类
	 * @param clazz
	 * @param id
	 * @return 
	 */
	public Object get(Class<?> clazz, Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}
}
