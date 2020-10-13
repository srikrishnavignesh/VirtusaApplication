package com.virtusa.neuralhack.bc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "testmarks")
public class Data {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column
	private String uname;
	
	@Column
	private long testid;
	
	@Column
	private Integer marks;
	
	public Data() {
	
	}
	
	public Data(String uname, long id, Integer marks) {
		
		super();
		this.uname = uname;
		this.testid = id;
		this.marks = marks;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTestid() {
		return testid;
	}
	public void setTestid(long testid) {
		this.testid = testid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getMarks() {
		return marks;
	}
	public void setMarks(Integer marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return "Data [Testid=" + testid + ",Username=" + uname + ", marks="
				+ marks + "]";
	}
}
