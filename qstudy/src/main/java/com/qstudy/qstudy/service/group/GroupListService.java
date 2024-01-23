package com.qstudy.qstudy.service.group;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qstudy.qstudy.dto.group.GroupAttendList;
import com.qstudy.qstudy.dto.group.GroupList;
import com.qstudy.qstudy.dto.login.User;
import com.qstudy.qstudy.mapper.group.GroupListMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class GroupListService {
	@Autowired
	private GroupListMapper groupListMapper;

	public GroupListService(GroupListMapper groupListMapper) {
		this.groupListMapper = groupListMapper;
	}
	
	public List<GroupList> getAllGroupList(String id) {
		return groupListMapper.getAllGroupList(id);
	}
	
	public List<GroupAttendList> getAttendGroupList(String id) {
		return groupListMapper.getAttendGroupList(id);
	}
	public void insertAttendGroup(HashMap<String, Object> requestBody) {
		GroupAttendList ga = new GroupAttendList();
		String group_id = (String)requestBody.get("group_id");
		String user_id = (String)requestBody.get("user_id");
		
		ga.setGroup_id(group_id);
		ga.setUser_id(user_id);
		groupListMapper.insertAttendGroup(ga);
	}
}
