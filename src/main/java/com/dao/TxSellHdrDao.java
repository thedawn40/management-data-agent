package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.TxSellHdr;


public interface TxSellHdrDao extends JpaRepository<TxSellHdr, String>{
	
//	@Query(value = "SELECT * FROM tx_sell_hdr u WHERE u.username = :username and u.password = :password", nativeQuery = true)
//	MsUser getUser(String username, String password);

    @Query(value = "select a.* from tx_sell_hdr a where a.sell_date like ?1", nativeQuery = true)
    List<TxSellHdr> listByMonth(String param);

}
