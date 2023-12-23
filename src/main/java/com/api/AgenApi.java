package com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.ResponseHandler;
import com.model.Agen;
import com.service.AgenService;

@RestController
@RequestMapping("/api")
public class AgenApi {

    @Autowired
    AgenService agenService;

    @GetMapping("/agen/get-no-user")
    public ResponseEntity<Object> findAllWithNoUser(){
        List<Agen> list = agenService.findAllWithNoUser();

        return ResponseHandler.generateResponse("success", HttpStatus.OK, list);
    }
    
}
