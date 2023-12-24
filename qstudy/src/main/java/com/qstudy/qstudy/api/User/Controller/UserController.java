package com.qstudy.qstudy.api.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.api.User.Service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/demo")
	public String getDemo() {
		String demo = userService.getDemo();
		
		return demo;
	}
	
	@PostMapping("/demo")
	public String postDemo() {
		String demo = userService.getDemo();
		
		return demo;
	}
}
