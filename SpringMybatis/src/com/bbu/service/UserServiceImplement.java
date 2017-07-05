package com.bbu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbu.mapper.UserMapper;
import com.bbu.model.User;

@Service("userService")
public class UserServiceImplement implements UserService{

	//×Ô¶¯×¢ÈëUserMapper
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User login(String loginname, String password) {
		// TODO Auto-generated method stub
		System.out.println("===============================");
		return userMapper.findWithLoginnameAndPassword(loginname, password);
	}

	
}
