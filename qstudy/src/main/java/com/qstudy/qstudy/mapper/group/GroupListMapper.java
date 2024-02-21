package com.qstudy.qstudy.mapper.group;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.qstudy.qstudy.dto.calendar.Calendar;
import com.qstudy.qstudy.dto.group.GroupAttendList;
import com.qstudy.qstudy.dto.group.GroupList;
import com.qstudy.qstudy.dto.group.GroupMember;

@Mapper
public interface GroupListMapper {
	List<GroupList> getAllGroupList(String id);
	List<GroupAttendList> getAttendGroupList(String id);
	void insertAttendGroup(GroupAttendList ga);
	void insertNewGroup(GroupList gl);
	List<GroupList> getMyGroupList(String id);
	List<GroupMember> getGroupMember(String id);
	void insertNewGroupAttend(GroupList gl);
	void deleteGroupMember(GroupAttendList ga);
	void deleteEvent(Calendar c);
	void deleteGroup(GroupList gl);

}
