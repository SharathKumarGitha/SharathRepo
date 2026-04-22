package com.task.entity.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.dto.UserDto;
import com.task.entity.Users;
import com.task.entity.repo.UserRepo;
import com.task.entity.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserRepo repo;
	
	
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserDto saveUserDto(UserDto dto) {

		Users users = mapper.map(dto, Users.class);
		
		 users.setPassword(encoder.encode(users.getPassword()));

		Users saveduser = repo.save(users);

		return mapper.map(saveduser, UserDto.class);
	}

}
