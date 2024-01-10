package com.qstudy.qstudy.controller.login;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.service.login.GithubLoginService;

@RestController
@CrossOrigin
public class GithubLoginController {
	private final GithubLoginService githubLoginService = new GithubLoginService();
	
	@GetMapping(value = "/login/github")
	 public ResponseEntity<?> LoginGithub(){
       HashMap<String, Object> result = new HashMap<>();

       return new ResponseEntity<>(result, HttpStatus.OK);
   }

}
