package com.springSecurityExample;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));

		List<SimpleGrantedAuthority> authorities = user.getRoles().stream().map(role -> {
			String roleName = role.getName();
			if (!roleName.startsWith("ROLE_")) {
				roleName = "ROLE_" + roleName;
			}
			return new SimpleGrantedAuthority(roleName);
		}).toList();

		return 
				org.springframework.security.core.userdetails.User.builder().
				username(user.getUsername())
				.password(user.getPassword()).
				authorities(authorities).
				disabled(!user.isEnabled()).
				build();
	}
}