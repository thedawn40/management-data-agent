package com.service.master.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.master.MsUserDao;
import com.model.master.MsUser;
import com.service.master.MsUserService;


@Service
public class MsUserServiceImpl implements MsUserService {
	
	@Autowired
	MsUserDao msUserDao;

//	@Override
//	public MsUserDto findOne(String username, String password) {
//		// TODO Auto-generated method stub
//		MsUserDto userDto = new MsUserDto();
//		MsUser user = msUserDao.getUser(username, password);
//		
//		userDto.setUsername(user.getUsername());
//		userDto.setPassword(user.getPassword());
//		
//		return userDto;
//	}

	@Override
	public List<MsUser> findAll() {
		return msUserDao.findAll();
	}

//	@Override
//	public int save(MsUserDto dto) {
//		try {
//			MsUser entity = new MsUser();
//			ModelMapper modelMapper = new ModelMapper();
//
//			entity = modelMapper.map(dto, MsUser.class);
//			
//			
//			msUserDao.save(entity);
//			
//			return 1;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}
//
//	@Override
//	public int delete(MsUserDto dto) {
//		try {
//			MsUser entity = new MsUser();
//			ModelMapper modelMapper = new ModelMapper();
//
//			entity = modelMapper.map(dto, MsUser.class);
//			
//			msUserDao.delete(entity);
//			return 1;
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}

}
