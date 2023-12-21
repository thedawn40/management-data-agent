package com.dao.master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.master.MsProduct;


public interface MsProductDao extends JpaRepository<MsProduct, String>{

	@Query(value = "SELECT * FROM ms_product a WHERE a.product_id = :productId", nativeQuery = true)
	MsProduct findOneById(String productId);
	
}
