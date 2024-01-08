package com.qstudy.qstudy.controller.login;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.service.login.UserService;


@RestController
public class UserController {
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "/login/github")
	 public ResponseEntity<?> LoginGithub(){
        HashMap<String, Object> result = new HashMap<>();

        result.put("data", userService.getUsers());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
	@GetMapping(value = "/login/google")
	 public ResponseEntity<?> LoginGoogle(){
       HashMap<String, Object> result = new HashMap<>();

       result.put("data", userService.getUsers());

       return new ResponseEntity<>(result, HttpStatus.OK);
   }
}
