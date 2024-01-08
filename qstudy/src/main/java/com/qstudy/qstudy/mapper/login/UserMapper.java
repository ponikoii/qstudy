package com.qstudy.qstudy.mapper.login;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.qstudy.qstudy.dto.login.User;

@Repository
@Mapper
public interface UserMapper {
	List<User> getUsers();
}
