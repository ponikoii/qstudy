package com.qstudy.qstudy.service;
import java.util.List;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qstudy.qstudy.dto.User;
import com.qstudy.qstudy.mapper.UserMapper;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public List<User> getUsers() {
		return userMapper.getUsers();
	}
}
