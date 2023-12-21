package com.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TxSellDtlDao;
import com.dto.TxSellDtlDto;
import com.model.TxSellDtl;
import com.service.TxSellDtlService;

@Service
public class TxSellDtlServiceImpl implements TxSellDtlService{

	@Autowired
	TxSellDtlDao txSellDtlDao;
	
	@Override
	public List<TxSellDtl> findAll() {
		try {

			return txSellDtlDao.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int save(TxSellDtlDto dto) {
		try {
			TxSellDtl entity = new TxSellDtl();
			ModelMapper modelMapper = new ModelMapper();

			entity = modelMapper.map(dto, TxSellDtl.class);
			
			
			txSellDtlDao.save(entity);
			
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
