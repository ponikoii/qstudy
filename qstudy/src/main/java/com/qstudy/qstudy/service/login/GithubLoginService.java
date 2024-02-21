package com.qstudy.qstudy.service.login;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qstudy.qstudy.dto.login.User;
import com.qstudy.qstudy.mapper.login.GithubLoginMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GithubLoginService {
	@Autowired
	private GithubLoginMapper githubLoginMapper;
	
	public GithubLoginService(GithubLoginMapper githubLoginMapper) {
		this.githubLoginMapper = githubLoginMapper;
	}
	
	public void saveGithub(HashMap<String, Object> requestBody) {
		User user = new User();
		user.setId(requestBody.get("id").toString());
		user.setEmail((String)requestBody.get("login"));
		user.setNickname((String)requestBody.get("login"));
		user.setPicture(requestBody.get("avatar_url").toString().getBytes());
		
		githubLoginMapper.saveGithub(user);
	}
}
