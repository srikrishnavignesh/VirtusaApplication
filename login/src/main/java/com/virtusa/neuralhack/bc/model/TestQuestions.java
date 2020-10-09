package com.virtusa.neuralhack.bc.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestQuestions {
	List<TestQuestion> list;
	
	public TestQuestions(@JsonProperty("testQuestions") List<TestQuestion> tq) {
		this.list=tq;
		
	}


	public List<TestQuestion> getList() {
		return list;
	}


	public void setList(List<TestQuestion> list) {
		this.list = list;
	}
	
}
