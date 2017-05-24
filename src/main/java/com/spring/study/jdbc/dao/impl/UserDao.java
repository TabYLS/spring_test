package com.spring.study.jdbc.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.study.domain.User;
import com.spring.study.jdbc.dao.IUserDao;

/**
 * java 不定参数比如JdbcTemplate的update方法
 * 不定参数有两个规定：第一，方法的参数列表中最多只有一个不定长度的参数；第二，就是不定长度的数组的位置必须是最后一个参数。不
 * @author YLS
 *
 */
@Repository("userJdbcDao")
public class UserDao implements IUserDao {
	
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
	public void add(User user, int gid) {
		String sql  = "insert into jdbcuser(username,password,status,descn,gid) value(?,?,?,?,?)";
		jdbcTemplate.update(sql, user.getUserName(),user.getPassword(),user.getStatus(),user.getDescn(),gid);
	}

	@Override
	public void update(User user) {
		String sql = "update jdbcuser set username = ?, password = ? where id = ?";
		jdbcTemplate.update(sql, user.getUserName(),user.getPassword(),user.getId());

	}

	@Override
	public void delete(int id) {
		String sql = "delete from jdbcuser where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public User load(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> list(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

}
