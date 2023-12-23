package com.service;

import java.util.List;

import com.model.Agen;

/**
 * AgenService
 */
public interface AgenService {

    List<Agen> findAll();
    List<Agen> findAllWithNoUser();

}