package com.spring.study.jdbc.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.study.domain.Group;
import com.spring.study.domain.User;
import com.spring.study.jdbc.dao.IGroupDao;
import com.spring.study.jdbc.dao.IUserDao;

@RunWith(SpringJUnit4ClassRunner.class)
// 让junit运行在spring环境中
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/applicationContext.xml" })
// 加载配置文件
public class TestUser {

	@Resource(name = "userJdbcDao")
	private IUserDao userJdbcDao;

	@Resource(name = "groupJdbcDao")
	private IGroupDao groupDao;

	@Test
	public void testAdd() {
		Group group = new Group();
		group.setName("执法者");

		groupDao.add(group);
		/*
		 * User user = new User(1,"yls",1,"yls","特级管理员"); userJdbcDao.add(user);
		 */
		User user = new User("悟空", 1, "123456", "特技员");
		userJdbcDao.add(user, group.getId());
	}

	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(4);
		user.setUserName("yls1");
		user.setPassword("yls1");
		userJdbcDao.update(user);
	}

	@Test
	public void testDelete() {
		userJdbcDao.delete(5);
	}

	@Test
	public void testLoad() {
		User user = userJdbcDao.load(10);
		System.out.println(user.getUserName() + ":" + user.getDescn() + "-"
				+ user.getGroup().getName());
	}

	@Test
	public void testList() {
		List<User> users = userJdbcDao
				.list("SELECT u.id userid, u.username, u.password, u.status, u.descn, g.id gid, g.name gname FROM jdbcuser u LEFT JOIN jdbcgroup g ON g.id = u.gid",
						null);
		for (User user : users) {
			/*System.out.println(user.getUserName() + ":" + user.getDescn() + "-"
					+ user.getGroup().getName());*/
			System.out.println(user);
		}
	}

}