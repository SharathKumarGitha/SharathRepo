package com.jpa.demo.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDetResponseDTO {

	private Long id;
	private String name;
	private String email;
	private List<RoleDTO> roles;

}
