package com.qstudy.qstudy.service.login;

import java.util.Base64;
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
	
	public void updateUser(HashMap<String, Object> requestBody) {
		User user = new User();
		byte[] imageBytes = null;
        String base64Image = requestBody.get("picture").toString(); // "image"는 이미지를 담고 있는 키로 가정

        if (base64Image != null && !base64Image.isEmpty()) {
            String base64ImageWithoutPrefix = base64Image.split(",")[1];
            imageBytes = Base64.getDecoder().decode(base64ImageWithoutPrefix);
        }
		user.setNickname(requestBody.get("nickname").toString());
		user.setPassword(requestBody.get("password").toString());
		user.setEmail(requestBody.get("email").toString());
		user.setPickture(imageBytes);
		
		//  user 데이터베이스에 저장
		//userMapper.registerUser(user);
			
	}
	
}
