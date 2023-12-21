package com.service;

import java.util.List;

import com.dto.TxSellHdrDto;
import com.model.TxSellHdr;

public interface TxSellHdrService {
	
	abstract List <TxSellHdr> findAll();
	
	int save(TxSellHdrDto dto);

}
