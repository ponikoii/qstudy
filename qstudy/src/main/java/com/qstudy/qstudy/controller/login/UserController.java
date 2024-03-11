package com.qstudy.qstudy.controller.login;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.service.login.UserService;
import com.qstudy.qstudy.dto.login.User;

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
	// 로그인
	@PostMapping(value = "/login")
	public ResponseEntity<?> Login(@RequestBody HashMap<String, Object> requestBody){
		
		List<User> result = userService.getUser(requestBody);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	
	}
	
	@PostMapping(value = "/update")
	public ResponseEntity<?> Update(@RequestBody HashMap<String, Object> requestBody){
		userService.updateUser(requestBody);
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "Google Data saved success");
        System.out.println(requestBody);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	
	}
	
}
