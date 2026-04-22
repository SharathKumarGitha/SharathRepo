package com.task.entity.service;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import com.task.dto.UserDto;
public interface UserService {
	
	public UserDto saveUserDto(UserDto dto);

}
