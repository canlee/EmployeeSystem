package com.icss.framework.base.dao.jdbc;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class JdbcDaoHelper extends JdbcDaoSupport {
	public final int queryForInt(final String sql) throws DataAccessException {
		return getJdbcTemplate().queryForInt(sql);
	}

	public final int queryForInt(final String sql, final List<?> paras)
			throws DataAccessException {
		return getJdbcTemplate().queryForInt(sql, paras.toArray());
	}

	public final long queryForLong(final String sql) throws DataAccessException {
		return getJdbcTemplate().queryForLong(sql);
	}

	public final long queryForLong(final String sql, final List<?> paras)
			throws DataAccessException {
		return getJdbcTemplate().queryForLong(sql, paras.toArray());
	}

	public final List<?> queryForList(
			final String sql, final List<?> paras)
			throws DataAccessException {
		return getJdbcTemplate().queryForList(sql, paras.toArray());
	}
}
