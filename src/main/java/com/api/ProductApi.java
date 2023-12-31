package com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.ResponseHandler;
import com.dao.ProductDao;
import com.model.Agen;
import com.model.Product;
import com.service.AgenService;

@RestController
@RequestMapping("/api")
public class ProductApi {

    @Autowired
    ProductDao productDao;

    @GetMapping("/product/get-all")
    public ResponseEntity<Object> findAllWithNoUser(){
        List<Product> list = productDao.findAll();
        System.out.println("test >>>>>>>>> "+list.size());

        return ResponseHandler.generateResponse("success", HttpStatus.OK, list);
    }

}
