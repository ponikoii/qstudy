package com.qstudy.qstudy.mapper.calendar;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qstudy.qstudy.dto.calendar.Calendar;

@Mapper
public interface CalendarMapper {
	List<Calendar> getCalendarMonthInfo(String month);
}
