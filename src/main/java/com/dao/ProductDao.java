package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
    
}
