package com.springSecurityExample;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class UserController {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider jwtTokenProvider;

	@PostMapping("/register")
	public String register(@RequestBody RegisterRequest request) {

		System.out.println("request is....." + request);

		System.out.println("inside usercontroller ::register method....");

		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));

		Set<Role> roles = request.getRoles().stream().map(roleName -> roleRepository.findByName(roleName)
				.orElseThrow(() -> new RuntimeException("Role not found"))).collect(Collectors.toSet());

		user.setRoles(roles);

		System.out.println("roles is...." + roles);
		userRepository.save(user);

		return "User Registered Successfully";
	}

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> loginUser(@RequestBody UserDto dto) {

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

		String token = jwtTokenProvider.generateToken(authentication);

		AuthResponse authResponse = new AuthResponse(token);

		return ResponseEntity.ok(new AuthResponse(token));
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello()
	{
		return "this is sharath";
	}

}