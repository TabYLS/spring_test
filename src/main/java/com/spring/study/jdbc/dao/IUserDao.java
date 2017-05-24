package com.spring.study.jdbc.dao;

import java.util.List;

import com.spring.study.domain.User;

public interface IUserDao {
	
	public void add(User user, int gid);
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public List<User> list(String sql);

}
