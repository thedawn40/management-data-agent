package com.service;

import java.util.List;

import com.dto.AgenDto;
import com.model.Agen;

/**
 * AgenService
 */
public interface AgenService {

    List<Agen> findAll();
    List<Agen> findAllWithNoUser();
    int deleteById(String id);
    int save(AgenDto dto);

}