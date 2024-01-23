package com.qstudy.qstudy.mapper.group;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qstudy.qstudy.dto.group.GroupAttendList;
import com.qstudy.qstudy.dto.group.GroupList;

@Mapper
public interface GroupListMapper {
	List<GroupList> getAllGroupList(String id);
	List<GroupAttendList> getAttendGroupList(String id);
	void insertAttendGroup(GroupAttendList ga);
}
