package com.spring.study.jdbc.template;

public class MyJdbcTemplate {

	private void beginConnection() {
		System.out.println("begin connection");
	}

	private void closeConnection() {
		System.out.println("colse connection");
	}

	/**
	 * 模板方法 调用方法,传入一个钩子函数的接口
	 */
	public void execute(MyCallBack call) {
		beginConnection();
		call.doInTemplate();
		closeConnection();
	}

	// 将所有要实现的方法都创建在模板中
	public void add(final int id) {
		execute(new MyCallBack() {

			@Override
			public void doInTemplate() {
				System.out.println("添加了： " + id);

			}
		});
	}

	public void delete(final int id) {
		execute(new MyCallBack() {

			@Override
			public void doInTemplate() {
				System.out.println("删除了：" + id);

			}
		});
	}

}
