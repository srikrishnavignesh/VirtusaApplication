package com.virtusa.neuralhack.bc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.neuralhack.bc.model.Data;
import com.virtusa.neuralhack.bc.dao.dataDAO;

@Service
public class viewService{

	@Autowired 
	private dataDAO dao; 
	
	public List<Data> getStudentsbyid(Integer id) {
		List<Data> list = dao.findStudentsbyid(id);
		return list;
	}
	
	public List<Data> getStudentsbyname(String name) {
		List<Data> list = dao.findStudentsbyname(name);
		return list;
	}
	
	public List<String> getAllStudents() {
		return dao.findAllStudents();
	}
}
