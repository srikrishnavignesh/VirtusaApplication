package com.virtusa.neuralhack.bc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.neuralhack.bc.model.TestQuestion;
import com.virtusa.neuralhack.bc.model.TestQuestionsFk;

@Repository
public interface TestQuestionDao extends JpaRepository<TestQuestion,TestQuestionsFk> {

	List<TestQuestion> findByTestId(long testId);
}
