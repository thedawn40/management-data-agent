package com.api;

import org.springframework.web.bind.annotation.RestController;

import com.dto.TxSellHdrDto;
import com.service.TxSellHdrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class PenjualanApi {

    @Autowired
    TxSellHdrService txSellHdrSvc;

    @PostMapping(value= "/penjualan2")
    public String getDataInsert(@RequestBody TxSellHdrDto map){
		try {
			
			System.out.println("++++++++++++");
			System.out.println(map.getCustomerName());
			System.out.println(map.getListDetail().get(0).getProductId());
			System.out.println("++++++++++++");
			txSellHdrSvc.save(map);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
       return "penjualan";
   }
}
