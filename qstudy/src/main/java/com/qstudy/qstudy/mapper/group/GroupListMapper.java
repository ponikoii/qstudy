package com.qstudy.qstudy.mapper.group;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GroupListMapper {
	void getAllGroupList(String id);
}
