package com.task.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenProvider provider;

	@Autowired
	private UserDetailsService service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = getToken(request);

		if (StringUtils.hasText(token) && provider.validateToken(token)) {
			String email = provider.getEmail(token);

			UserDetails details = service.loadUserByUsername(email);

			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(details,
					null, details.getAuthorities());

			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		
			

		}

		filterChain.doFilter(request, response);

	}

	private String getToken(HttpServletRequest request) {

	    String header = request.getHeader("Authorization");

	    if (StringUtils.hasText(header) && header.startsWith("Bearer")) {
	        return header.substring(7);   // 🔥 remove "Bearer "
	    }

	    return null;
	}
}
