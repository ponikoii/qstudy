package com.qstudy.qstudy.dto.group;

import java.sql.Timestamp;

public class GroupAttendList {
	private String group_id;
	private String user_id;
	private Timestamp enter_time;
	private String color;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Timestamp getEnter_time() {
		return enter_time;
	}
	public void setEnter_time(Timestamp enter_time) {
		this.enter_time = enter_time;
	}
	
	
}
