package com.spring.study.jdbc.dao.impl;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.study.domain.Group;
import com.spring.study.jdbc.dao.IGroupDao;

@Repository("groupJdbcDao")
public class GroupDao implements IGroupDao {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 注入数据源
	 * @param dataSource
	 */
	@Resource
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void add(Group group) {
		String sql = "insert into jdbcgroup(id,name) value(?,?)";
		jdbcTemplate.update(sql, null, group.getName());
	}

}
