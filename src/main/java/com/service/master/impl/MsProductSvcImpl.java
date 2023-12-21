package com.service.master.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.master.ProductController;
import com.common.GenerateUUID;
import com.dao.master.MsProductDao;
import com.model.master.MsProduct;
import com.service.master.MsProductSvc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class MsProductSvcImpl implements MsProductSvc {
	
	@Autowired
	MsProductDao msProductDao;

	@Override
	@SneakyThrows
	public List<MsProduct> findAll() {
		List<MsProduct> list = new ArrayList<>();
		list = msProductDao.findAll();
		return list;
	}

	@Override
	public Object save(Map<String, Object> map) {
		try {
			boolean isExist = true;
			MsProduct entity = new MsProduct();
			entity = new ModelMapper().map(map, MsProduct.class);
			if(entity.getProductId().isEmpty()) {
				entity.setProductId(new GenerateUUID().generateUuid("MP-"));
			}else {
				MsProduct p = (MsProduct) findOneById(entity.getProductId());
				if(p.getProductId()==null) {
					isExist = false;
				}
			}		
			msProductDao.save(entity);
			
			Map<String, Object> mapResponse = new HashMap<>();
			mapResponse.put("entity", entity);
			mapResponse.put("isExist", isExist);
			
			return mapResponse;
			
		} catch (Exception e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public Object findOneById(String id) {
		MsProduct msProduct = msProductDao.findOneById(id);
		return msProduct;
	}

}
