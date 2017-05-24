package com.spring.study.jdbc.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.study.domain.User;
import com.spring.study.jdbc.dao.IUserDao;

@RunWith(SpringJUnit4ClassRunner.class)//让junit运行在spring环境中
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/applicationContext.xml"})//加载配置文件
public class TestUser {
	
	@Resource
	private IUserDao userJdbcDao;
	
	@Test
	public void testAdd(){
		User user = new User(1,"yls",1,"yls","特级管理员");
		userJdbcDao.add(user);
	}
	
	@Test
	public void testUpdate(){
		User user = new User();
		user.setId(4);
		user.setUserName("yls1");
		user.setPassword("yls1");
		userJdbcDao.update(user);
	}
	
	@Test
	public void testDelete(){
		userJdbcDao.delete(5);
	}
	
}