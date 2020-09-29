package com.virtusa.neuralhack.bc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.neuralhack.bc.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student,String> {

}
