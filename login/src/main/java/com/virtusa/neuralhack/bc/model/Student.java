package com.virtusa.neuralhack.bc.model;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="student")
public class Student {
	
	@Id
	@Column(name="user_name")
	private String userName;
	
	private String name;
	
	public static final String  COLUMN1="userName";
	public static final String  COLUMN2="name";
	
	public Student() {
		
	}
	
	
	public Student(String userName, String name) {
		super();
		this.userName = userName;
		this.name = name;
	}


	public Student(String usr) {

		this.userName=usr;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public static Student getStudent(HashMap<String,Object> req)
	{
		String userName=(String)req.get(LoginInfo.USER_NAME);
		String name=(String)req.get(LoginInfo.NAME);
		Student st=null;
		
		if(name!=null && userName!=null)
			st=new Student(userName,name);
		
		return st;
	}
}
