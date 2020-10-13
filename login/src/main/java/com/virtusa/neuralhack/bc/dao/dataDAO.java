package com.virtusa.neuralhack.bc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.neuralhack.bc.model.Data;


@Repository
public interface dataDAO extends JpaRepository<Data,Integer>{
  
	@Query(value="select id,testid,uname,marks from testmarks t where t.testid=?1",nativeQuery=true)
	List<Data> findStudentsbyid(Integer id);
	
	@Query(value="select id,testid,uname,marks from testmarks t where t.uname=?1",nativeQuery=true)
	List<Data> findStudentsbyname(String name);
	
	@Query(value="select distinct uname from testmarks",nativeQuery=true)
	List<String> findAllStudents();
}
