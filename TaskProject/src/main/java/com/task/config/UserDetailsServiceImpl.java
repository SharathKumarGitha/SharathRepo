package com.task.config;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.task.entity.Users;
import com.task.entity.repo.UserRepo;
import com.task.exception.UserNotFound;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo repo;

    public UserDetailsServiceImpl(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        Users user = repo.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Email not found: " + email));

        Set<String> roles = new HashSet<>();
        roles.add("ROLE_ADMIN"); 
        
        //roles.add("ROLE_USER");// get from DB

        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(getAuthority(roles))
                .build();
    }

    private Collection<? extends GrantedAuthority> getAuthority(Set<String> roles) {
        return roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}