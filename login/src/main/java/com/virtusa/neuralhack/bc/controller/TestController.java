package com.virtusa.neuralhack.bc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.neuralhack.bc.model.Test;
import com.virtusa.neuralhack.bc.model.TestMarks;
import com.virtusa.neuralhack.bc.model.TestQuestion;
import com.virtusa.neuralhack.bc.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	TestService service;
	
	@PostMapping("/test/newTest")
	public HashMap<String, String> addTest(@RequestBody HashMap<String,Object> req)
	{
		
		return service.createTest(req);
			
	}
	
	@PostMapping("/test/mark")
	public HashMap<String,String> addTestMarks(@RequestBody HashMap<String,Object> req) {
		
		return service.addTestMarks(req);
		
	}
	
	@PostMapping("/test/question")
	public HashMap<String,String> addTestQuestion(@RequestBody TestQuestion tq){
		
		return service.addTestQuestion(tq);
	}
	
	@GetMapping("/test")
	public List<Test> getTest()
	{
		return service.getAllTests();
	}
	
	
}
