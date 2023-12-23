package com.service;

import java.util.List;

import com.dto.UserDto;
import com.model.User;

public interface UserService {

    List<User> findAll();

    User save(UserDto dto);

    
}
