package com.virtusa.neuralhack.bc.model;

import java.util.HashMap;

import javax.persistence.*;

@Entity
@Table(name="teacher")
public class Teacher {	
	
	@Id
	private String userName;
	
	private String name;	
	public Teacher(String name, String userName) {
		super();
		this.name = name;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Teacher()
	{
		
	}
	
	public Teacher(String userName) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static Teacher getTeacher(HashMap<String,Object> req)
	{
		String userName=(String)req.get(LoginInfo.USER_NAME);
		String name=(String)req.get(LoginInfo.NAME);
		Teacher t=null;
		if(name!=null && userName!=null)
			t=new Teacher(name,userName);
		return t;
	}
	
}
