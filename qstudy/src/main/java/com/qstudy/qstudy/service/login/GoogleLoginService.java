package com.qstudy.qstudy.service.login;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qstudy.qstudy.dto.login.User;
import com.qstudy.qstudy.mapper.login.GoogleLoginMapper;

@Service
public class GoogleLoginService {
	
	private final GoogleLoginMapper googleLoginMapper;
	private final ObjectMapper objectMapper;
	
	
	public GoogleLoginService(GoogleLoginMapper googleLoginMapper, ObjectMapper objectMapper) {
		this.googleLoginMapper =  googleLoginMapper;
		this.objectMapper = objectMapper;
	}


	public void saveGoogle(Object requestBody) {
		// requestBody를 JSON 문자열로 변환
		String jsonBody = convertToJson(requestBody);
		
		// JOSN 문자열에서 email, name 추출
		String email = extracEmail(jsonBody);
		String name = extracName(jsonBody);
		
		User user = new User();
		user.setEmail(email);
		user.setNickname(name);
		
		//  user 데이터베이스에 저장
		googleLoginMapper.saveGoogle(user);
			
	}
	
	private String convertToJson(Object requestBody) {
		try {
			// Object를 JSON 문자열로 변환
			return objectMapper.writeValueAsString(requestBody);
		} catch(Exception e) {
			throw new RuntimeException("Error converting object to JSON", e);
		}
	}
	
	private String extracEmail(String jsonBody) {
		try {
			// JSON 문자열을 jsonNode로 변환
			JsonNode rootNode = objectMapper.readTree(jsonBody);
			
			// email 필드 추출
			return rootNode.path("email").asText();
		} catch(Exception e) {
			throw new RuntimeException("Eroor extracting email from JSON", e);
		}
	}
	
	private String extracName(String jsonBody) {
		try {
			// JSON 문자열을 jsonNode로 변환
			JsonNode rootNode = objectMapper.readTree(jsonBody);
			
			// name 필드 추출
			return rootNode.path("name").asText();
		}catch(Exception e) {
			throw new RuntimeException("Error extracting name from JSON", e);
		}
	}
	

}
