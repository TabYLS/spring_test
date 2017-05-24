package com.spring.study.domain;

public class User {

	private int id;
	private String userName;
	/*状态：该用户是否被删除*/
	private int status;
	private String password;
	/* 描述 */
	private String descn;
	/*分组*/
	private Group group;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String userName, int status, String password,
			String descn) {
		super();
		this.id = id;
		this.userName = userName;
		this.status = status;
		this.password = password;
		this.descn = descn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
