package com.virtusa.neuralhack.bc.model;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="testmarks")
public class TestMarks  {

		@EmbeddedId
		private TestStudentFk ts;

		@ManyToOne
		@MapsId("testId")
		@JoinColumn(name="test_id_fk")
		private Test test;
		
		@ManyToOne
		@MapsId("studentUName")
		@JoinColumn(name="student_uname_fk")
		private Student st;
		
		int marks;
		
		
		public TestMarks(long testId, String studentUName, int marks) {
			super();
			
			ts=new TestStudentFk(testId,studentUName);
			
			test=new Test();
			test.setId(testId);
			
			st=new Student();
			st.setUserName(studentUName);
			
			this.marks = marks;
		}


		public TestMarks() {
			
		}

		public int getMarks() {
			return marks;
		}

		public void setMarks(int marks) {
			this.marks = marks;
		}



}
