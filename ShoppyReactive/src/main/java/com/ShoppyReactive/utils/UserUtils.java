package com.ShoppyReactive.utils;

import org.springframework.beans.BeanUtils;


import com.ShoppyReactive.dto.UserDto;
import com.ShoppyReactive.entities.User;

public class UserUtils {

	public static UserDto entityToDto(User user)
	{
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}
	
	public static User dtoToEntity(UserDto userDto)
	{
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		return user;
	}
	
}
