package com.spring.study.jdbc.template;

/**
 * 对于模板设计方式而言，一般有两种方式：
	第一种：基于继承的实现
 * @author YLS
 *
 */
public abstract class MyJdbcTemplateByIn {
	
	private void beginConnection(){
		System.out.println("begin connection");
	}
	
	private void closeConnection(){
		System.out.println("colse connection");
	}
	
	public abstract void run();//抽象方法，具体操作延迟到子类进行实现
	
	/**
	 * 在模板方法中有一种函数叫做钩子函数，钩子函数作用是控制模板中的流程
	 * @return
	 */
	public abstract boolean isLog();
	
	public void execute(){
		if(isLog())
			System.out.println("加入了日志");
		beginConnection();
		run();
		closeConnection();
	}
	

}
