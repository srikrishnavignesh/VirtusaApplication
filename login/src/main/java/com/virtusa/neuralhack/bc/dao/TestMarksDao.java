package com.virtusa.neuralhack.bc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.neuralhack.bc.model.Teacher;
import com.virtusa.neuralhack.bc.model.TestMarks;
import com.virtusa.neuralhack.bc.model.TestStudentFk;

@Repository
public interface TestMarksDao extends JpaRepository<TestMarks,TestStudentFk>  {

}
