package com.icss.framework.base.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.icss.framework.base.dao.hibernate.HibernateDaoHelpler;
import com.icss.framework.base.dao.jdbc.JdbcDaoHelper;

public class BaseDaoImpl implements BaseDao {
	private HibernateDaoHelpler hibernateDaoHelper;
	private JdbcDaoHelper jdbcDaoHelper;
	public HibernateDaoHelpler getHibernateDaoHelper() {
		return hibernateDaoHelper;
	}
	
	public void setHibernateDaoHelper(HibernateDaoHelpler hibernateDaoHelper) {
		this.hibernateDaoHelper = hibernateDaoHelper;
	}

	public JdbcDaoHelper getJdbcDaoHelper() {
		return jdbcDaoHelper;
	}

	public void setJdbcDaoHelper(JdbcDaoHelper jdbcDaoHelper) {
		this.jdbcDaoHelper = jdbcDaoHelper;
	}

	@Override
	public Serializable save(Object obj) throws DataAccessException {
		return hibernateDaoHelper.save(obj);
	}

	@Override
	public void update(Object obj) throws DataAccessException {
		hibernateDaoHelper.update(obj);
	}
	
	@Override
	public void delete(Object obj) throws DataAccessException {
		hibernateDaoHelper.delete(obj);
	}
	
	@Override
	public Object get(Class<?> clazz, Serializable id) throws DataAccessException {
		return hibernateDaoHelper.get(clazz, id);
	}

	@Override
	public int queryForInt(String sql) throws DataAccessException {
		return jdbcDaoHelper.queryForInt(sql);
	}

	@Override
	public int queryForInt(String sql, List<?> paras) throws DataAccessException {
		return jdbcDaoHelper.queryForInt(sql, paras);
	}

	@Override
	public long queryForLong(String sql) throws DataAccessException {
		return jdbcDaoHelper.queryForLong(sql);
	}

	@Override
	public long queryForLong(String sql, List<?> paras) throws DataAccessException {
		return jdbcDaoHelper.queryForLong(sql, paras);
	}

	@Override
	public List<?> queryForList(String sql, List<?> paras) throws DataAccessException {
		return jdbcDaoHelper.queryForList(sql, paras);
	}

	@Override
	public void execute(String sql) throws DataAccessException {
		jdbcDaoHelper.execute(sql);
	}

}
