package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.model.Agen;

public interface AgenDao extends JpaRepository<Agen, String>{
    
    @Query(value = "select a.* from agen a where a.email not in (select u.email from user u)", nativeQuery=true)
    List<Agen> listAgentWithNoUser();

    @Modifying
    @Query(value = "delete from agen a where a.id = ?1", nativeQuery=true)
    int deleteAgenById(String id);

}
