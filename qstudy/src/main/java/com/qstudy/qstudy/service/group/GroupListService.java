package com.qstudy.qstudy.service.group;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void getAllGroupList(HashMap<String, Object> requestBody) {
		String id = requestBody.get("id").toString();
		groupListMapper.getAllGroupList(id);
	}
}
