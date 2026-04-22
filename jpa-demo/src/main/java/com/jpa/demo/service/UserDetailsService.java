package com.jpa.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.dto.UserDetResponse;
import com.jpa.demo.dto.UserDetResponseDTO;
import com.jpa.demo.entity.Role;
import com.jpa.demo.entity.UserDetails;
import com.jpa.demo.repository.RoleRepository;
import com.jpa.demo.repository.UserDetailsRepo;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Data
public class UserDetailsService {

	private final UserDetailsRepo userRepo;
	private final RoleRepository roleRepo;
	
	@Autowired
	private UserDetResponse response;

	// ✅ CREATE USER WITH ROLES
	public UserDetResponseDTO createUser(UserDetails userDetails) {

		List<Role> roles = new ArrayList<>();

		for (Role role : userDetails.getRoles()) {

			// fetch role from DB
			Role existingRole = roleRepo.findById(role.getId())
					.orElseThrow(() -> new RuntimeException("Role not found"));

			// 🔥 maintain both sides
			existingRole.getUsers().add(userDetails);

			roles.add(existingRole);
		}

		userDetails.setRoles(roles);

		UserDetails saved_user_det= userRepo.save(userDetails);
		
		return response.mapToDTO(saved_user_det);
		
		
	}
	
	
	public UserDetails getUserById(Long id)
	{
		return userRepo.findById(id).get();
	}
}