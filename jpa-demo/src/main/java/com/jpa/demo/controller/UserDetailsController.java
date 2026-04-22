package com.jpa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.dto.UserDetResponseDTO;
import com.jpa.demo.entity.UserDetails;
import com.jpa.demo.service.UserDetailsService;

@RestController
@RequestMapping("/user/det")
public class UserDetailsController {

	@Autowired
	private UserDetailsService detailsService;

	@PostMapping("/save")
	@ResponseBody
	public UserDetResponseDTO saveUserDetails(@RequestBody UserDetails details) {
		return detailsService.createUser(details);
	}

	@GetMapping("{id}")
	@ResponseBody
	public UserDetails getUserDetailsById(@PathVariable("id") Long id) {
		return detailsService.getUserById(id);
	}

}
