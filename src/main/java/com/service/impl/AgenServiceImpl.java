package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AgenDao;
import com.model.Agen;
import com.service.AgenService;

@Service
public class AgenServiceImpl implements AgenService{

    @Autowired
    AgenDao agenDao;

    @Override
    public List<Agen> findAll() {
        return agenDao.findAll();
    }

    @Override
    public List<Agen> findAllWithNoUser() {
        return agenDao.listAgentWithNoUser();
    }
    
}
