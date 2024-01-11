package com.qstudy.qstudy.controller.login;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.service.login.GoogleLoginService;

@RestController
@CrossOrigin
public class GoogleLoginController {
	private final GoogleLoginService googleLoginService;
	
	public GoogleLoginController(GoogleLoginService googleLoginService) {
		this.googleLoginService = googleLoginService;
	}
	
	@PostMapping(value = "/login/google")
	 public ResponseEntity<?> LoginGoogle(@RequestBody Object requestBody){
		googleLoginService.saveGoogle(requestBody);
		
       HashMap<String, Object> result = new HashMap<>();
       result.put("message", "Google Data saved success");
		System.out.println(requestBody);
		

      return new ResponseEntity<>(result, HttpStatus.OK);
  }
}
