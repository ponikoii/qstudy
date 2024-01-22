package com.qstudy.qstudy.controller.group;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.dto.group.GroupList;
import com.qstudy.qstudy.service.group.GroupListService;

@RestController
@CrossOrigin
public class GroupListController {
	private GroupListService groupListService;
	
	public GroupListController(GroupListService groupListService) {
		this.groupListService = groupListService;
	}
	
	@GetMapping(value = "/group/all")
	 public ResponseEntity<?> GroupAllList(){
		
       List<GroupList> result = groupListService.getAllGroupList();
       System.out.println("[Result]");
       System.out.println(result);

      return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
