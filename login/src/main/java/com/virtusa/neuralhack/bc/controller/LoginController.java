package com.virtusa.neuralhack.bc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.neuralhack.bc.model.Teacher;
import com.virtusa.neuralhack.bc.model.User;
import com.virtusa.neuralhack.bc.service.LoginService;

@CrossOrigin
@RestController
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@PostMapping("/user")
	public HashMap<String,String> addUser(@RequestBody HashMap<String,Object> req)
	{
		return service.addUser(req);
	
	}	
	
	@PostMapping("/loginUser")
	public HashMap<String,String> loginUser(@RequestBody HashMap<String,Object> req)
	{
			
		return service.loginUser(req);
		
	}
	

}
