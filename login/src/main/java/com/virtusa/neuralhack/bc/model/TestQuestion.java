package com.virtusa.neuralhack.bc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class TestQuestion {
	
	@EmbeddedId
	private TestQuestionsFk tf;
	
	@MapsId("testId")
	@ManyToOne
	@JoinColumn(name="test_id_fk")
	private Test test;
	
	private String crctOp;
	
	private String question;

	@ElementCollection()
	@CollectionTable(name="quesOptions",joinColumns= {@JoinColumn(name = "ques_id"),@JoinColumn(name = "test_id")})
	@Column(name="options")
	List<String> quesOptions;
	
	public TestQuestion() {
		
	}
	
	
	public TestQuestion(@JsonProperty(TestInfo.TEST_ID)	long testid,@JsonProperty(TestInfo.QUES_ID) long quesId,
			@JsonProperty(TestInfo.QUESTION) String question,@JsonProperty(TestInfo.CRCT_OPTION) String crctOp,
			@JsonProperty(TestInfo.QUES_OPTION) List<String> quesOptions) {
		
		tf=new TestQuestionsFk(testid,quesId);
		test=new Test();
		test.setId(testid);
		
		this.question=question;
		this.crctOp=crctOp;
		
		this.quesOptions=quesOptions;
		
		
	}


	public TestQuestionsFk getTf() {
		return tf;
	}

	
	public void setTf(TestQuestionsFk tf) {
		this.tf = tf;
	}

	
	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	
	public String getCrctOp() {
		return crctOp;
	}

	
	public void setCrctOp(String crctOp) {
		this.crctOp = crctOp;
	}

	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	
	public List<String> getQuesOptions() {
		return quesOptions;
	}


	
	public void setQuesOptions(List<String> quesOptions) {
		this.quesOptions = quesOptions;
	}
	
	
	
}
