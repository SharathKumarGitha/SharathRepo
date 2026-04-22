package com.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.config.JwtResponse;
import com.task.config.JwtTokenProvider;
import com.task.dto.AuthDTO;
import com.task.dto.UserDto;
import com.task.entity.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@PostMapping("/register")
	@ResponseBody
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto dto) {

		return new ResponseEntity<>(service.saveUserDto(dto), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<JwtResponse> loginUser(@RequestBody AuthDTO dto) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

		System.out.println(authentication);

		String token = jwtTokenProvider.generateToken(authentication);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		return new ResponseEntity<>(new JwtResponse(token), HttpStatus.OK);
	}

}
