package com.spring.study.jdbc.template;

public class RoleDao extends MyJdbcTemplateByIn {

	//基于继承的方式
	@Override
	public void run() {
		
		System.out.println("role add");
	}

	@Override
	public boolean isLog() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	//组合方式
	private MyJdbcTemplate mt = new MyJdbcTemplate();
	
	public void add(int id){
		mt.add(id);
	}
	
	public void delete(int id){
		mt.delete(id);
	}

}
