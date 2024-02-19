package com.qstudy.qstudy.mapper.login;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.qstudy.qstudy.dto.login.User;

@Mapper
public interface UserMapper {
	void registerUser(User user);
	List<User> login(User user);
	void updateUser(User user);

}
