package com.spring.study.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.study.domain.Group;
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
		String sql = "SELECT u.id userid, u.username, u.descn, g.id gid, g.name gname "
				+ "FROM jdbcuser u "
				+ "LEFT JOIN jdbcgroup g "
				+ "ON g.id = u.gid "
				+ "WHERE u.id = ?";
		/**
		 * 第一个参数是SQL语句
		 * 第二个参数是SQL语句中的参数值，需要传入一个对象数组（可以传入多个参数）
		 * 第三参数是一个RowMapper，这个rowMapper可以完成一个对象和数据库字段的对应，实现这个RowMapper需要
		 * 实现mapRow方法，在mapRow方法中有rs这个参数，通过rs可以有效的获取数据库的字段
		 */
		User user = (User)jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
		return user;
	}

	@Override
	public List<User> list(String sql,  Object[] args) {
		//获取整数值(获取行数)
		String sqlCount = "select count(*) from jdbcuser";
		int cout = jdbcTemplate.queryForObject(sqlCount, Integer.class);
		System.out.println(cout);
		//获取列表值（String类型的列表）
		String sqlSelectOneNum = "select descn from jdbcuser";
		List<String> descn = jdbcTemplate.queryForList(sqlSelectOneNum,String.class);
		for (String string : descn) {
			System.out.println(string);
		}
		
		return jdbcTemplate.query(sql, args,new UserMapper());
	}
	
	private class UserMapper implements RowMapper<User>{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			Group group = new Group();
			group.setName(rs.getString("gname"));
			group.setId(rs.getInt("gid"));
			User user = new User();
			user.setGroup(group);
			user.setUserName(rs.getString("username"));
			user.setId(rs.getInt("userid"));
			user.setPassword(rs.getString("password"));
			user.setStatus(rs.getInt("status"));
			user.setDescn(rs.getString("descn"));
			return user;
		}
		
	}

}
