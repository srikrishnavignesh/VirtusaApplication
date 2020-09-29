package com.virtusa.neuralhack.bc.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class TestQuestionsFk implements Serializable {

	private long testId;
	
	private long quesId;
	
	public TestQuestionsFk() {
		
	}
	public TestQuestionsFk(long testId, long quesId) {
		super();
		this.testId = testId;
		this.quesId = quesId;
	}

	public long getTestId() {
		return testId;
	}

	public void setTestId(long testId) {
		this.testId = testId;
	}


	public long getQuesId() {
		return quesId;
	}

	
	public void setQuesId(long quesId) {
		this.quesId = quesId;
	}
	

}
