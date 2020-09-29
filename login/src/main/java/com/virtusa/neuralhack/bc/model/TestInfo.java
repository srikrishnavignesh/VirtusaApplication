package com.virtusa.neuralhack.bc.model;


//THIS CLASS SEPECIFIES FIELDS USED IN  READING AND WRITING JSON DATA
public class TestInfo {

	//input from front-end for creating a new test
	public static final String USR_NAME="userName";
	public static final String TEST_ID = "testId";
	//dd-MM-yyyy HH:mm
	public static final String START_TIME = "startTime";
	//dd-MM-yyyy HH:mm
	public static final String END_TIME = "startTime";
	public static final String DESC="testDescription";
	public static final String QUES_OPTION ="questionOptions";

	public static final String MARKS = "marks";
	public static final String QUES_ID = "quesId";
	public static final String QUESTION = "question";
	public static final String CRCT_OPTION = "correctOption";

	public static final String ERROR = "error";
	public static final String ENTITY_NOT_FOUND="invalid testid or username";
	public static final String INVALID_FIELDS="please enter proper data";
	public static final String STATUS_UNKNOWN="status unknown";
	public static final String INVALID_USR_NAME = "invalid user name";
	public static final String INVALID_TABLE_NAME = "invalid table name";
	
	public static final String STATUS = "status";
	public static final String TEST_ERROR = "error creating test";
	public static final String MARK_ERROR = "error entering marks";
	public static final String QUES_ERROR="error posting question";

	
	public static final String TEST_SUCCESS = "test created successfully";
	public static final String MARKS_SUCCESS = "entered marks successfully";
	public static final String QUES_SUCCESS = "question posted successfully";
}
