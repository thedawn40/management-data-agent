package com.dao.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.master.MsUser;


public interface MsUserDao extends JpaRepository<MsUser, String>{
	
	@Query(value = "SELECT * FROM ms_user u WHERE u.username = :username and u.password = :password", nativeQuery = true)
	MsUser getUser(String username, String password);

}
