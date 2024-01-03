package com.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.GenerateUUID;
import com.dao.UserDao;
import com.dto.UserDto;
import com.model.User;
import com.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User save(UserDto dto) {
        User entity = new User();
        try {
            dto.setId(new GenerateUUID().generateUuid());
            entity = new ModelMapper().map(dto, User.class);
            userDao.save(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public User findOne(String email, String password) {
        List<User> usr = userDao.findByParamEmail(email, password);
        return usr.get(0);
    }
    
}
