package com.service;

import java.util.List;

import com.dto.TxSellDtlDto;
import com.model.TxSellDtl;

public interface TxSellDtlService {
	
	abstract List <TxSellDtl> findAll();
	
	int save(TxSellDtlDto dto);

}
