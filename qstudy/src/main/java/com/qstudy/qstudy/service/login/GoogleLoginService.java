package com.qstudy.qstudy.service.login;

import org.springframework.stereotype.Service;

import com.qstudy.qstudy.mapper.login.GoogleLoginMapper;

@Service
public class GoogleLoginService {
	
	private final GoogleLoginMapper googleLoginMapper;


	public GoogleLoginService(GoogleLoginMapper googleLoginMapper) {
		this.googleLoginMapper =  googleLoginMapper;
	}


	public void saveGoogle(Object requestBody) {
		// TODO Auto-generated method stub
		
		
	}

}
