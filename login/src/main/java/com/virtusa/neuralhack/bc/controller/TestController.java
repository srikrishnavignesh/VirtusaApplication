package com.virtusa.neuralhack.bc.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.neuralhack.bc.model.Test;
import com.virtusa.neuralhack.bc.model.TestMarks;
import com.virtusa.neuralhack.bc.model.TestQuestion;
import com.virtusa.neuralhack.bc.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService service;
	
	@PostMapping("/test")
	public HashMap<String, String> addTest(@RequestBody HashMap<String,Object> req)
	{
		
		return service.createTest(req);
			
	}
	
	@PostMapping("/testMarks")
	public HashMap<String,String> addTestMarks(@RequestBody HashMap<String,Object> req) {
		
		return service.addTestMarks(req);
		
	}
	
	@PostMapping("/testQuestion")
	public HashMap<String,String> addTestQuestion(@RequestBody TestQuestion tq){
		
		return service.addTestQuestion(tq);
	}
	
}
