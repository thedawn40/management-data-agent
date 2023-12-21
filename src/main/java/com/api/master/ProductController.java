package com.api.master;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;


import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.MessageInfo;
import com.common.ResponseHandler;
import com.google.gson.Gson;
import com.model.master.MsProduct;
import com.service.master.MsProductSvc;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	MsProductSvc msProductService;
	
	// @AllowAnonymous
	@GetMapping(value= "/get/list")
    public ResponseEntity<Object> getIndex(@RequestHeader Map<String, String> headers){
		try {
			List<MsProduct> list = msProductService.findAll();
			return ResponseHandler.generateResponse(MessageInfo.i002, HttpStatus.OK, list);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
    }
	
	@PostMapping(value="/post/insert")
    public ResponseEntity<Object> insert(@RequestHeader Map<String, String> headers, @RequestBody Map<String,Object> map){
		log.info("header >>> "+new JSONObject(headers));
		log.info("request >>> "+new JSONObject(map));
		try {			
			@SuppressWarnings("unchecked")
			Map<String,Object> save = (Map<String, Object>) msProductService.save(map);
			log.info(save.get("isExist").toString());

			
		    log.info("response >>> "+new JSONObject(ResponseHandler.generateResponse(MessageInfo.i001, HttpStatus.OK, save)));

			return ResponseHandler.generateResponse(MessageInfo.i001, HttpStatus.OK, save);
			
		}catch(Exception e) {
			log.error("response >>> "+new JSONObject(ResponseHandler.generateResponse(e.getMessage(), HttpStatus.OK, null)));
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
    }
	


}
