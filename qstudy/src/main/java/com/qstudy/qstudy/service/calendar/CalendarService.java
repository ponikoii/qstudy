package com.qstudy.qstudy.service.calendar;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qstudy.qstudy.dto.calendar.Calendar;
import com.qstudy.qstudy.dto.group.GroupAttendList;
import com.qstudy.qstudy.dto.group.GroupList;
import com.qstudy.qstudy.mapper.calendar.CalendarMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CalendarService {
	@Autowired
	private CalendarMapper calendarMapper;
	
	public CalendarService(CalendarMapper calendarMapper) {
		this.calendarMapper = calendarMapper;
	}
	
	public List<Calendar> getCalendarMonthInfo(String id) {
		return calendarMapper.getCalendarMonthInfo(id);
	}
	public void insertEvent(HashMap<String, Object> requestBody) {
		Calendar ca = new Calendar();
		String user_id = (String)requestBody.get("user_id");
		String group_id = (String)requestBody.get("group_id");
		String title = (String)requestBody.get("title");
		String start_date = (String)requestBody.get("start_date");
		String end_date = (String)requestBody.get("end_date");
		String memo = (String)requestBody.get("memo");
		
		ca.setUser_id(user_id);
		ca.setGroup_id(group_id);
		ca.setTitle(title);
		ca.setStart_date(start_date);
		ca.setEnd_date(end_date);
		ca.setMemo(memo);
			
		calendarMapper.insertEvent(ca);
	}
	public List<Calendar> getCalendarList(String id){
		return calendarMapper.getCalendarList(id);
	}//
	
	public List<Calendar> getCalendarGroupList(String user_id, String group_id){
		Calendar ca = new Calendar();
		ca.setUser_id(user_id);
		ca.setGroup_id(group_id);
		
		return calendarMapper.getCalendarGroupList(ca);
	}
}
