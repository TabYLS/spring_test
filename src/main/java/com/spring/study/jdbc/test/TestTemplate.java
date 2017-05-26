package com.spring.study.jdbc.test;

import org.junit.Test;

import com.spring.study.jdbc.template.MessageDao;
import com.spring.study.jdbc.template.MyJdbcTemplateByIn;
import com.spring.study.jdbc.template.RoleDao;

public class TestTemplate {
	
	@Test
	public void test01(){
		MyJdbcTemplateByIn mt = new RoleDao();
		mt.execute();
		
		MyJdbcTemplateByIn message = new MessageDao();
		message.execute();
	}
	
	@Test
	public void test02(){
		RoleDao role = new RoleDao();
		role.add(5);
	}

}
