package com.qstudy.qstudy.controller.calendar;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qstudy.qstudy.dto.calendar.Calendar;
import com.qstudy.qstudy.dto.group.GroupList;
import com.qstudy.qstudy.service.calendar.CalendarService;


@RestController
@CrossOrigin
public class CalendarController {
	//테스트 커밋2
	private CalendarService calendarService;
	
	public CalendarController(CalendarService calendarService) {
		this.calendarService = calendarService;
	}
	
	@GetMapping(value = "/calendar")
	 public ResponseEntity<?> GroupAllList(@RequestParam(value="month") String month){
		
      List<Calendar> result = calendarService.getCalendarMonthInfo(month);
      System.out.println("[Result]");
      System.out.println(result);

     return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@PostMapping(value = "/calendar/event")
	 public ResponseEntity<?> EventAdd(@RequestBody HashMap<String, Object> requestBody){
		calendarService.insertEvent(requestBody);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("message", "Success Attend ");
		System.out.println(requestBody);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/calendar/my")
	 public ResponseEntity<?> MyEventList(@RequestParam(value="id") String id){
	  //원래 이러면 안되지만,, 임시적 허용
	 
      List<Calendar> result = calendarService.getCalendarList(id);
      System.out.println("[Event List]");

     return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping(value = "/calendar/my/group")
	 public ResponseEntity<?> getCalendarGroupList(@RequestParam(value="user_id") String user_id, @RequestParam(value="group_id") String group_id){
	  //원래 이러면 안되지만,, 임시적 허용
	 
     List<Calendar> result = calendarService.getCalendarGroupList(user_id, group_id);
     System.out.println("[Event List]");

    return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/calendar/group")
	 public ResponseEntity<?> deleteCalendarList(@RequestParam(value="id") String id){
		  //원래 이러면 안되지만,, 임시적 허용
		 
	    calendarService.deleteCalendarList(id);
	    HashMap<String, Object> result = new HashMap<>();
		result.put("message", "Success Delete ");

		return new ResponseEntity<>(result, HttpStatus.OK);
		}
	
}
