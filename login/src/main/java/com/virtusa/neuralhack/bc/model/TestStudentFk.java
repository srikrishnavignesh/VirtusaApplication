package com.virtusa.neuralhack.bc.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class TestStudentFk implements Serializable {
	
	private long testId;

	private String studentUName;
	
	
	public TestStudentFk(long testId2, String studentUName) {
		super();
		this.testId = testId2;
		this.studentUName = studentUName;
	}


	public long getTestId() {
		return testId;
	}


	public void setTestId(long testId) {
		this.testId = testId;
	}


	public String getStudentUName() {
		return studentUName;
	}


	public void setStudentUName(String studentUName) {
		this.studentUName = studentUName;
	}


	public TestStudentFk() {
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(studentUName, testId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TestStudentFk)) {
			return false;
		}
		TestStudentFk other = (TestStudentFk) obj;
		return Objects.equals(studentUName, other.studentUName) && testId == other.testId;
	}
	

	
}
