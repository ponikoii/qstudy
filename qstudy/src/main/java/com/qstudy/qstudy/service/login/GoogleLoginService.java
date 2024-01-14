package com.qstudy.qstudy.service.login;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qstudy.qstudy.dto.login.User;
import com.qstudy.qstudy.mapper.login.GoogleLoginMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GoogleLoginService {
	
	@Autowired
	private GoogleLoginMapper googleLoginMapper;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	public GoogleLoginService(GoogleLoginMapper googleLoginMapper) {
		this.googleLoginMapper = googleLoginMapper;
	}
	
	public void saveGoogle(HashMap<String, Object> requestBody) {
		// requestBody를 JSON 문자열로 변환
		System.out.println(requestBody);
		System.out.println(requestBody.get("sub"));
		System.out.println(requestBody.get("email"));
		System.out.println(requestBody.get("name"));
		
		// JOSN 문자열에서 email, name 추출
		String id = (String)requestBody.get("sub");
		String email = (String)requestBody.get("email");
		String name = (String)requestBody.get("name");
		
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setNickname(name);
		
		//  user 데이터베이스에 저장
		googleLoginMapper.saveGoogle(user);
			
	}
	

}
