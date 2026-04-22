package com.jpa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.entity.Role;
import com.jpa.demo.service.RoleService;

@RestController
@RequestMapping("/jpa/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("/getRoles")
	@ResponseBody
	public List<Role> getAllRolesWithList() {
		return roleService.getCompleteRoles();
	}

}
