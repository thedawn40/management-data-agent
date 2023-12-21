package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.TxSellDtl;


public interface TxSellDtlDao extends JpaRepository<TxSellDtl, String>{
	
//	@Query(value = "SELECT * FROM tx_sell_hdr u WHERE u.username = :username and u.password = :password", nativeQuery = true)
//	MsUser getUser(String username, String password);

}
