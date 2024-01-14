package com.qstudy.qstudy.mapper.login;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.qstudy.qstudy.dto.login.User;

@Repository
@Mapper
public interface GoogleLoginMapper {
	void saveGoogle(User user);
}
