package com.qstudy.qstudy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.qstudy.qstudy.dto.User;

@Repository
@Mapper
public interface UserMapper {
	List<User> getUsers();
}
