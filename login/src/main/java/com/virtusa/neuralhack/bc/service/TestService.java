package com.virtusa.neuralhack.bc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.TransientPropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.virtusa.neuralhack.bc.dao.TeacherDao;
import com.virtusa.neuralhack.bc.dao.TestDao;

import com.virtusa.neuralhack.bc.dao.TestQuestionDao;
import com.virtusa.neuralhack.bc.dao.dataDAO;
import com.virtusa.neuralhack.bc.model.Data;
import com.virtusa.neuralhack.bc.model.Student;
import com.virtusa.neuralhack.bc.model.Teacher;
import com.virtusa.neuralhack.bc.model.Test;
import com.virtusa.neuralhack.bc.model.TestInfo;

import com.virtusa.neuralhack.bc.model.TestQuestion;
import com.virtusa.neuralhack.bc.model.TestQuestionsOutput;

@Service
public class TestService {

	@Autowired
	private TestDao testAccess;
	
	@Autowired
	private dataDAO marksAccess;
	
	@Autowired
	private TestQuestionDao tqAccess;
	
	public HashMap<String,String> createTest(HashMap<String,Object> req) {
		
	

		String usrName=(String)req.get(TestInfo.USR_NAME);
		String startTime=(String)req.get(TestInfo.START_TIME);
		String endTime=(String)req.get(TestInfo.END_TIME);
		String desc=(String) req.get(TestInfo.DESC);
		HashMap<String,String> res=new HashMap<String,String>();
		
		if(usrName==null || usrName.trim().length()==0 || startTime==null || startTime.length()==0 ||
				endTime==null || endTime.length()==0 ){
			
			res.put(TestInfo.STATUS,TestInfo.INVALID_FIELDS);
			return res;
		}
		
		Test tst=new Test(usrName,startTime,endTime,desc);
		
		try
		{
			testAccess.save(tst);
			res.put(TestInfo.TEST_ID,Long.toString(tst.getId()));			//if everything is fine
			res.put(TestInfo.STATUS, TestInfo.TEST_SUCCESS);
		}
		catch(InvalidDataAccessApiUsageException e)					
		{
																//if user enters a incorrect username (teacher_user_name)
			res.put(TestInfo.STATUS,TestInfo.TEST_ERROR);
			res.put(TestInfo.ERROR,TestInfo.INVALID_USR_NAME);
		}
		catch(Exception e)
		{
			res.put(TestInfo.STATUS, TestInfo.TEST_ERROR);		//some unkown error
			res.put(TestInfo.ERROR,TestInfo.STATUS_UNKNOWN);
		}
	    
	    return res;
		
		
	}
	
	public HashMap<String,String> addTestMarks(HashMap<String,Object> req) {
		
		HashMap<String,String> res=new HashMap<String,String>();
		
		try
		{
			long id=Long.parseLong(req.get(TestInfo.TEST_ID)+"");				//take all input fields
			String uName=(String)req.get(TestInfo.USR_NAME);	
			int marks=(int)req.get(TestInfo.MARKS);
			
			
			if( uName==null && uName.trim().length()==0) 						//validate them for null
			{
				res.put(TestInfo.ERROR, TestInfo.INVALID_FIELDS);
				res.put(TestInfo.STATUS, TestInfo.MARK_ERROR);
				return res;
			
			}
			
			
			Data testm=new Data(uName,id,marks);						//create new update testMarks
			marksAccess.save(testm);
			
			res.put(TestInfo.STATUS, TestInfo.MARKS_SUCCESS);
		
		}
		catch(ObjectRetrievalFailureException e)								//username or test id not found
		{
			res.put(TestInfo.ERROR, TestInfo.ENTITY_NOT_FOUND);
			res.put(TestInfo.STATUS, TestInfo.MARK_ERROR);
		}
		catch(Exception e)
		{
			res.put(TestInfo.ERROR, TestInfo.STATUS_UNKNOWN);					//unknown error
			res.put(TestInfo.STATUS, TestInfo.MARK_ERROR);
		}
		
		return res;
	}
	
	public HashMap<String,String> addTestQuestion(List<TestQuestion> list) {
		
		HashMap<String,String> res=new HashMap<String,String>();
		for(TestQuestion tq :list) {
		
			try
			{
		
				if(tq.getQuestion()==null || tq.getQuestion().length()==0 || tq.getCrctOp()==null || tq.getCrctOp().length()==0)
				{
					res.put(TestInfo.STATUS, TestInfo.QUES_ERROR);
					res.put(TestInfo.ERROR,  TestInfo.INVALID_FIELDS);
					return res;
				}
			
			
			
			
				tqAccess.save(tq);
			
			}
			catch(NumberFormatException e) {
			
			}
			catch(ObjectRetrievalFailureException e)
			{
				res.put(TestInfo.ERROR, TestInfo.INVALID_TABLE_NAME);
				res.put(TestInfo.STATUS, TestInfo.QUES_ERROR);
				return res;
			}
			catch(Exception e ) {
				res.put(TestInfo.ERROR, TestInfo.STATUS_UNKNOWN);					//unknown error
				res.put(TestInfo.STATUS, TestInfo.MARK_ERROR);
				return res;
			}
		}
		res.put(TestInfo.STATUS, TestInfo.QUES_SUCCESS);
		return res;
		
	}
	
	public List<Test> getAllTests() {
		
		return testAccess.findAll();
	
		
	}
	
	

	public List<TestQuestionsOutput> getAllQuestions(long testId) {
	
			List<TestQuestion> testQuestionList=tqAccess.findByTestId(testId);
			if(testQuestionList==null)
				return null;
			List<TestQuestionsOutput> resList=new ArrayList<TestQuestionsOutput>();
			for(TestQuestion t:testQuestionList)
				resList.add(new TestQuestionsOutput(t.getTf().getQuesId(),t.getQuestion(),t.getCrctOp(),t.getQuesOptions()));
				
			return resList;
	}


}
