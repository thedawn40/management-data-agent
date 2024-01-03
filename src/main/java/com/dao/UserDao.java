package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    @Query(value =  "select u.* from user u where u.email like ?1 and u.password like ?2", nativeQuery = true)
    List<User> findByParamEmail(String email, String password);
    
}
