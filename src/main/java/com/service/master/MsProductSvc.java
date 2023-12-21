package com.service.master;

import java.util.List;
import java.util.Map;

import com.model.master.MsProduct;


public interface MsProductSvc {
	
	List<MsProduct> findAll();
	
	Object findOneById(String id);
	
	Object save(Map<String, Object> map);
	
}
