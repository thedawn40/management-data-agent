package com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.ResponseHandler;
import com.dto.UserDto;
import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    UserService userService;

    @PostMapping("/user/post-save")
    public ResponseEntity<Object> save(@RequestBody UserDto dto){

        User entity = userService.save(dto);
        return ResponseHandler.generateResponse("success", HttpStatus.OK, entity);
        
    }

    
}
