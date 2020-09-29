package com.virtusa.neuralhack.bc.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name="test")
public class Test {

		@Id
		@GeneratedValue
		@Column(name="test_id")
		private long id;
		
		@ManyToOne
		@JoinColumn(name="teacher_user_fk")
		private Teacher teacher;
		
		private String testDesc;
		
		private Date startTime;
		
		private Date endTime;
		
		
		
		public Test() {
			
		}
		public Test(String usrName,String startTime,String endTime,String testDesc) {
			
			try {
					this.startTime=new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(startTime);
					this.endTime=new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(endTime);
				} 
				catch (ParseException e) 
				{
					e.printStackTrace();
				}
				this.teacher=new Teacher();
				teacher.setUserName(usrName);
				this.testDesc=testDesc;
				
		}


		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
		
	
		public String getTestDesc() {
			return testDesc;
		}
		
		public void setTestDesc(String testDesc) {
			this.testDesc = testDesc;
		}
		
		public Date getStartTime() {
			return startTime;
		}
		
		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
		
		public Date getEndTime() {
			return endTime;
		}
		
		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
		public Teacher getTeacher() {
			return teacher;
		}


		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
		}
		
}
