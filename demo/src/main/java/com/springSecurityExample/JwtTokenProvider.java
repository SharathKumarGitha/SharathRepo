package com.springSecurityExample;

import java.security.Key;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtTokenProvider {

	private static final String SECRET = "my-super-secret-key-my-super-secret-key-123456";

	// Convert string secret into proper Key
	private Key getSigningKey() {
		return Keys.hmacShaKeyFor(SECRET.getBytes());
	}

	public String generateToken(Authentication authentication) {

		String username = authentication.getName();

		List<String> roles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + 3600000);

		return Jwts.builder().setSubject(username).claim("roles", roles) // 🔥 IMPORTANT
				.setIssuedAt(now).setExpiration(expiryDate).signWith(getSigningKey(), SignatureAlgorithm.HS256)
				.compact();
	}

	public String getUserName(String token) {

		Claims claims = Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();

		return claims.getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJws(token);

			return true;

		} catch (Exception e) {
			return false;
		}
	}
}