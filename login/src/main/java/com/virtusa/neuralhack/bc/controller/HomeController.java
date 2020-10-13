package com.virtusa.neuralhack.bc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.neuralhack.bc.dao.dataDAO;
import com.virtusa.neuralhack.bc.model.Data;
import com.virtusa.neuralhack.bc.service.viewService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
public class HomeController {
	
	Integer id;
	String name;
	@Autowired
	dataDAO dataDAO;
	
  	@Autowired
	viewService service;
	
	@RequestMapping("/teacher")
	public String showHome() {
		
		return "home";
	}
	
	
	@RequestMapping("/student")
	public String studshowHome() {
		return "student";
	}
	
	@RequestMapping("/index")
	public String index(Data data) {
		id = (int) data.getTestid();
		return "index";
	}
	
	@RequestMapping("/listStudents")
	@GetMapping
	public ModelAndView list() {

		List<String> list =  service.getAllStudents();
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("view");
		mv.addObject("name",list);
		return mv;
	}
	
	
	@RequestMapping("/linechartdata")
	@ResponseBody
	public String getDataFromDB(){
		
		List<Data> dataList = service.getStudentsbyid(id);
		JsonArray jsonArrayUname = new JsonArray();
		JsonArray jsonArrayMarks = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		dataList.forEach(data->{
			jsonArrayUname.add(data.getUname());
			jsonArrayMarks.add(data.getMarks());
		});
		jsonObject.add("uname", jsonArrayUname);
		jsonObject.add("marks", jsonArrayMarks);
		return jsonObject.toString();
	}
	
	@RequestMapping("/individualreport")
	public String report(String uname) {
	
		name= uname;
		return "individual";
	}
	
	
	@RequestMapping("/individualstuddata")
	@ResponseBody
	public String getData(){
		
		List<Data> dataList = service.getStudentsbyname(name);
		JsonArray jsonArrayTestid = new JsonArray();
		JsonArray jsonArrayMarks = new JsonArray();
		JsonObject jsonObject = new JsonObject();
		dataList.forEach(data->{
			jsonArrayTestid.add(data.getTestid());
			jsonArrayMarks.add(data.getMarks());
		});
		jsonObject.add("testid", jsonArrayTestid);
		jsonObject.add("marks", jsonArrayMarks);
		return jsonObject.toString();
	}
	
	
}
