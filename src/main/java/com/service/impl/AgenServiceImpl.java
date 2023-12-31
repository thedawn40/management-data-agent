package com.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AgenDao;
import com.dto.AgenDto;
import com.model.Agen;
import com.service.AgenService;

@Service
@Transactional
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

    @Override
    public int deleteById(String id) {
        return agenDao.deleteAgenById(id);
    }

    @Override
    public int save(AgenDto dto) {
        Agen entity = new Agen();
        entity = new ModelMapper().map(dto, Agen.class);
        agenDao.save(entity);
        return 1;
    }
    
}
