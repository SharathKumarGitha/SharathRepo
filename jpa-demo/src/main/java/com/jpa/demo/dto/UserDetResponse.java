package com.jpa.demo.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jpa.demo.entity.UserDetails;

@Component
public class UserDetResponse {
	
	public UserDetResponseDTO mapToDTO(UserDetails user) {

		UserDetResponseDTO dto = new UserDetResponseDTO();
	    dto.setId(user.getId());
	    dto.setName(user.getName());
	    dto.setEmail(user.getEmail());

	    List<RoleDTO> roles = user.getRoles().stream().map(role -> {
	        RoleDTO r = new RoleDTO();
	        r.setId(role.getId());
	        r.setRoleName(role.getRoleName());
	        return r;
	    }).toList();

	    dto.setRoles(roles);

	    return dto;
	}
}
