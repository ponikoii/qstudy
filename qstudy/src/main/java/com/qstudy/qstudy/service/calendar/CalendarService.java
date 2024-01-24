package com.qstudy.qstudy.service.calendar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qstudy.qstudy.dto.calendar.Calendar;
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
}
