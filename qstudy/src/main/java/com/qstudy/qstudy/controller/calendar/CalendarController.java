package com.qstudy.qstudy.controller.calendar;

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

import com.qstudy.qstudy.dto.calendar.Calendar;
import com.qstudy.qstudy.service.calendar.CalendarService;


@RestController
@CrossOrigin
public class CalendarController {
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
//		calendarService.insertEvent(requestBody);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("message", "Success Attend ");
		System.out.println(requestBody);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
}
