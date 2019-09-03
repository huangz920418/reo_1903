package com.emp.entity;

public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer role_id;
	
	public User() {
		super();	
	}
	public User(Integer id, String username, String password, Integer role_id) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role_id = role_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role_id=" + role_id + "]";
	}
	
	
}
