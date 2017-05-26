package com.spring.study.jdbc.template;

public class MessageDao extends MyJdbcTemplateByIn {

	@Override
	public void run() {
		System.out.println("message add");
		
	}

	@Override
	public boolean isLog() {
		// TODO Auto-generated method stub
		return true;
	}

}
