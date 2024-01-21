package com.qstudy.qstudy.controller.group;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.service.group.GroupListService;
import com.qstudy.qstudy.service.login.GoogleLoginService;

@RestController
@CrossOrigin
public class GroupListController {
	private GroupListService groupListService;
	
	public GroupListController(GroupListService groupListService) {
		this.groupListService = groupListService;
	}
	
	@PostMapping(value = "/group/all")
	 public ResponseEntity<?> LoginGoogle(@RequestBody HashMap<String, Object> requestBody){
		groupListService.getAllGroupList(requestBody);
		
       HashMap<String, Object> result = new HashMap<>();
       result.put("message", "Google Data saved success");
       System.out.println(requestBody);
		

      return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
