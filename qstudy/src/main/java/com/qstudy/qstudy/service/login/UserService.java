package com.qstudy.qstudy.service.login;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qstudy.qstudy.dto.login.User;
import com.qstudy.qstudy.mapper.login.UserMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	@Autowired
	private UserMapper userMapper;
	
	public UserService(UserMapper userMapper) {
		this.userMapper = userMapper;
		
	}
	
	public void registerUser(HashMap<String, Object> requestBody) {
		User user = new User();
		user.setId(requestBody.get("id").toString());
		user.setPassword(requestBody.get("password").toString());
		user.setEmail(requestBody.get("email").toString());
		user.setNickname(requestBody.get("nickname").toString());
		
		//  user 데이터베이스에 저장
		userMapper.registerUser(user);
			
	}
	
	public List<User> getUser(HashMap<String, Object> requestBody){
		User user = new User();
		user.setId(requestBody.get("id").toString());
		user.setPassword(requestBody.get("password").toString());
		
		//  user 데이터베이스에 저장
		return userMapper.login(user);
		
	}
	
}
