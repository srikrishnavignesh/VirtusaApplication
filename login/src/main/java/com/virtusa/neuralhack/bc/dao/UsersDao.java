package com.virtusa.neuralhack.bc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.neuralhack.bc.model.User;

@Repository
public interface UsersDao extends JpaRepository<User,String> {
	
	List<User> findByUserName(String uname);
	
	@Query(value="select user_name,password,user_type from users u where u.user_name=?1 and u.password=?2",nativeQuery=true)
	User verifyUser(String userName,String password);
	
}
