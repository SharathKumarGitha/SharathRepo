package com.jpa.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.entity.User;
import com.jpa.demo.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;

	public List<User> findAllUsers() {
		return repo.findAll();
	}

}
