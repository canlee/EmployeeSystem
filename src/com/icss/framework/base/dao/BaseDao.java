package com.icss.framework.base.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

public interface BaseDao {
	public Serializable save(Object obj) throws DataAccessException;

	public void update(Object obj) throws DataAccessException;
	
	public void delete(Object obj) throws DataAccessException;
	
	public Object get(Class<?> clazz, Serializable id) throws DataAccessException;

	public int queryForInt(final String sql) throws DataAccessException;

	public int queryForInt(final String sql, final List<?> paras)
			throws DataAccessException;

	public long queryForLong(final String sql) throws DataAccessException;

	public long queryForLong(final String sql, final List<?> paras)
			throws DataAccessException;

	public List<?> queryForList(final String sql, final List<?> paras)
			throws DataAccessException;
	
	public void execute(String sql) throws DataAccessException;
}