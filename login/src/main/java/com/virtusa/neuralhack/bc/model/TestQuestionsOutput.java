package com.virtusa.neuralhack.bc.model;

import java.util.List;

public class TestQuestionsOutput {

	
	long quesId;
	String question;
	String crctOp;
	List<String> quesOptions;
	public TestQuestionsOutput(long quesId, String question, String crctOp, List<String> quesOptions) {
		
		this.quesId=quesId;
		this.question=question;
		this.crctOp=crctOp;
		this.quesOptions=quesOptions;
		quesOptions.add(crctOp);
		
	}
	
	public TestQuestionsOutput() {
		
	}

	public long getQuesId() {
		return quesId;
	}


	public void setQuesId(long quesId) {
		this.quesId = quesId;
	}

	
	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}

	
	public String getCrctOp() {
		return crctOp;
	}

	
	public void setCrctOp(String crctOp) {
		this.crctOp = crctOp;
	}

	
	public List<String> getQuesOptions() {
		return quesOptions;
	}


	public void setQuesOptions(List<String> quesOptions) {
		this.quesOptions = quesOptions;
	}
	
	
}
