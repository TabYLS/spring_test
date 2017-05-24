package com.spring.study.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.spring.study.domain.Group;
import com.spring.study.jdbc.dao.IGroupDao;

@Repository("groupJdbcDao")
public class GroupDao implements IGroupDao {

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
	public void add(final Group group) {
		//String sql = "insert into jdbcgroup(id,name) value(?,?)";
		//jdbcTemplate.update(sql, null, group.getName());
		
		/**
		 * 通过一下方法可以添加一个对象，并且返回这个对象自动递增的id
		 */
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				String sql = "insert into jdbcgroup(name) value(?)";
				PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
				ps.setString(1, group.getName());
				// TODO Auto-generated method stub
				return ps;
			}
		}, keyHolder);
		group.setId(keyHolder.getKey().intValue());
	}

}
