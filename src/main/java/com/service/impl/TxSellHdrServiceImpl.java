package com.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TxSellDtlDao;
import com.dao.TxSellHdrDao;
import com.dto.TxSellHdrDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.model.TxSellDtl;
import com.model.TxSellHdr;
import com.service.TxSellHdrService;

@Service
public class TxSellHdrServiceImpl implements TxSellHdrService{

	@Autowired
	TxSellHdrDao txSellHdrDao;

	@Autowired
	TxSellDtlDao txSellDtlDao;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public List<TxSellHdr> findAll() {
		try {

			return txSellHdrDao.findAll();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int save(TxSellHdrDto dto) {
		try {
			TxSellHdr entity = new TxSellHdr();
			ModelMapper modelMapper = new ModelMapper();

			UUID randomUUID = UUID.randomUUID();
			dto.setSellNo("S-"+randomUUID);
			dto.setSellDate(sdf.format(new Date()));
			entity = modelMapper.map(dto, TxSellHdr.class);
			
	        
			
			if(dto.getListDetail().size()>0) {
				for(int i = 0 ; i < dto.getListDetail().size(); i++) {
					UUID randomUUIDDetail = UUID.randomUUID();
					TxSellDtl entityDetail = new TxSellDtl();

					entityDetail = modelMapper.map(dto.getListDetail().get(i), TxSellDtl.class);
					entityDetail.setSellNoDtl("SD-"+randomUUIDDetail);
					entityDetail.setSellNo(dto.getSellNo());

					txSellDtlDao.save(entityDetail);
				}
			}
			
			txSellHdrDao.save(entity);
			
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
