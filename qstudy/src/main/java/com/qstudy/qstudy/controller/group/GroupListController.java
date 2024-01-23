package com.qstudy.qstudy.controller.group;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.dto.group.GroupAttendList;
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
	 public ResponseEntity<?> GroupAllList(@RequestParam(value="id") String id){
		
       List<GroupList> result = groupListService.getAllGroupList(id);
       System.out.println("[Result]");
       System.out.println(result);

      return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/group/my")
	 public ResponseEntity<?> GroupMyList(@RequestParam(value="id") String id){
	  //원래 이러면 안되지만,, 임시적 허용
      List<GroupAttendList> result = groupListService.getAttendGroupList(id);
      System.out.println("[Result]");
      System.out.println(result);

     return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = "/group/attend")
	 public ResponseEntity<?> GroupAttend(@RequestBody HashMap<String, Object> requestBody){
		groupListService.insertAttendGroup(requestBody);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("message", "Success Attend ");
		System.out.println(requestBody);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
