package com.virtusa.neuralhack.bc.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.virtusa.neuralhack.bc.model.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.neuralhack.bc.dao.StudentDao;
import com.virtusa.neuralhack.bc.dao.TeacherDao;
import com.virtusa.neuralhack.bc.dao.UsersDao;
import com.virtusa.neuralhack.bc.model.Student;
import com.virtusa.neuralhack.bc.model.Teacher;
import com.virtusa.neuralhack.bc.model.User;
import com.virtusa.neuralhack.bc.model.LoginInfo;

@Service
public class LoginService {
	
	@Autowired
	private UsersDao userAccess;
	
	@Autowired
	private TeacherDao teacherAccess;
	
	@Autowired
	private StudentDao studentAccess;
	
	public HashMap<String,String> addUser(HashMap<String,Object> req)
	{
		HashMap<String,String> res=new HashMap<String,String>();
		String userName=(String)req.get(LoginInfo.USER_NAME);
		String password=(String)req.get(LoginInfo.PASSWORD);
		String userType=(String)req.get(LoginInfo.USER_TYPE);
		User usr=null;
		if(userName==null || password==null && userType==null)
		{
			res.put(LoginInfo.STATUS,LoginInfo.INVALID_CREDENTIALS);
			return res;
		}	
		
		usr=new User(userName,password,userType);	
		
		if(usr!=null && userAccess.findByUserName(usr.getUserName()).size()==0)  //check for duplicate userName
		{
			usr.setUserType(usr.getUserType().toUpperCase());            
			
			userAccess.save(usr);
			
			if(usr.getUserType().equals(LoginInfo.TYPE1)) 					//if given user is a student
			{
				Student s=Student.getStudent(req);						//build Student
				studentAccess.save(s);
			}
			else if(usr.getUserType().equals(LoginInfo.TYPE2)) 				//if given user is a teacher
			{
				Teacher t=Teacher.getTeacher(req);						//build Teacher
				teacherAccess.save(t);
			}
			else
			{
														//unknown type specified
			}
			res.put(LoginInfo.USER_NAME, usr.getUserName());
			res.put(LoginInfo.USER_TYPE, usr.getUserType());
			res.put(LoginInfo.STATUS, LoginInfo.SUCCESSFUL_REGIS);
		}
		else
		{
			res.put(LoginInfo.STATUS, LoginInfo.USER_EXISTS);
		}
		return res;
	}
	public HashMap<String,String> loginUser(HashMap<String,Object> req)
	{
		
		HashMap<String,String> res=new HashMap<String,String>();
	
		String userName=(String)req.get("userName");
		String pass=(String)req.get("password");
		
		if(userName==null || userName.length()==0 ||pass==null || pass.length()==0)
		{
			res.put("status", LoginInfo.INVALID_CREDENTIALS);
			return res;
		}
		
		User usr=userAccess.verifyUser(userName, pass);           //login using userName and password
		if(usr==null)
		{
			res.put(LoginInfo.STATUS,LoginInfo.INCORRECT_PASS_USR);
		}
		else
		{
			res.put(LoginInfo.STATUS,LoginInfo.LOGIN_SUCCESS);
			res.put(LoginInfo.USER_NAME, usr.getUserName());
			res.put(LoginInfo.USER_TYPE, usr.getUserType());
			
		}	
		return res;
	}
}
