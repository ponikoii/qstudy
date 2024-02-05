package com.qstudy.qstudy.controller.login;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.service.login.UserService;

@RestController
@CrossOrigin
public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	// 회원가입 데이터 저장
	@PostMapping(value = "/signup")
	 public ResponseEntity<?> SignUp(@RequestBody HashMap<String, Object> requestBody){
		userService.registerUser(requestBody);
		
      HashMap<String, Object> result = new HashMap<>();
      result.put("message", "Google Data saved success");
      System.out.println(requestBody);
		
     return new ResponseEntity<>(result, HttpStatus.OK);
 }

}
