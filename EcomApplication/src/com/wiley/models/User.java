package com.wiley.models;

public class User {

	private String Name,Id;
	private String password;
	
	public User(String Id,String fName, String lName, String password) {
		super();
		this.Id = Id;
		this.Name = fName+lName;
		this.password = password;
	}

	public User(String name, String id, String password) {
		super();
		Name = name;
		Id = id;
		this.password = password;
	}

	public User() {
		this.Id = " ";
		this.password = " ";
		this.Name = " ";
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
